package barrier;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Barrier {
		private static final int SIZE = 50;
		private int x;
		private int y;
		private int hp;
		private ImageIcon face=null;
		public Barrier(int x,int y) {
			this.x=x;
			this.y=y;
			face=new ImageIcon();
		}
		public void draw(Graphics g)
		{
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			g.drawImage(face.getImage(), x, y, x+SIZE, y+SIZE, 0,0,face.getIconWidth(), face.getIconHeight(), null);
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
		public Image getFace() {
			return face.getImage();
		}
		public void setFace(Image face) {
			this.face.setImage(face);
		}
}
