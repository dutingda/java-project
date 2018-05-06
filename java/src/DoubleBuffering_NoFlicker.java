// This program will make the mouse cursor NOT freeze when arrow moves quickly off the screen.
// Need 3 things:  1) Update method 
//                 2) Graphics method -- need to draw to offscreenbuffer
//                 3) MouseExited method -- need to update coordinate if x and y are off screen
import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DoubleBuffering_NoFlicker extends JPanel implements MouseListener, MouseMotionListener
{
	int x = 100;
	int y = 100;
	int vX = 100;
	int vY = 100;
	Image image;

	Image offScreenImage;
	Graphics offScreenBuffer;

	public DoubleBuffering_NoFlicker ()
	{
		setPreferredSize(new Dimension(600, 600));

		setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

		image = Toolkit.getDefaultToolkit().getImage("pencil.gif");

		addMouseMotionListener (this);
		addMouseListener (this);
		
	} // Constructor

	public void mouseClicked (MouseEvent e)
	{	
	}

	public void mouseReleased (MouseEvent e) 
	{
	}

	public void mouseEntered(MouseEvent e) 
	{
	}

	public void mouseExited(MouseEvent e) {
		x = e.getX ();
		y = e.getY ();
		if (x > 600)
			x = 600;
		else if (x < 0)
			x = 0;
		if (y > 600)
			y = 600;
		else if (y < 0)
			y = 0;
		repaint ();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseMoved (MouseEvent e) {
		x = e.getX ();
		y = e.getY ();
		repaint ();
	}

	public void mouseDragged (MouseEvent e) {
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paintComponent(Graphics g)
	{
		if (offScreenBuffer == null)
		{
			offScreenImage = createImage (this.getWidth (), this.getHeight ());
			offScreenBuffer = offScreenImage.getGraphics ();
		}

		offScreenBuffer.clearRect (0, 0, this.getWidth (), this.getHeight ());
		offScreenBuffer.drawImage (image, x, y, 30, 30, this);
		g.drawImage (offScreenImage, 0, 0, this);
	}
	
	public static void main (String [] args){

		JFrame frame = new JFrame ("Double Buffering - Avoid Flickering");		
		DoubleBuffering_NoFlicker myPanel = new DoubleBuffering_NoFlicker ();
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);		
	}
}


