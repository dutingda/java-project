import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;


// There are many different layout managers

public class BasicJFrameWithLayouts implements ActionListener{
	
	JFrame frame;
	JPanel myPanel;
	JLabel label;
	JButton button;
	
	public BasicJFrameWithLayouts () {
		frame = new JFrame ("Basic JFrame With Layout Example");
		frame.setPreferredSize(new Dimension(200, 250));
		frame.setLocation(200, 200);


		myPanel = new JPanel ();
		myPanel.setLayout (new BoxLayout (myPanel, BoxLayout.Y_AXIS));
		myPanel.setBorder (BorderFactory.createEmptyBorder (20,20,20,20));		
		
		label = new JLabel ("Hello World!");
		label.setAlignmentX (JLabel.CENTER_ALIGNMENT);
		label.setBorder (BorderFactory.createEmptyBorder (20,50,20,50));		
		
		button = new JButton ("Hide");
		button.setAlignmentX (JButton.CENTER_ALIGNMENT);
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
				new BasicJFrameWithLayouts ();	
	}
}
