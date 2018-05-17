import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class removeSongDialog  extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1,rdbtnNewRadioButton_2,rdbtnNewRadioButton_3;
	private ArrayList <Song> removedSong=new ArrayList<Song>();
	private JList <String>list;
	private DefaultListModel<String> DLM;

	//constructor of removing songs
	public removeSongDialog() throws IOException {
		setBounds(100, 100, 450, 307);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setEditable(false);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					removeSongOptions();
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		
		rdbtnNewRadioButton = new JRadioButton("Remove By Title");
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton_1 = new JRadioButton("Remove By Number");
		rdbtnNewRadioButton_1.addActionListener(this);
		rdbtnNewRadioButton_2 = new JRadioButton("Remove First Song");
		rdbtnNewRadioButton_2.addActionListener(this);
		rdbtnNewRadioButton_3 = new JRadioButton("Remove Last Song");
		rdbtnNewRadioButton_2.addActionListener(this);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(rdbtnNewRadioButton_2)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(rdbtnNewRadioButton_3)
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
									.addGap(11)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(20)
							.addComponent(rdbtnNewRadioButton)
							.addGap(2)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNewRadioButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNewRadioButton_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNewRadioButton_3)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnRemove))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		Collections.sort(Driver.accessedCD.songs);
		loadList();
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
						if(removedSong!=null){
							for(int i=0; i<removedSong.size(); i++){
								Driver.accessedCD.songs.remove(Driver.accessedCD.songs.indexOf(removedSong.get(i)));
							}
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
		setVisible(true);
	}
	//when the user hit the remove button then perform different kind of remove
	private void removeSongOptions(){
		if(rdbtnNewRadioButton.isSelected()){
			 int index = Collections.binarySearch(Driver.accessedCD.songs,new Song(textField.getText(),null,null,0,new Time(0)));
			DLM.removeElementAt(index);
			 removedSong.add(Driver.accessedCD.songs.get(index));
		}
		if(rdbtnNewRadioButton_1.isSelected()){
			DLM.removeElementAt(Integer.parseInt(textField_1.getText())-1);
			removedSong.add(Driver.accessedCD.songs.get(Integer.parseInt(textField_1.getText())-1));
		}
		if(rdbtnNewRadioButton_2.isSelected()){
			DLM.removeElementAt(0);
			removedSong.add(Driver.accessedCD.songs.get(0));
		}
		if(rdbtnNewRadioButton_3.isSelected()){
			DLM.removeElementAt(DLM.getSize()-1);
			removedSong.add(Driver.accessedCD.songs.get(Driver.accessedCD.songs.size()-1));
		}
	}
	//to load the title of songs in the CD to the list with number labeling
	public void loadList() throws IOException{
		DLM=new DefaultListModel <String>();
		for(int i = 0; i < Driver.accessedCD.songs.size(); i++){
			DLM.addElement((i+1)+": "+Driver.accessedCD.songs.get(i).getTitle());
		}
		list.setModel(DLM);
	}
	//to set the listener to the radiobutton to avoid the textfield being activated
	public void actionPerformed(ActionEvent e) {
		if(rdbtnNewRadioButton.isSelected())
			textField.setEditable(true);
		else
			textField.setEditable(false);

		if(rdbtnNewRadioButton_1.isSelected())
			textField_1.setEditable(true);
		else
			textField_1.setEditable(false);

	}

}
