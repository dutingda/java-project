package tankwar;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Boom implements Runnable{
	private int y;
	private int x;
	private int count=0;
	private ImageIcon[] boom=new ImageIcon[6];
	private boolean live=true;

	public Boom(int x,int y) {
		this.x=x;
		this.y=y;
		for (int i = 1; i <=5; i++) {
			boom[i]=new ImageIcon(Main.class.getResource("/img/boom_"+i+".png"));
		}
	}
	public void drawBoom(Graphics g)
	{
		g.setColor(Color.black);
		try {
			g.drawImage(boom[count].getImage(), x, y, null);
		} catch (Exception e) {
		}
		if(count==5) live=false;
	}
	@Override
	public void run() {
		while(count<=5)
		{
			count++;
			try {Thread.sleep(150);} catch (Exception e) {}
		}
		
	}
	public boolean isLive() {
		return live;
	}
}
