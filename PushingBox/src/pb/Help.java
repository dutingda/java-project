package pb;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Help extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5567643909843911042L;
	private JPanel p;
	private JTextArea text;
	private ScrollPane sp;
	public Help() {
		this.setBounds(200, 200, 400, 400);
		this.setTitle("Help");

		p=new JPanel(new BorderLayout());
		sp=new ScrollPane();
		setText(new JTextArea());
		sp.add(getText());
		getText().setFont(new Font("Arial", 1, 15));
		getText().setBorder(BorderFactory.createTitledBorder("Game Instruction"));
		getText().setText(str());
		getText().setEditable(false);
		p.add(sp,BorderLayout.CENTER);
		this.add(p);
	}
	public String str() {
		return "1.The object of Sokoban is to\r\n" +
				"take sheep to the designated\r\n" +
				"locations by pushing them.\r\n" +
				"\t \r\n" +
				"\t \r\n" +
				"\t \r\n" +
				"2.To do this the user controls\r\n" +
				"the wolf can move up, down,\r\n" +
				"left and right. It is not allowed\r\n" +
				"to pass throught the walls or\r\n" +
				"boxes. He can push one box at\r\n" +
				"a time(never pull)!!!\r\n" +
				"\t \r\n" +
				"3.At any time, a square can\r\n" +
				"only be occupied be either a\r\n" +
				"wall, a box, or the player.\r\n" +
				"\t \r\n" +
				"\t " +
				"\r\n\r\n\t\t ";
		
	}
	public void setText(JTextArea text) {
		this.text = text;
	}
	public JTextArea getText() {
		return text;
	}
}
