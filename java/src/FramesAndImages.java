// The "FramesAndImages" class.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FramesAndImages implements MouseListener
{
	JFrame frame;
	JPanel myPanel;
	ImageIcon[] images; // An array of 5 images
	JLabel picLabel, message;
	int imageNo;

	public FramesAndImages ()
	{		
		frame = new JFrame ("Displaying Images"); 
		myPanel = new JPanel ();

		myPanel.setPreferredSize(new Dimension(400, 400));
		myPanel.setLayout (new BoxLayout (myPanel, BoxLayout.PAGE_AXIS));
		myPanel.setBackground (Color.white);
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));

		images = new ImageIcon [5];
		for (int imageNo = 0 ; imageNo < 5 ; imageNo++)
		{
			String imageFileName = "pic" + imageNo + ".gif";
			images [imageNo] = new ImageIcon (imageFileName);
		}

		imageNo = 0;
		picLabel = new JLabel (images[imageNo]);

		message = new JLabel ("Image #" + (imageNo + 1));
		myPanel.add (picLabel);
		myPanel.add (message);
		myPanel.addMouseListener (this);

		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);		
	} // Constructor

	public void mouseClicked (MouseEvent e)
	{
		imageNo++;
		if (imageNo > 4)
			imageNo = 0;
		picLabel.setIcon(images[imageNo]);
		message.setText ("Image #" + (imageNo + 1));
	}

	public void mouseReleased (MouseEvent e) 
	{
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public static void main (String [] args){
		new FramesAndImages ();
	}
}