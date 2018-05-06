// The "Testing" class.
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Threading extends JPanel implements ActionListener
{
	JButton b1;
	JLabel l1, l2;
	Rectangle r1 = new Rectangle (120, 200, 40, 40);
	int direction = -1;
	int l2Num = 0;

	public Threading ()
	{

		setPreferredSize(new Dimension(400, 400));
		setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));

		b1 = new JButton ("Click me");
		b1.setActionCommand("Click");
		b1.addActionListener(this);

		l1 = new JLabel ("");
		String temp = Integer.toString (l2Num);
		l2 = new JLabel (temp);

		add (b1);
		add (l1);
		add (l2);

		//Starting the threads
		MoveRect move = new MoveRect ();
		IncreaseNumber inc = new IncreaseNumber();
		move.start ();
		inc.start ();

	}

	public void actionPerformed (ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.equals("Click")) 
			l1.setText ("I'm clicked!!");
	}

	//Thread for the time
	public class IncreaseNumber extends Thread
	{
		public void run ()
		{
			while (true)
			{
				l2Num++;				
				l2.setText (Integer.toString (l2Num));
				try
				{
					sleep (2000);
				}
				catch (Exception e)
				{
				}
			}
		}
	}

	//Thread for the moving rectangle
	public class MoveRect extends Thread
	{
		public void run ()
		{
			while (true)
			{
				if (direction == -1)
					r1.x -= 5;
				else
					r1.x += 5;

				if (r1.x <= 0 && direction == -1)
				{
					direction = 1;
					r1.x = 5;
				}
				else if (r1.x >= 380 && direction == 1)
				{
					direction = -1;
					r1.x = 379;
				}
				try
				{
					sleep (75);
				}
				catch (Exception e)
				{
				}
				repaint ();

			}

		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent (g);
		g.setColor (Color.red);
		g.fill3DRect (r1.x, r1.y, r1.width, r1.height, true);
	}

	public static void main (String [] args){
		JFrame frame = new JFrame ("Threading example");
		Threading myPanel = new Threading ();
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);
	}
}


