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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CopyCDdialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DefaultListModel<String> DLM;
	private JList<String> list;
	private ArrayList <CD> copyCDList=new ArrayList<CD>();

	

	/**
	 * @throws IOException 
	 */
	//constructor for the copy CD part
	public CopyCDdialog() throws IOException {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		JButton btnMakeACopy = new JButton("Make a Copy");
		btnMakeACopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					copyList();
				} catch (IOException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(156)
							.addComponent(btnMakeACopy)))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btnMakeACopy)
					.addContainerGap())
		);
		{
			list = new JList<String>();
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
						//remove one by one from the temporary adding list to activate the cancel function
						if(copyCDList!=null){
							for(int i=0; i< copyCDList.size(); i++)
								Driver.cds.remove(Driver.cds.indexOf(copyCDList.get(i)));
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
	//to load the information on the list by title
	public void loadList() throws IOException{
		DLM=new DefaultListModel <String>();
		for(int i = 0; i < Driver.cds.size(); i++){
			DLM.addElement(Driver.cds.get(i).getTitle());
		}
		list.setModel(DLM);
	}
	//to add the item to list model also the ArrayList of CDs when hit the button
	public void copyList() throws IOException, CloneNotSupportedException{
		CD copyedCD=(CD) Driver.cds.get(list.getSelectedIndex()).clone();
		copyedCD.setTitle(copyedCD.getTitle()+"Copy");
		copyCDList.add(copyedCD);
		Driver.cds.add(copyedCD);
		DLM.addElement(copyedCD.getTitle());
	}

}
