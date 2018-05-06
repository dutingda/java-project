import java.awt.Dimension;

import javax.swing.*;

public class BasicJFrame {

	JFrame frame;
	JPanel myPanel;
	JLabel label;
	JButton button;

	public BasicJFrame () {
		frame = new JFrame ("Basic JFrame Example");
		frame.setPreferredSize(new Dimension(200, 200));
		frame.setLocation(200, 200);

		myPanel = new JPanel ();
		label = new JLabel ("Hello World!");
		button = new JButton ("Hide");

		myPanel.add (label);
		myPanel.add (button);

		frame.add (myPanel);
		frame.pack ();
		frame.setVisible (true);

	}

	public static void main (String [] args){
		new BasicJFrame ();
	}
}
