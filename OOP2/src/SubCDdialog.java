import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SubCDdialog extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private DefaultListModel<String> DLM;
	private JList<String> list;
	private ArrayList <CD>subCDList=new ArrayList<CD>();
	

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	//constructor of making sub cd
	public SubCDdialog() throws IOException {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the start index");
		
		textField = new JTextField();
		textField.setToolTipText("Enter number you like");
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please enter the end index");
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter number you like");
		textField_1.setColumns(10);
		
		JButton btnMakeSubcd = new JButton("Make Sub-CD");
		btnMakeSubcd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					subList();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnMakeSubcd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPleaseEnterThe)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPleaseEnterThe)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnMakeSubcd)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		{
			list = new JList<String>();
			list.setSelectedIndex(0);
			scrollPane.setViewportView(list);
			loadList();
		}
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						if(subCDList!=null){
							for(int i = 0 ; i< subCDList.size(); i++)
								Driver.cds.remove(Driver.cds.indexOf(subCDList.get(i)));
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
	//to load the information to the list by cd title
	public void loadList() throws IOException{
		DLM=new DefaultListModel <String>();
		for(int i = 0; i < Driver.cds.size(); i++){
			DLM.addElement(Driver.cds.get(i).getTitle());
		}
		list.setModel(DLM);
	}
	//make the sublist by clone it first then change some certain characteristics like time and number of songs
	public void subList() throws IOException, CloneNotSupportedException{
		CD subedCD = (CD) Driver.cds.get(list.getSelectedIndex()).clone();
		subedCD.songs = new ArrayList<Song>(subedCD.songs.subList(Integer.parseInt(textField.getText())-1, Integer.parseInt(textField_1.getText())));
		subedCD.setNumOfSongs();
		subedCD.setTitle("Sub"+subedCD.getTitle());
		subedCD.addTime();
		subCDList.add(subedCD);
		Driver.cds.add(subedCD);
		DLM.addElement(subedCD.getTitle());

	}
}
