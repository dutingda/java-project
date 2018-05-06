package tankwar;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import barrier.Home;
import barrier.Iron;

public class Item  extends Thread{			
	private Random r;
	private int x;
	private int y;
	private int style;
	private Image face;
	private boolean live=true;
	private boolean flash;
	private final ArrayList<Tank> tanks;
	private final ArrayList<Boom> booms;
	private Home home;
	private ArrayList<Iron> irons;

		public Item(ArrayList<Tank> tanks,ArrayList<Boom> booms,ArrayList<Iron> irons,Home home)
		{
			this.tanks = tanks;
			this.booms = booms;
			this.home=home;
			this.irons=irons;
			r=new Random();
			x=r.nextInt(750);
			y=r.nextInt(750)+30;
			style=r.nextInt(7);
			//style=4;
			/**
			 * 0 Õ¨µ¯
			 * 1 ÔÝÍ£
			 * 2 ÀÏ¼Ò
			 * 3 ÐÞÀí°ü
			 * 4 ¶ÜÅÆ
			 * 5 ÐÇ
			 * 6 Ãü
			 */
			face=new ImageIcon(Item.class.getResource("/pic/"+style+".jpg")).getImage();
		}
		public void draw(Graphics g)
		{
			if(flash)g.drawImage(face, x, y, null);
		}
		@Override
		public void run() {
			flash = true;
			for (int i = 0; i < 40; i++) {
				flash=!flash;
				if(!this.live) break;
					Tank tank = tanks.get(0);
					if((tank.getX()>x&&tank.getX()<x+50&&tank.getY()>y&&tank.getY()<y+50)||
						(tank.getX()+50>x&&tank.getX()<x+50&&tank.getY()>y&&tank.getY()<y+50)||
						(tank.getX()>x&&tank.getX()<x+50&&tank.getY()+50>y&&tank.getY()<y+50)||
						(tank.getX()+50>x&&tank.getX()+50<x+50&&tank.getY()+50>y&&tank.getY()+50<y+50))
					{
						use(tank);
						
					}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.setLive(false);
		}
		public void use(Tank tank)
		{
		switch (style) 
		{
			case 0:
				Boom temp=new Boom(tanks.get(tanks.size()-1).getX(), tanks.get(tanks.size()-1).getY());
				new Thread(temp).start();
				booms.add(temp);
				TankWar.SCORE+=100;
				tanks.remove(tanks.size()-1);
				this.live=false;
				break;
			case 1:
				TankWar.TIMEOUT=true;
				new Thread(new Runnable()
				{			
					public void run()
					{
						try
						{
							Thread.sleep(5000);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						TankWar.TIMEOUT=false;
					}
				}).start();
				break;
			case 2:
					home.setHp(Home.HPMAX);
					homeP(home.getX()-Tank.SIZE,home.getY()-Tank.SIZE);
					homeP(home.getX(),home.getY()-Tank.SIZE);
					homeP(home.getX()+Tank.SIZE,home.getY()-Tank.SIZE);
					homeP(home.getX()-Tank.SIZE,home.getY());
					homeP(home.getX()+Tank.SIZE,home.getY());
					homeP(home.getX()-Tank.SIZE,home.getY()+Tank.SIZE);
					homeP(home.getX(),home.getY()+Tank.SIZE);
					homeP(home.getX()+Tank.SIZE,home.getY()+Tank.SIZE);
				break;
			case 3:
				tank.setHp(tank.hpMax);
				break;
			case 4:
				tank.protect();
				break;	
			case 5:
				if(tank.getLevel()!=3)
				{
					tank.setLevel(tank.getLevel()+1);
					tank.re();
				}
				break;
			case 6:
				TankWar.addMyTankLives();
				break;
			}
		this.live=false;
		}
		private void homeP(int i,int j)
		{
			if(i<0||i>TankWar.AREA_WIDTH||j<0||j>TankWar.AREA_HEIGHT) return;
			irons.add(new Iron(i, j));
		}
		public void setLive(boolean live) {
			this.live = live;
		}
		public boolean isLive() {
			return live;
		}
}
