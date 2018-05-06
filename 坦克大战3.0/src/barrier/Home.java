package barrier;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Home extends Barrier {

	private boolean live;
	public static int HPMAX=50;
	public Home(int x, int y) {
		super(x, y);
		setHp(HPMAX);
		setLive(true);

			setFace(new ImageIcon(Home.class.getResource("/img/home_1.png")).getImage());

	}
	public void damage()
	{	
			setFace(new ImageIcon(Home.class.getResource("/img/home_2.png")).getImage());
	}
	@Override
	public void draw(Graphics g)
	{
		super.draw(g);
		g.setColor(Color.RED);
		g.drawRect(getX(), getY(), 50, 5);
		g.fillRect(getX(), getY(), 50*this.getHp()/HPMAX, 5);
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public boolean isLive() {
		return live;
	}

}
