import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
public class Happyface extends JPanel{
	public Happyface(){
		setPreferredSize(new Dimension(600,480));
		setBackground(new Color(250,250,250));
	}
	/* Description: draws a stretching or compressing happy face in a Graphics window
	 * Parameters: 2 parameters to indicate the width and height of the face
	 * return:/
	 */
	protected void drawHappyFace  (int x , int y, int width, int height, Graphics g){
		 super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
		 g.setColor( Color.yellow );
		 g.fillArc((int)x, (int)y, (int)width, (int)height, 0, 360);
		 g.setColor( Color.red );
		 g.drawArc((int)x, (int)y, (int)width, (int)height, 0, 360);
		 g.setColor( Color.black );
	     g.fillArc( (int)(x+0.23*width), (int)(y+0.22*height), (int)(width*0.15), (int)(height*0.15), 0, 360);
	     g.fillArc( (int)(x+0.6*width), (int)(y+0.22*height), (int)(width*0.15), (int)(height*0.15), 0, 360);
	     g.setColor( Color.black );
	     g2.setStroke(new BasicStroke(2));
	     g2.drawArc ( (int)(x+0.27*width), (int)(y+0.6*height) ,(int)(width*0.5) ,(int)(height*0.33) ,-10 ,-160  );
	}
	protected void paintComponent(Graphics g)
	{	
		Scanner in = new Scanner (System.in);
		System.out.print("Please enter the width value: ");
		int width=in.nextInt();
		System.out.print("Please enter the height value: ");
		int height=in.nextInt();
		drawHappyFace(67 , 89 ,width,height, g);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame =new JFrame("Happy Face");
		Happyface myPanel= new Happyface();
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);
	}

}
