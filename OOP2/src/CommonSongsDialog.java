import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommonSongsDialog extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private DefaultComboBoxModel<String> DLM,DLM_1;
	private JTextArea textPane;
	
	
	public CommonSongsDialog() throws IOException {
		setBounds(100, 100, 471, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		comboBox = new JComboBox<String>();
		
		comboBox_1 = new JComboBox<String>();
		
		loadBox();

		JLabel lblCd = new JLabel("CD 1");
		
		JLabel lblCd_1 = new JLabel("CD 2");
		
		
		JButton btnFindCommonSongs = new JButton("Find Common Songs");
		//to find the common songs in two CDs by comparing their titles
		btnFindCommonSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<Driver.cds.get(comboBox.getSelectedIndex()).songs.size();i++){
					for(int j=0; j<Driver.cds.get(comboBox_1.getSelectedIndex()).songs.size();j++){
						if(Driver.cds.get(comboBox_1.getSelectedIndex()).songs.get(j).getTitle().equals(Driver.cds.get(comboBox.getSelectedIndex()).songs.get(i).getTitle()))
							textPane.append(Driver.cds.get(comboBox_1.getSelectedIndex()).songs.get(j).getTitle()+"\n");
					}
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, Alignment.TRAILING, 0, 209, Short.MAX_VALUE)
								.addComponent(comboBox_1, Alignment.TRAILING, 0, 188, Short.MAX_VALUE)
								.addComponent(btnFindCommonSongs, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(92)
							.addComponent(lblCd_1))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(92)
							.addComponent(lblCd)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(23)
							.addComponent(lblCd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblCd_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnFindCommonSongs))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		textPane = new JTextArea();
		textPane.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
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
		}
		setVisible(true);
	}
	//to display information on the JCombobox
	public void loadBox() throws IOException{
		DLM=new DefaultComboBoxModel <String>();
		for(int i = 0; i < Driver.cds.size(); i++){
			DLM.addElement(Driver.cds.get(i).getTitle());
		}
		comboBox.setModel(DLM);
		DLM_1=new DefaultComboBoxModel <String>();
		for(int i = 0; i < Driver.cds.size(); i++){
			DLM_1.addElement(Driver.cds.get(i).getTitle());
		}
		comboBox_1.setModel(DLM_1);
	}
}
