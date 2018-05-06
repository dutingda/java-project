// The "MenuDemo" class. 
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

public class MenuDemo implements ActionListener, ItemListener //ItemListener is for checkboxes in menu
{
	JFrame frame;
	JPanel myPanel;
	JMenuBar mainMenu;
	JMenu gameMenu, subMenu, levelMenu, helpMenu;
	JMenuItem newOption, exitOption, aboutOption, subMenuOne, subMenuTwo;
	JLabel label;
	JCheckBoxMenuItem beginnerOption, intermediateOption, advancedOption;
	String message;
	int level;

	public MenuDemo ()
	{	
		frame = new JFrame ("Working with Menus");
		myPanel = new JPanel ();
		
		myPanel.setPreferredSize(new Dimension(400, 400));
		myPanel.setLocation (300,300);
		
		myPanel.setLayout (new BoxLayout (myPanel, BoxLayout.PAGE_AXIS));
		myPanel.setBackground (Color.white);
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));

		
		// Set up the Menu
		// Set up the Game MenuItems with Short cuts
		newOption = new JMenuItem ("New", KeyEvent.VK_N);
		exitOption = new JMenuItem ("Exit", KeyEvent.VK_X);

		// Set up the Game Menu
		gameMenu = new JMenu ("Game");

		// Add each MenuItem to the Game Menu (with a separator)
		gameMenu.add (newOption);

		// Create a sub menu
		subMenu = new JMenu ("Sub Menu");
		subMenuOne = new JMenuItem ("First Sub Menu Choice");
		subMenuTwo = new JMenuItem ("Second Sub Menu Choice");
		subMenu.add (subMenuOne);
		subMenu.add (subMenuTwo);
		gameMenu.add (subMenu);

		gameMenu.addSeparator ();
		gameMenu.add (exitOption);

		// Set up the Level Menu with the check boxes
		beginnerOption = new JCheckBoxMenuItem ("Beginner", true);
		level = 1;
		intermediateOption = new JCheckBoxMenuItem ("Intermediate", false);
		advancedOption = new JCheckBoxMenuItem ("Advanced", false);
		levelMenu = new JMenu ("Level");
		levelMenu.add (beginnerOption);
		levelMenu.add (intermediateOption);
		levelMenu.add (advancedOption);

		// Set up the Help Menu
		aboutOption = new JMenuItem ("About...");
		helpMenu = new JMenu ("Help");
		helpMenu.add (aboutOption);

		// Set up the Menu Bar and add the above Menus
		mainMenu = new JMenuBar ();
		mainMenu.add (gameMenu);
		mainMenu.add (levelMenu);
	
		//mainMenu.setHelpMenu (helpMenu);
		mainMenu.add (helpMenu);
		// Set the menu bar for this frame to mainMenu
		frame.setJMenuBar (mainMenu);

		label = new JLabel ("Welcome to the Menu Demo");    // initial message
		myPanel.add (label);
		
		
		newOption.setActionCommand ("New");
		newOption.addActionListener(this);
		exitOption.setActionCommand ("Exit");
		exitOption.addActionListener(this);
		aboutOption.setActionCommand ("About");
		aboutOption.addActionListener(this);
		subMenuOne.setActionCommand ("SubMenu1");
		subMenuOne.addActionListener(this);
		subMenuTwo.setActionCommand ("SubMenu2");
		subMenuTwo.addActionListener(this);

		beginnerOption.setActionCommand ("Beginner");
		beginnerOption.addItemListener(this);
		intermediateOption.setActionCommand ("Intermediate");
		intermediateOption.addItemListener(this);
		advancedOption.setActionCommand ("Advanced");
		advancedOption.addItemListener(this);
	
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);	

	} 

	// To handle normal menu items
	public void actionPerformed (ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.equals ("New")) {
			newGame ();
		}
		else if (eventName.equals ("SubMenu1"))
			label.setText ("First Sub Menu Choice Selected");
		else if (eventName.equals ("SubMenu2"))
			label.setText ("Second Sub Menu Choice Selected");
		else if (eventName.equals ("Exit")) {			
			System.exit (0);
		}	
		else if (eventName.equals ("About"))
			JOptionPane.showMessageDialog (frame, (Object) "Menu Event \nProcessing Demo", "About...", JOptionPane.INFORMATION_MESSAGE);			
	}
	
	// To handle menu items that are checkboxes or radio buttons
	public void itemStateChanged(ItemEvent event) {		
		if (event.getSource() == beginnerOption) 
			label.setText ("Beginner level selected");
		else if (event.getSource ()  == intermediateOption) 
			label.setText ("Intermediate level selected");
		else if (event.getSource () == advancedOption) 
			label.setText ("Advanced level selected");
	}
	
    public void newGame ()
    {
        message = "New Game Selected at the ";
        if (level == 1)
            message += "Beginner Level";
        else if (level == 2)
            message += "Intermediate Level";
        else
            message += "Advanced Level";
    }

	
	public static void main (String [] args){
		new MenuDemo ();
	}


}