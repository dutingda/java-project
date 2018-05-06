import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

// Text fields help get input from the user
public class BasicJFrameWithComboBox implements ActionListener{

	JFrame frame;
	JPanel myPanel;

	JComboBox <String> plantNames;
	JLabel plantLabel, latinName;

	public BasicJFrameWithComboBox () {
		frame = new JFrame ("Basic JFrame with Combo Box Example");
		frame.setPreferredSize(new Dimension(400, 100));
		frame.setLocation(200, 200);

		myPanel = new JPanel ();
		myPanel.setLayout (new BoxLayout (myPanel, BoxLayout.PAGE_AXIS));
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));		

		plantLabel = new JLabel ("Select a plant name:");
		plantLabel.setAlignmentX (JLabel.LEFT_ALIGNMENT);
		String[] names = {"basil", "lavender", "parsley", "saffron", "sage"};
		plantNames = new JComboBox (names);
		plantNames.setAlignmentX (JComboBox.LEFT_ALIGNMENT);
		plantNames.setSelectedIndex (0);
		plantNames.addActionListener (this);
		latinName = new JLabel ("Ocimum");
		latinName.setBorder (BorderFactory.createEmptyBorder (20,0,0,0));

		myPanel.add (plantLabel);
		myPanel.add (plantNames);
		myPanel.add (latinName);

		frame.add (myPanel);
		frame.pack ();
		frame.setVisible (true);		
	}

	public void actionPerformed (ActionEvent event) {
		JComboBox comboBox = (JComboBox)event.getSource ();
		String plant = (String)comboBox.getSelectedItem ();

		if (plant == "basil")
			latinName.setText ("Ocimum");
		else if (plant == "lavender")
			latinName.setText ("Lavandula spica");
		else if (plant == "parsley")
			latinName.setText ("Apium");
		else if (plant == "peppermint")
			latinName.setText ("Mentha piperita");
		else if (plant == "saffron")
			latinName.setText ("Crocus");
		else if (plant == "sage")
			latinName.setText ("Salvia");

	}

	public static void main (String [] args){
		new BasicJFrameWithComboBox ();		
	}
}
