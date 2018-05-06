package test;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class TestDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TestDialog dialog = new TestDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public TestDialog() throws IOException {
		setBounds(100, 100, 602, 432);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		BufferedReader inFile = new BufferedReader(new FileReader("output.txt"));
		ArrayList <String> values = new ArrayList<String>();
		while(inFile.readLine()!=null)
			values.add(inFile.readLine());
		JList <String>list_2 = new JList<String>();
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setModel(new AbstractListModel() {
			public int getSize() {
				return values.size();
			}
			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
				.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
							.addGap(33)))
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
