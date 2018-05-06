import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

// Example with implementing multiple listeners -- since this is a lot more 
// clean if you have multiple components that requires event listeners

public class BasicJFrameWithMultipleListeners {

	JFrame frame;
	JPanel myPanel;
	JLabel prompt1, prompt2, prompt3, stat;
	JTextField grade1, grade2, grade3;
	JButton avgButton, minButton, maxButton;

	public BasicJFrameWithMultipleListeners () {
		frame = new JFrame ("Basic JFrame With Multiple Listeners Example");
		frame.setPreferredSize(new Dimension(400, 250));
		frame.setLocation(200, 200);

		myPanel = new JPanel ();
		myPanel.setLayout(new GridLayout (0,2,10,5));
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));

		prompt1 = new JLabel ("Enter the first grade: ");
		grade1 = new JTextField (10);
		prompt2 = new JLabel ("Enter the second grade: ");
		grade2 = new JTextField (10);
		prompt3 = new JLabel ("Enter the third grade: ");
		grade3 = new JTextField (10);

		avgButton = new JButton ("Average");
		avgButton.addActionListener (new AvgListener ());	

		minButton = new JButton ("Min");
		minButton.addActionListener (new MinMaxListener ());
		minButton.setActionCommand ("Min");
		maxButton = new JButton ("Max");
		maxButton.addActionListener (new MinMaxListener ());
		maxButton.setActionCommand ("Max");

		stat = new JLabel (" ");
		stat.setBorder (BorderFactory.createEmptyBorder (10,0,10,10));

		myPanel.add (prompt1);
		myPanel.add (grade1);
		myPanel.add (prompt2);
		myPanel.add (grade2);
		myPanel.add (prompt3);
		myPanel.add (grade3);
		myPanel.add (avgButton);
		myPanel.add (minButton);
		myPanel.add (maxButton);
		myPanel.add (stat);

		frame.add (myPanel);
		frame.pack ();
		frame.setVisible (true);

	}

	class AvgListener implements ActionListener {

		public void actionPerformed (ActionEvent event) {
			double avgGrade;
			String m1 = grade1.getText ();
			String m2 = grade2.getText ();
			String m3 = grade3.getText ();
			avgGrade = Double.parseDouble(m1) + Double.parseDouble (m2) + Double.parseDouble(m3);
			avgGrade /= 3;
			stat.setText(Double.toString (avgGrade));
		}
	}

	class MinMaxListener implements ActionListener {

		public void actionPerformed (ActionEvent event) {
			String eventName = event.getActionCommand ();
			double minGrade = 999;
			double maxGrade = 0;
			double [] grades = new double [3];

			grades [0] = Double.parseDouble(grade1.getText ());
			grades [1] = Double.parseDouble(grade2.getText ());
			grades [2] = Double.parseDouble(grade3.getText ());

			if (eventName.equals ("Min")) {
				for (int i=0; i < 3; i++) 
					if (minGrade > grades [i])
						minGrade = grades [i];
				stat.setText(Double.toString(minGrade));				
			}
			else if (eventName.equals ("Max")) {
				for (int i=0; i < 3; i++) 
					if (maxGrade < grades [i])
						maxGrade = grades [i];
				stat.setText(Double.toString(maxGrade));				
			}
		}
	}


	public static void main (String [] args){
				new BasicJFrameWithMultipleListeners ();
	}
}
