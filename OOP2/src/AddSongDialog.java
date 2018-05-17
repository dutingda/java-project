import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AddSongDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JPanel buttonPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox <String>comboBox;
	
	//constructor of adding song 
	public AddSongDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 463, 357);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("Add");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try {
								addMoreSong();
								dispose();
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(buttonPane, "Wrong input", "Alert", JOptionPane.ERROR_MESSAGE);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
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
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		JLabel lblNameOfSong = new JLabel("Name Of Song");
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblNewLabel = new JLabel("Aritist");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		JLabel lblGenre = new JLabel("Genre");
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblRating = new JLabel("Rating");
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5"}));
		
		JLabel lblTime = new JLabel("Time");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(189, Short.MAX_VALUE)
					.addComponent(lblNameOfSong)
					.addGap(184))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(209)
					.addComponent(lblNewLabel)
					.addContainerGap(215, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(210)
					.addComponent(lblGenre)
					.addContainerGap(217, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(211)
					.addComponent(lblRating)
					.addContainerGap(212, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(213)
					.addComponent(lblTime)
					.addContainerGap(219, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(194)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(199, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(159)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(textField_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
					.addGap(161))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNameOfSong)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGenre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRating)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTime)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}
	//Descrption: the method that add the song with the area of information in the field
	//Parameters:/
	//return:/
	private void addMoreSong() throws IOException{
		// TODO Auto-generated method stub
		
		String s1 = textField.getText();
		String s2 = textField_1.getText();
		String s3 = textField_2.getText();
		int d1 = Integer.parseInt((String) comboBox.getSelectedItem());
		Time t1 = new Time(Integer.parseInt(textField_3.getText()));
		Song song1 = new Song(s1, s2, s3, d1, t1);
		Driver.accessedCD.addSong(song1);
		Driver.accessedCD.addTime();
		
	}

}
