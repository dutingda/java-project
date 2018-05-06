// The "MoveAPieceDemo" class.
import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class MoveAPieceFrameDemo implements ActionListener, ItemListener, MouseListener, MouseMotionListener 
{
	JFrame frame;
	MyPanelClass drawPanel, infoPanel, statusPanel;
	MyPanelClass myPanel;
	Piece [] myPieces;
	int noOfPieces;

	JButton clearPieces;
	JCheckBox red, green, blue;
	Color currentColour;
	JCheckBox includeLabel;
	JLabel statusMessage;

	int selectedPiece;
	Point lastPoint;

	public MoveAPieceFrameDemo ()
	{
		frame = new JFrame ("Moving a piece");
		myPanel = new MyPanelClass();
		
		frame.setPreferredSize(new Dimension(500, 400));
		frame.setLocation (100, 100);
	
		myPanel.setLayout (new BorderLayout ());
		infoPanel = new MyPanelClass ();
		drawPanel = new MyPanelClass ();

		red = new JCheckBox ("red", true);
		currentColour = Color.red;
		green = new JCheckBox ("green", false);
		blue = new JCheckBox ("blue", false);
		red.addItemListener (this);
		green.addItemListener (this);
		blue.addItemListener (this);
		includeLabel = new JCheckBox ("Include Label", true);
		includeLabel.addItemListener(this);

		infoPanel.add (new JLabel ("Colour of Piece"));
		infoPanel.add (red);
		infoPanel.add (green);
		infoPanel.add (blue);
		infoPanel.add (includeLabel);

		myPanel.add ("North", infoPanel);
		myPanel.add ("Center", drawPanel);

		// Create a status panel with a message area and clear button
		statusPanel = new MyPanelClass ();
		clearPieces = new JButton ("Clear Pieces");
		clearPieces.setActionCommand("Clear");
		clearPieces.addActionListener(this);
		statusPanel.add (clearPieces);

		statusMessage = new JLabel ("Welcome to the Move a Piece Demo");
		statusPanel.add (statusMessage);
		myPanel.add ("South", statusPanel);
		selectedPiece = -1;
		noOfPieces = 0;
		myPieces = new Piece [200];

		myPanel.addMouseListener(this);
		myPanel.addMouseMotionListener (this);

		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);	

	} // MoveAPieceFrameDemo constructor


	public void mouseClicked (MouseEvent e)
	{	
		System.out.println ("CLICKED: " + e.getX() + " - " + e.getY());
	}

	public void mouseReleased (MouseEvent e) 
	{
		if (selectedPiece >= 0)
		{
			selectedPiece = -1;
			showStatus ("Piece Dropped");
		}
	}
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		//System.out.println ("infoPanel: " + infoPanel.getHeight());
		Point selectedPoint = new Point (e.getX (), e.getY ()  - infoPanel.getHeight ()); // must minus the height of the panel above
		System.out.println (e.getX () + " - " + e.getY ());

		// Check if we are selecting one of the pieces
		for (int i = 0 ; i < noOfPieces ; i++)
			if (myPieces [i].contains (selectedPoint))
			{
				selectedPiece = i;
				lastPoint = selectedPoint;
				showStatus ("Selected Piece #" + i);
			}

		// Create a new piece in this spot with the current colour
		if ( (noOfPieces < 200) && selectedPiece == -1)
		{
			myPieces [noOfPieces] = new Piece (selectedPoint, 30, currentColour);
			noOfPieces++;
			showStatus ("Creating a new Piece");
			myPanel.repaint ();
		}
	}

	public void mouseMoved (MouseEvent e) {
		// Set the cursor to the hand if we are on that piece
		Point currentPoint = new Point (e.getX (), e.getY ()- infoPanel.getHeight ()); // must minus the height of the panel above


		for (int i = 0 ; i < noOfPieces ; i++)
			if (myPieces [i].contains (currentPoint))
			{
				myPanel.setCursor (Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
				showStatus ("Piece #" + i);
			}

		// Otherwise we just use the default cursor
		showStatus ("No pieces here...");
		myPanel.setCursor (Cursor.getDefaultCursor ());
	}

	public void mouseDragged (MouseEvent e) {
		Point currentPoint = new Point (e.getX (), e.getY () - infoPanel.getHeight ());

		if (selectedPiece >= 0)
		{
			showStatus ("Moving Piece #" + selectedPiece);
			myPieces [selectedPiece].move (lastPoint, currentPoint);
			lastPoint = currentPoint;
			myPanel.repaint ();
		}
	}

	public void actionPerformed (ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.equals("Clear")) {
			noOfPieces = 0;
			myPanel.repaint ();
		}
	}

	public void itemStateChanged(ItemEvent event) {		
		if (event.getSource() == red) 
			currentColour = Color.red;
		else if (event.getSource() == green) 
			currentColour = Color.green;
		else if (event.getSource() == blue) 
			currentColour = Color.blue;
		else if (event.getSource() == includeLabel) 
			myPanel.repaint ();
	}

	// Changes the statusMessage
	public void showStatus (String message)
	{
		statusMessage.setText (message);
	}
	
	// Make all the panels of this new class, so they can be repainted using paintComponent
	
	public class MyPanelClass extends JPanel {
		public void paintComponent(Graphics g)
		{			
		super.paintComponent(g);
		if (noOfPieces == 0) {
			Color c = myPanel.getBackground();
			g.setColor(c);
			g.clearRect(0,0,500, 400);
			g.fillRect (0,0,500,400);
		}

		System.out.println ("PAINT " + noOfPieces);
		// Draw the pieces
		for (int i = 0 ; i < noOfPieces ; i++) {
			
			if (includeLabel.isSelected () == true)
				myPieces [i].draw (g, String.valueOf (i));
			else
				myPieces [i].draw (g);
		}
		// Draw the selected piece last (on top)
		if (selectedPiece >= 0)
			if (includeLabel.isSelected () == true)
				myPieces [selectedPiece].draw (g, String.valueOf (selectedPiece));
			else
				myPieces [selectedPiece].draw (g);		
		}
	}

	public static void main (String [] args){
		new MoveAPieceFrameDemo();
	}
}

