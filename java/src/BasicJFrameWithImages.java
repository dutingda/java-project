import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

// Adding images to labels and buttons
public class BasicJFrameWithImages implements ActionListener{
	
	JFrame frame;
	JPanel myPanel;
	JButton rollDie;
	JLabel dieFace;
	
	public BasicJFrameWithImages () {
		frame = new JFrame ("Basic JFrame with Images Example");
		frame.setPreferredSize(new Dimension(200, 250));
		frame.setLocation(200, 200);
	
		myPanel = new JPanel ();
		myPanel.setLayout (new BoxLayout (myPanel, BoxLayout.PAGE_AXIS));
		myPanel.setBackground (Color.white);
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));		
		
		// Setting an image to the label
		dieFace = new JLabel (new ImageIcon ("die1.gif"));
		dieFace.setAlignmentX (JLabel.CENTER_ALIGNMENT);
		//dieFace.setBorder (BorderFactory.createEmptyBorder (0,0,10,10));
		
		// Adding an image to the button
		rollDie = new JButton ("Roll");
		ImageIcon icon = new ImageIcon ("dice.jpg");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance (20,20,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon (newImg);
		
		rollDie.setIcon (newIcon);
		rollDie.setAlignmentX(JButton.CENTER_ALIGNMENT);
		rollDie.addActionListener (this);
				
		myPanel.add (dieFace);
		myPanel.add (rollDie);
		
		frame.add (myPanel);
		frame.pack ();
		frame.setVisible (true);		
	}
	
	public void actionPerformed (ActionEvent event) {
		int num = (int) (Math.random() * 6)+1;
		if (num == 1)
			dieFace.setIcon (new ImageIcon ("die1.gif"));
		else if (num == 2)
			dieFace.setIcon (new ImageIcon ("die2.gif"));
		else if (num == 3)
			dieFace.setIcon (new ImageIcon ("die3.gif"));
		else if (num == 4)
			dieFace.setIcon (new ImageIcon ("die4.gif"));
		else if (num == 5)
			dieFace.setIcon (new ImageIcon ("die5.gif"));
		else
			dieFace.setIcon (new ImageIcon ("die6.gif"));
	}
	
	public static void main (String [] args){
				new BasicJFrameWithImages ();
	}
}
