package diamond;
import java.util.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MakingDIamondClass extends JPanel{
	public MakingDIamondClass(){
		setPreferredSize(new Dimension(600, 480));
		setBackground(new Color(220,220,220));
	}
	/* Description: draw a small(20 pixels by 20 pixels) red diamond in different locations of a Graphics window
	 * Parameters: the coordinate of the location, x and y
	 * return:/
	 */
	private void drawDiamond(Graphics g, int x, int y){
		g.setColor(Color.RED);
		g.drawLine(x+14, y, x, y+14);
		g.drawLine(x, y+14, x+14, y+28);
		g.drawLine(x+14, y+28, x+28, y+14);
		g.drawLine(x+28, y+14, x+14, y);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the x value: ");
		int x = in.nextInt();
		System.out.print("Please enter the y value: ");
		int y = in.nextInt();
		drawDiamond (g, x,y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame ("Simple Grapics Window");
		MakingDIamondClass myPanel = new MakingDIamondClass();
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);
	}

}
