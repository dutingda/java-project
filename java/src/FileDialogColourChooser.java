// The "FileDialogColourChooser" class. 
import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FileDialogColourChooser implements ActionListener
{
    JFrame frame;
    JPanel myPanel;
	JLabel message;
	JMenu gameMenu, colourPreferences, helpMenu;
	JMenuBar mainMenu;
	JMenuItem newOption, exitOption, aboutOption;
	JMenuItem openOption, saveOption;
	JMenuItem chooseBackGroundColour, chooseMessageColour;
	Color messageColour;


	public FileDialogColourChooser ()
	{
		frame = new JFrame ("File Dialogs and Colour Choosers");
		myPanel = new JPanel ();
		
		myPanel.setPreferredSize(new Dimension(400, 400));
		myPanel.setLocation (100, 100);
		
		myPanel.setLayout (new BoxLayout (myPanel, BoxLayout.PAGE_AXIS));
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));		

		// Set up the Menu
		// Set up the Game MenuItems with Short cuts
		newOption = new JMenuItem ("New", KeyEvent.VK_N);
		openOption = new JMenuItem ("Open", KeyEvent.VK_O);
		saveOption = new JMenuItem ("Save", KeyEvent.VK_S);
		exitOption = new JMenuItem ("Exit", KeyEvent.VK_X);

		// Set up the Game Menu
		gameMenu = new JMenu ("Game");

		// Add each MenuItem to the Game Menu (with a separator)
		gameMenu.add (newOption);
		gameMenu.add (openOption);
		gameMenu.add (saveOption);
		gameMenu.addSeparator ();
		gameMenu.add (exitOption);

		// Create a colour menu
		colourPreferences = new JMenu ("Colour");
		chooseBackGroundColour = new JMenuItem ("Background");
		chooseMessageColour = new JMenuItem ("Message Text");
		messageColour = Color.black;
		colourPreferences.add (chooseBackGroundColour);
		colourPreferences.add (chooseMessageColour);


		// Set up the Help Menu
		aboutOption = new JMenuItem ("About...");
		helpMenu = new JMenu ("Help");
		helpMenu.add (aboutOption);

		// Set up the Menu Bar and add the above Menus
		mainMenu = new JMenuBar ();
		mainMenu.add (gameMenu);
		mainMenu.add (colourPreferences);
		mainMenu.add (helpMenu);

		// Set the menu bar for this frame to mainMenu
		frame.setJMenuBar (mainMenu);

		newOption.setActionCommand ("New");
		newOption.addActionListener(this);
		exitOption.setActionCommand ("Exit");
		exitOption.addActionListener(this);
		aboutOption.setActionCommand ("About");
		aboutOption.addActionListener(this);
		openOption.setActionCommand ("Open");
		openOption.addActionListener(this);
		saveOption.setActionCommand ("Save");
		saveOption.addActionListener(this);
		chooseBackGroundColour.setActionCommand ("BgColour");
		chooseBackGroundColour.addActionListener(this);
		chooseMessageColour.setActionCommand ("MsgColour");
		chooseMessageColour.addActionListener(this);
		
		message = new JLabel ("Welcome to the Menu Demo");    // initial message
		myPanel.add (message);
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);		


		
	} // Constructor

	public void actionPerformed (ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.equals ("New"))
		{
			newGame ();
		}
		else if (eventName.equals ("Open"))
		{
			FileDialog openDialog = new FileDialog (frame, "Open a new file", FileDialog.LOAD);
			openDialog.setVisible (true);
			String fileName = openDialog.getFile ();
			String dir = openDialog.getDirectory ();
			message.setText("Open file" + dir + fileName);
		}
		else if (eventName.equals ("Save"))
		{
			FileDialog saveDialog = new FileDialog (frame, "Save a file", FileDialog.SAVE);
			saveDialog.setVisible (true);
			String fileName = saveDialog.getFile ();
			String dir = saveDialog.getDirectory ();
			message.setText("Save file" + dir + fileName);
		}
		else if (eventName.equals ("BgColour"))
		{
			Color newColour = JColorChooser.showDialog (myPanel,
					"Choose Background Color",
					myPanel.getBackground ());

			if (newColour != null)
			{
				myPanel.setBackground (newColour);
			}


		}
		else if (eventName.equals ("MsgColour"))
		{
			Color newColour = JColorChooser.showDialog (myPanel, "Choose Message Color", messageColour);

			if (newColour != null)
			{
				messageColour = newColour;
			}
		}
		else if (eventName.equals ("Exit"))
		{
			System.exit (0);
		}
		else if (eventName.equals ("About"))
		{
			JOptionPane.showMessageDialog (myPanel,
					"File Dialogs and \nColour Choosers Demo", "About...",
					JOptionPane.INFORMATION_MESSAGE);

		}
		message.setForeground(messageColour);
		message.setText ("Hello!");
	}



	void newGame ()
	{
		message.setText("New Game was selected");
	}

	public static void main (String [] args){
		new FileDialogColourChooser ();
	}


}