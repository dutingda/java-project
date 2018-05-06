// The "FramesAndImages" class.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FramesAndImages_UsingGraphics extends JPanel implements MouseListener
{
	
	JLabel picLabel, message;
	int imageNo;
	Image [] images;

	public FramesAndImages_UsingGraphics ()
	{
		setPreferredSize(new Dimension(400, 400));
		
		images = new Image [5];

		for (int imageNo = 0 ; imageNo < 5 ; imageNo++)
		{
			String imageFileName = "pic" + imageNo + ".gif";
			images [imageNo]= Toolkit.getDefaultToolkit().getImage(imageFileName);
		}

		//contentPane = new JPanel ();
		setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));
		setBackground (Color.white);
		setBorder (BorderFactory.createEmptyBorder (10,10,10,10));
		message = new JLabel ("Image #" + (imageNo + 1));
		  
	    add (message);
		addMouseListener (this);
	} // Constructor

	public void mouseClicked (MouseEvent e)
	{
		imageNo++;
		if (imageNo > 4)
			imageNo = 0;
		
		repaint ();

	}
	public void mouseReleased (MouseEvent e) 
	{
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage (images[imageNo],10,10,this);
        message.setText ("Image #" + (imageNo + 1));
		//g.finalize();
	}
	
	
	public static void main (String [] args){
		JFrame frame = new JFrame ("Displaying Images");      // Set the frame's name
		FramesAndImages_UsingGraphics myPanel = new FramesAndImages_UsingGraphics ();
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);

	}

}


