import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

// Text fields help get input from the user
public class BasicJFrameWithColours implements ActionListener{

	JFrame frame;
	JPanel myPanel;
	JTextField name;
	JButton displayMessage;
	JLabel textFieldPrompt, hello;

	public BasicJFrameWithColours () {
		frame = new JFrame ("Basic JFrame with Colours Example");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(300, 300));
		frame.setLocation(200, 200);

		myPanel = new JPanel ();
		myPanel.setLayout (new GridLayout (0,2,5,10));
		myPanel.setBackground (Color.white);
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));		

		textFieldPrompt = new JLabel ("Type in your name: ");
		textFieldPrompt.setForeground(Color.red);

		name = new JTextField (10);
		name.setBackground (Color.pink);
		name.setForeground (Color.darkGray);

		displayMessage = new JButton ("Display Message");
		displayMessage.setBackground (Color.yellow);
		displayMessage.setForeground (Color.blue);
		displayMessage.addActionListener (this);

		hello = new JLabel (" ");
		hello.setForeground (Color.green);

		myPanel.add (textFieldPrompt);
		myPanel.add (name);
		myPanel.add (displayMessage);
		myPanel.add (hello);

		frame.add (myPanel);
		frame.pack ();
		frame.setVisible (true);		
	}

	public void actionPerformed (ActionEvent event) {

		String text = name.getText ();
		hello.setText ("Hello " + text);

	}

	public static void main (String [] args){
		new BasicJFrameWithColours ();
	}
}
