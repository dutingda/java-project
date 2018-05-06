import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

// Text fields help get input from the user
public class BasicJFrameTextFields implements ActionListener{
	
	JFrame frame;
	JPanel myPanel;
	JLabel label1, label2, label3, averageLabel;
	JTextField text1, text2, text3;
	JButton button;
	
	public BasicJFrameTextFields () {
		frame = new JFrame ("Basic JFrame with TextField Example");
		frame.setPreferredSize(new Dimension(800, 400));
		frame.setLocation(200, 200);
	
		myPanel = new JPanel ();
		myPanel.setLayout (new GridLayout (0,2,10,5));
		myPanel.setBorder (BorderFactory.createEmptyBorder (50,50,50,50));		
		
		label1 = new JLabel ("Enter the first mark: ");
		label1.setBorder(BorderFactory.createEmptyBorder (10,0,50,10));
		label2 = new JLabel ("Enter the second mark: ");
		label3 = new JLabel ("Enter the third mark: ");
		averageLabel = new JLabel ("");
		averageLabel.setBorder (BorderFactory.createEmptyBorder(10, 200, 10, 10));
		
		text1 = new JTextField ();
	
		text2 = new JTextField ();
		text3 = new JTextField ();
		
		button = new JButton ("Average");
		button.setActionCommand ("Average");
		button.addActionListener (this);
		
		
		myPanel.add (label1);
		myPanel.add (text1);
		myPanel.add(Box.createRigidArea(new Dimension(20,0))); // adding space in between
		myPanel.add(Box.createRigidArea(new Dimension(20,0)));
		myPanel.add (label2);
		myPanel.add (text2);
		myPanel.add (label3);		
		myPanel.add (text3);
		myPanel.add (button);
		myPanel.add (averageLabel);
	
		frame.add (myPanel);
		frame.pack ();
		frame.setVisible (true);
		
	}
	
	public void actionPerformed (ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.equals ("Average")) {
			double ave;
			String m1 = text1.getText ();
			String m2 = text2.getText ();
			String m3 = text3.getText ();
			ave = Double.parseDouble(m1) + Double.parseDouble (m2) + Double.parseDouble(m3);
			ave /= 3;
			averageLabel.setText (Double.toString (ave));
		}
	}
	
	public static void main (String [] args){
				new BasicJFrameTextFields ();
	}
}
