import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class DisplayOneSongDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JScrollPane scrollPane,textScroll;
	private JList<String> list;
	private JTextArea textPane;
	
	public DisplayOneSongDialog() throws IOException {
		setBounds(100, 100, 602, 432);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
		
		

		textPane = new JTextArea(30,30);
		
		textPane.setEditable(false);
		textPane.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		textScroll = new JScrollPane();
		textScroll.setViewportView(textPane);
		
		scrollPane = new JScrollPane();
		list = new JList<String>();
		scrollPane.setViewportView(list);
		loadList();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(textScroll, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
				.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
								.addComponent(textScroll, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
							.addGap(33)))
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		//enable the listener of the list to make it correspond to user's selection in the list
		list.getSelectionModel().addListSelectionListener(e -> {
            textPane.setText(Driver.accessedCD.songs.get(list.getSelectedIndex()).toString());
        });				
		getContentPane().setLayout(groupLayout);
		setVisible(true);

	}
	// to load a series of songs in the list
	public void loadList() throws IOException{
		DefaultListModel<String> DLM=new DefaultListModel <String>();
		for(int i = 0; i < Driver.accessedCD.songs.size(); i++){
			DLM.addElement(Driver.accessedCD.songs.get(i).getTitle());
		}
		list.setModel(DLM);
	}
}