import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeCursor
{
	JFrame frame;
	JPanel myPanel;
	Image image;

	public ChangeCursor ()
	{
		frame = new JFrame ("Change Cursor Demo");
		myPanel = new JPanel ();

		myPanel.setPreferredSize(new Dimension(400, 500));
		myPanel.setBackground (new Color (150, 150, 200));

		// Loading the image into an Image object
		image = Toolkit.getDefaultToolkit().getImage("pencil.gif");

		// Defining the hotspot to the centre of the object
		Point hotspot = new Point (0, 0);
		Toolkit toolkit = Toolkit.getDefaultToolkit ();
		Cursor cursor = toolkit.createCustomCursor (image, hotspot, "pen");
		frame.setCursor (cursor);
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);


	}

	public static void main (String [] args)
	{
		new ChangeCursor ();

		

	} 
}


