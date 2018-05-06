import java.awt.*;
import java.awt.event.*;
import java.awt.font.LineMetrics;
import java.util.*;

// The "Piece" class.

public class Piece
{
	protected Point centre;
	protected int size;
	protected Color colour;

	// Piece Constructors
	public Piece (Point centre, int size, Color colour)
	{
		this.centre = centre;
		this.size = size;
		this.colour = colour;
	}

	// public Piece (Point centre, Color colour)
	//{
	// Create piece with default size (20)
	//this (centre, 20, colour);
	//}

	// Make a piece from another piece
	public Piece (Piece otherPiece)
	{
		this (otherPiece.centre, otherPiece.size, otherPiece.colour);
	}

	// Set the position of a Piece from a point
	public void setPosition (Point newPosition)
	{
		centre = newPosition;
	}

	// Set the position of a Piece from x and y
	public void setPosition (int x, int y)
	{
		centre = new Point (x, y);
	}

	public void move (Point from, Point to)
	{
		centre = new Point (centre.x - from.x + to.x, centre.y - from.y + to.y);
	}

	// Change the colour of a Piece
	public void setColour (Color newColour)
	{
		colour = newColour;
	}

	// Get the colour of a Piece
	public Color getColour ()
	{
		return colour;
	}

	// Check if a point is contained within a piece
	public boolean contains (Point p)
	{
		int distance = (int) (Math.sqrt (Math.pow (p.x - centre.x, 2) +
				Math.pow (p.y - centre.y, 2)));
		return (distance < size / 2);
	}

	// Draw the piece
	public void draw (Graphics g)
	{
		g.setColor (colour);
		System.out.println ("draw: " + centre.x + " - " + centre.y);
		g.fillOval (centre.x - size / 2, centre.y - size / 2, size, size);
		System.out.println ("drawn circle: " + (centre.x-size/2) + " - " + (centre.y-size/2));
	}

	// Draw a piece with a label in the centre
	public void draw (Graphics g, String label)
	{
		// Draw the basic piece first;
		draw (g);

		// Draws the label in the centre of the Piece
		g.setColor (Color.black);
		FontMetrics fm = g.getFontMetrics (g.getFont ());
		g.drawString (label, centre.x - fm.stringWidth (label) / 2, centre.y + fm.getAscent () / 2 - 1);
	}
}
