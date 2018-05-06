import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.text.NumberFormat;

/** Purpose: To run a United Way 50/50 Draw in a Window (Frame)
 */
public class UnitedWay5050Draw extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	// Constants
	static final int MAX_TICKETS = 200;
	static final double TICKET_PRICE = 0.50;
	static final NumberFormat currency = NumberFormat.getCurrencyInstance ();
	static final Font TITLE_FONT = new Font ("Comic Sans MS", Font.PLAIN, 32);
	static final Font LABEL_FONT = new Font ("Arial", Font.PLAIN, 16);

	// Variables for objects in the frame
	private JTextField nameBox;
	private JTextField noOfTicketsBox;
	private JButton buyTicketsButton;
	private JButton drawButton;
	private List ticketStubs;

	// Variables to keep track of the draw
	private String [] listOfNames;
	private int noOfTicketsLeft;
	private double prizeMoney;
	private int nextTicket;
	private boolean drawComplete;
	private String winner;
	private int winningTicket;

	/** Constructor for the UnitedWay5050Draw Frame object
	 */
	public UnitedWay5050Draw ()
	{
		setPreferredSize(new Dimension(500, 400));
		setLocation (100, 100);
		setBackground (Color.lightGray);
		
		setLayout (null);
		
		//	frame.setIconImages (new ImageIcon ("5050icon.gif"));

		// Setting a null layout allows you to place your components in
		// the frame anywhere you want using the setBounds method
		// You must set the bounds of each object before adding it to the frame
		//setLayout (null);

		// Text box for the person's name
		nameBox = new JTextField ();
		nameBox.setBounds (50, 100, 150, 25);
		nameBox.setFont (LABEL_FONT);
		add (nameBox);

		// Text box for the no of tickets bought
		noOfTicketsBox = new JTextField ("0");
		noOfTicketsBox.setBounds (250, 100, 50, 25);
		noOfTicketsBox.setFont (LABEL_FONT);
		add (noOfTicketsBox);

		// A button to say when to buy the ticket
		buyTicketsButton = new JButton ("Buy Tickets");
		buyTicketsButton.setBounds (350, 100, 100, 30);
		buyTicketsButton.setActionCommand("Buy");
		buyTicketsButton.addActionListener(this);
		add (buyTicketsButton);

		// A button to say when to start the Draw
		drawButton = new JButton ("Start the Draw");
		drawButton.setBounds (200, 350, 100, 30);
		drawButton.setActionCommand("Draw");
		drawButton.addActionListener(this);
		add (drawButton);
		drawButton.setVisible (false);

		// A list box for the tickets bought
		ticketStubs = new List (5);
		ticketStubs.setBounds (50, 200, 200, 140);
		add (ticketStubs);
		ticketStubs.setVisible (false);

		// Set up the program variables
		noOfTicketsLeft = MAX_TICKETS;
		listOfNames = new String [MAX_TICKETS + 1];
		nextTicket = 1;
		prizeMoney = 0;
		drawComplete = false;
	}


	/** Handles the button events
	 * @param event the event that occurred (can indicate which button)
	 * @param arg   other arguments associated with this event
	 */
	public void actionPerformed (ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.equals("Buy"))
		{
			buyTheTicket ();
		}
		else if (eventName.equals("Draw")) 
		{
			drawTheWinner ();
		}

	}

	/** Processing the buying of a ticket
	 * Includes error checks for the name and the number of tickets
	 */
	public void buyTheTicket ()
	{
		// Get the data from the text boxes
		String name = nameBox.getText ().trim ();
		int noOfTicketsBought = Integer.parseInt (noOfTicketsBox.getText ());

		// Check for input errors
		if (name.length () == 0)
			JOptionPane.showMessageDialog (this, "You must enter a Name",
					"Message", JOptionPane.WARNING_MESSAGE);
		else if (noOfTicketsBought <= 0)
			JOptionPane.showMessageDialog (this, "Illegal Number of Tickets",
					"Message", JOptionPane.WARNING_MESSAGE);
		else if (noOfTicketsBought > noOfTicketsLeft)
		{
			JOptionPane.showMessageDialog (this, "We only have " +
					noOfTicketsLeft + " tickets left", "Message",
					JOptionPane.WARNING_MESSAGE);
			noOfTicketsBox.setText (String.valueOf (noOfTicketsLeft));
		}
		// Confirm the purchase
		else if (JOptionPane.showConfirmDialog (this,
				"Name: " + name
				+ "\nNo. of Tickets Bought: " + noOfTicketsBought
				+ "\nTotal Cost: " +
				currency.format (noOfTicketsBought * TICKET_PRICE)
				+ "\nIs this information correct?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		{
			// Fill in the array and add the names to the ticket stubs list
			for (int ticket = 1 ; ticket <= noOfTicketsBought ; ticket++)
			{
				ticketStubs.add ("Ticket No: " + nextTicket + "-> " + name);
				listOfNames [nextTicket] = name;
				nextTicket++;
			}

			// Update ticketsLeft and the prize money
			noOfTicketsLeft -= noOfTicketsBought;
			prizeMoney += noOfTicketsBought * TICKET_PRICE / 2;

			// Now that at least one ticket has been bought
			// we can show the drawButton and the ticketStubs list
			if (!drawButton.isVisible ())
			{
				drawButton.setVisible (true);
				ticketStubs.setVisible (true);
			}

			// If you ran out of tickets, prompt to start draw
			if (noOfTicketsLeft == 0)
			{
				if (JOptionPane.showConfirmDialog (this,
						"All the tickets have been sold"
								+ "\nDo you want to want to draw the winner?",
								"Confirm", JOptionPane.YES_NO_OPTION)
								== JOptionPane.YES_OPTION)
				{
					drawTheWinner ();
				}
				buyTicketsButton.setVisible (false);
			}

			// Refresh the screen
			nameBox.setText ("");
			noOfTicketsBox.setText ("0");
			repaint ();
		}
	}


	/** Draws the winning ticket if at least one ticket is sold
	 * Gives the user a chance to confirm the draw
	 */
	public void drawTheWinner ()
	{
		// Only draw if all of the tickets are sold or they confirm
		if (noOfTicketsLeft == 0 ||
				JOptionPane.showConfirmDialog (this,
						"You have only sold " + (MAX_TICKETS - noOfTicketsLeft)
						+ " of " + MAX_TICKETS + " tickets"
						+ "\nDo you want to start the draw early?", "Confirm",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		{
			// Draw the winner and show the results
			winningTicket = (int) (Math.random () * (nextTicket - 1) + 1);
			winner = listOfNames [winningTicket];
			JOptionPane.showMessageDialog (this, "Winner: " + winner
					+ "\nWinning Ticket No: " + winningTicket
					+ "\nTotal Winnings: " + currency.format (prizeMoney),
					"Winner", JOptionPane.INFORMATION_MESSAGE);

			// Draw is over, hide the buttons and text fields
			drawButton.setVisible (false);
			buyTicketsButton.setVisible (false);
			noOfTicketsBox.setVisible (false);
			nameBox.setVisible (false);
			drawComplete = true;
			repaint ();
		}
	}

	public void paintComponent (Graphics g) {
		super.paintComponent (g);
		g.setColor (Color.green);
		System.out.println ("IN PAINT");
		g.setFont (TITLE_FONT);
		g.drawString ("United Way 50/50 Draw", 65, 60);
		g.setFont (LABEL_FONT);

		if (ticketStubs.isVisible ())
		{
			g.setColor (Color.black);
			g.drawString ("Tickets Bought: ", 70, 190);
		}
		if (!drawComplete)
		{
			g.setColor (Color.blue);
			g.drawString ("Name", 70, 90);
			g.drawString ("No. of Tickets", 230, 90);
			g.setColor (Color.red);
			g.drawString ("Tickets Left: " + noOfTicketsLeft, 70, 160);
			g.drawString ("Current Prize Money: " +
					currency.format (prizeMoney), 250, 160);
		}
		else
		{
			g.setFont (TITLE_FONT);
			g.setColor (Color.red);
			g.drawString ("*Draw is Complete*", 97, 130);
			g.setFont (LABEL_FONT);
			g.setColor (Color.blue);
			g.drawString ("Winning Ticket No: " + winningTicket, 300, 210);
			g.drawString ("Winner: " + winner, 300, 240);
			g.drawString ("Prize Money: " +
					currency.format (prizeMoney), 300, 270);
			g.setColor (Color.red);
			g.drawString ("Money for United Way: " +
					currency.format (prizeMoney), 270, 320);	
		}
	}

	
	// Main program just creates the frame
	public static void main (String [] args){
		JFrame frame = new JFrame ("United Way 5050 Draw");
		UnitedWay5050Draw myPanel = new UnitedWay5050Draw ();
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);
	}
}







