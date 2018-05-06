import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;

// Example with a button click

public class BasicJFrameWithMouse implements ActionListener{
	
	JFrame frame;
	JPanel myPanel;
	JLabel label;
	JButton button;
	
	public BasicJFrameWithMouse () {
		frame = new JFrame ("Basic JFrame With Mouse Example");
		frame.setPreferredSize(new Dimension(200, 250));
		frame.setLocation(200, 200);
		
		myPanel = new JPanel ();
		label = new JLabel ("Hello World!");
		
		button = new JButton ("Hide");
		button.setActionCommand ("Hide");
		button.addActionListener(this);
		
		myPanel.add (label);
		myPanel.add (button);
		
		frame.add (myPanel);
		frame.pack ();
		frame.setVisible (true);
		
	}
	
	public void actionPerformed (ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.equals ("Hide")) {
			label.setText("");
			button.setText("Show");
			button.setActionCommand ("Show");
		}
		else {
			label.setText ("Hello, World!");
			button.setText ("Hide");
			button.setActionCommand ("Hide");
		}
	}
	
	public static void main (String [] args){
				new BasicJFrameWithMouse ();		
	}
}
