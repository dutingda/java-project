// The "JOptionPaneDemo" class.
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.*;

public class JOptionPaneDemo implements MouseListener
{
	JFrame frame;
	JPanel myPanel;
	JLabel message;
	int x, y;

	public JOptionPaneDemo ()
	{
		frame = new JFrame ("JOptionPaneDemo");
		myPanel = new JPanel ();
		
		myPanel.setPreferredSize(new Dimension(400, 400));
		myPanel.setLocation (100, 100);
		
		myPanel.setLayout (new BoxLayout (myPanel, BoxLayout.PAGE_AXIS));
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));		
		
		message = new JLabel ("Click the mouse in this window to see" + " a choice of JOptionPane's");
		myPanel.add (message);
        myPanel.addMouseListener (this);
        
        frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);	
	} // Constructor

	public void mouseClicked (MouseEvent e)
	{
		// Use a message dialog to show the x, y position of the mouse click
		JOptionPane.showMessageDialog (myPanel, "x: " + e.getX () + " y: " + e.getY(),
				"Mouse Click Position", JOptionPane.INFORMATION_MESSAGE);

		// Create a dialog to input information
		String name;
		name = JOptionPane.showInputDialog (myPanel, "Please enter your name");

		// Show a message using a message dialog
		if (name == null)
			JOptionPane.showMessageDialog (myPanel, "You selected Cancel",
					"Message", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog (myPanel, "Welcome " + name, "Message",
					JOptionPane.INFORMATION_MESSAGE);

		// The confirm dialog can be used with an if to check
		// which button was selected on the dialog box
		if (JOptionPane.showConfirmDialog (myPanel, "Do you want to Play Again?",
				"Message", JOptionPane.YES_NO_OPTION) ==
				JOptionPane.YES_OPTION)
			JOptionPane.showMessageDialog (myPanel, "Good Luck", "Message",
					JOptionPane.INFORMATION_MESSAGE);
		else
		{
			JOptionPane.showMessageDialog (myPanel, "Goodbye", "Message",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit (0);
		}

		// Using arrays you can create a multiple object message
		ImageIcon iconImage = new ImageIcon ("strawberry.gif");
		Object[] objects = {"Text and ", iconImage, "an Icon Image"};
		JOptionPane.showMessageDialog (myPanel, objects,
				"Multiple Object Message", JOptionPane.INFORMATION_MESSAGE);

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
		new JOptionPaneDemo ();
		
	}


}