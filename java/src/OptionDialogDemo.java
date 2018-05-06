/** The "OptionDialogDemo" class.
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.*;

public class OptionDialogDemo implements MouseListener
{
	int grade;
	JFrame frame;
	JPanel myPanel;
	JLabel message;

	public OptionDialogDemo ()
	{
		frame = new JFrame ("Option Dialog Demo");
		myPanel = new JPanel ();

		myPanel.setPreferredSize(new Dimension(400, 400));
		myPanel.setLocation (100, 100);

		myPanel.setLayout (new GridLayout (0,2,5,10));
		myPanel.setBackground (Color.white);
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));		

		message = new JLabel ("Click the mouse to bring up the Option Dialog");
		myPanel.add (message);

		grade = 11;

		myPanel.addMouseListener(this);
		frame.add (myPanel);
		frame.pack ();
		frame.setVisible (true);
	}

	public void mouseClicked (MouseEvent e)
	{	
		grade = getGradeLevel (9, 12, grade);
		System.out.println ("Selected Grade: " + grade);
	}

	public void mouseReleased (MouseEvent e) 
	{
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub		  
	}

	/** Gets the grade level, using a Dialog Box
	 * @param low          the lowest grade level to offer
	 * @param high         the higest grade level to offer
	 * @param currentGrade the grade currently selected
	 * @return returns the selected grade in the given range
	 *         if the OK button is selected, returns the current
	 *         grade if CANCEL button is selected
	 */
	public int getGradeLevel (int low, int high, int currentGrade)
	{
		// Create a second panel with radio buttons (will disappear after grade is selected)
		JPanel panel2 = new JPanel (); 
		Border lowerEtched =
				BorderFactory.createEtchedBorder (EtchedBorder.RAISED);

		panel2.setBorder (BorderFactory.createTitledBorder (
				lowerEtched, "Choose a Grade Level"));
		int noOfGrades = high - low + 1;
		int noOfColumns = (int) Math.sqrt (noOfGrades);
		panel2.setLayout (new GridLayout (noOfGrades / noOfColumns, noOfColumns));

		// Create a group of radio buttons to add to the Panel
		ButtonGroup gradeGroup = new ButtonGroup ();
		JRadioButton[] buttonList = new JRadioButton [noOfGrades];

		// Create and add each radio button to the panel
		int selectedGrade = currentGrade;
		for (int index = 0 ; index < buttonList.length ; index++)
		{
			int grade = index + low;
			if (grade == selectedGrade)
				buttonList [index] = new JRadioButton ("Grade " + grade, true);
			else
				buttonList [index] = new JRadioButton ("Grade " + grade);
			gradeGroup.add (buttonList [index]);
			panel2.add (buttonList [index]);
		}

		// Show a dialog with the panel attached
		int choice = JOptionPane.showConfirmDialog (myPanel, panel2,
				"Grade Options",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.DEFAULT_OPTION);

		frame.setContentPane (panel2);

		// Update grade if OK is selected
		if (choice == JOptionPane.OK_OPTION)
		{
			for (int index = 0 ; index < buttonList.length ; index++)
				if (buttonList [index].isSelected ())
					selectedGrade = index + low;
		}

		frame.setContentPane (myPanel); //set back to the original panel 
		return selectedGrade;
	}


	public static void main (String [] args){
		new OptionDialogDemo ();
	}

}