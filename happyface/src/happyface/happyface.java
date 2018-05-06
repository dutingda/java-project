package happyface;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class happyface extends JPanel{
	private static final long serialVersionUID = 1L;
	public happyface() {
		setPreferredSize(new Dimension(600,480));
		setBackground(new Color(250,250,250));
	}
	/* Description: draw a happy face in a Graphics window. THe happy face is approximately 100*100 pixels
	 * Parameters: include the Graphics object and the position within the graphics window where to draw the happy face
	 * return:/
	 */
protected void drawHappyFace  (int x , int y,  Graphics g){
	 super.paintComponent(g);
	 Graphics2D g2 = (Graphics2D) g;
	 g.setColor( Color.yellow );
	 g.fillArc(x, y, 100, 100, 0, 360);
     g.setColor( Color.black );
     g.fillArc( x+25, y+25, 12, 12, 0, 360);
     g.fillArc( x+60, y+25, 12, 12, 0, 360);
     g.setColor( Color.red );
     g2.setStroke(new BasicStroke(3));
     g2.drawArc ( x+10, y+35, 80, 45, -50, -80 );
}
protected void paintComponent(Graphics g)
{	
	drawHappyFace(67 , 89 , g);
}
public static void main(String [ ] args){
	
	JFrame frame =new JFrame("Happy Face");
	happyface myPanel= new happyface();
	frame.add(myPanel);
	frame.pack();
	frame.setVisible(true);
}
}
