package tankwar;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import barrier.Gold;
import barrier.Home;
import barrier.Iron;
import barrier.Wall;

import tankwar.Tank.Direction;

public class Missle implements Runnable{
	private int x;
	private int y;
	private int speed;
	private Direction dir;
	private boolean live=true;
	public int SIZE;
	private boolean self;
	private ArrayList<Tank> allTanks;
	private ArrayList<Boom> booms;
	private final ArrayList<Wall> walls;
	private final ArrayList<Iron> irons;
	private final ArrayList<Gold> golds;
	private final Home home;
	private int power;
	public Missle(int x,int y,Tank tank,ArrayList<Tank> allTanks,ArrayList<Wall> walls,ArrayList<Iron> irons,ArrayList<Gold> golds,Home home,ArrayList<Boom>booms,ArrayList<Missle> missles) 
	{
		this.allTanks = allTanks;
		this.walls = walls;
		this.irons = irons;
		this.golds = golds;
		this.home = home;
		this.booms=booms;
		this.self = tank.isSelf();
		this.power=tank.getPower();
		SIZE=power;
		//System.out.println(power);
//		this.x=tank.getX()+Tank.SIZE/3;
//		this.y=tank.getY()+Tank.SIZE/3;
		this.x=x+25-power/2;
		this.y=y+25-power/2;
		this.dir=tank.getDir();
		speed=10;
	}
	@Override
	public void run() 
	{
		while((x>-10&&x<TankWar.AREA_WIDTH&&y>-10&&y<TankWar.AREA_HEIGHT&&live))
		{
			switch (dir)
			{
			case U:
				y-=speed;
				break;
			case R:
				x+=speed;
				break;
			case D:
				y+=speed;
				break;
			case L:
				x-=speed;
				break;
			}
			for (int i = 0; i < walls.size(); i++) {
				if(x>walls.get(i).getX()&&x<walls.get(i).getX()+50&&y>walls.get(i).getY()&&y<walls.get(i).getY()+50)
				{
					walls.get(i).setHp(walls.get(i).getHp()-power);
					if(walls.get(i).getHp()<=0)
					{
						Boom temp=new Boom(walls.get(i).getX(), walls.get(i).getY());
						new Thread(temp).start();
						booms.add(temp);
						walls.remove(i);
					}
					this.live=false;
				}
			}
			for (int i = 0; i < irons.size(); i++) {
				if(x>irons.get(i).getX()&&x<irons.get(i).getX()+50&&y>irons.get(i).getY()&&y<irons.get(i).getY()+50)
				{
					irons.get(i).setHp(irons.get(i).getHp()-power);
					if(irons.get(i).getHp()<=0)
					{
						Boom temp=new Boom(irons.get(i).getX(), irons.get(i).getY());
						new Thread(temp).start();
						booms.add(temp);
						irons.remove(i);
					}
					this.live=false;
				}
			}
			if(x>home.getX()&&x<home.getX()+50&&y>home.getY()&&y<home.getY()+50)
			{
				home.setHp(home.getHp()-power);
				if(home.getHp()<=0)
				{
					Boom temp=new Boom(home.getX(), home.getY());
					Boom temp1=new Boom(home.getX()+50, home.getY());
					Boom temp2=new Boom(home.getX()-50, home.getY());
					Boom temp3=new Boom(home.getX(), home.getY()-50);
					new Thread(temp).start();
					new Thread(temp1).start();
					new Thread(temp2).start();
					new Thread(temp3).start();
					booms.add(temp);
					booms.add(temp1);
					booms.add(temp2);
					booms.add(temp3);
					home.setFace(new ImageIcon("img/home_2.png").getImage());
					home.setLive(false);
				}
				this.live=false;
			}
			for (int i = 0; i < golds.size(); i++) {
				if(x>golds.get(i).getX()&&x<golds.get(i).getX()+50&&y>golds.get(i).getY()&&y<golds.get(i).getY()+50)
				{
					this.live=false;
				}
			}
			
			if(self)
			{
				for (int i = 1; i < allTanks.size(); i++) 
				{
					if((x>allTanks.get(i).getX()&&x<allTanks.get(i).getX()+Tank.SIZE&&y>allTanks.get(i).getY()&&y<allTanks.get(i).getY()+Tank.SIZE))
					{
						allTanks.get(i).setHp(allTanks.get(i).getHp()-power);
						if(allTanks.get(i).getHp()<=0)
						{
							Boom temp=new Boom(allTanks.get(i).getX(), allTanks.get(i).getY());
							new Thread(temp).start();
							booms.add(temp);
							TankWar.SCORE+=100;
							try
							{
								allTanks.remove(i);
							} catch (Exception e)
							{
							}
						}
						this.live=false;
					}
				}
//				for (int i = 0; i < missles.size(); i++) {
//					if(missles.get(i).getX()==this.getX()&&missles.get(i).getY()>=this.getY()&&missles.get(i).getY()<=this.getY()+50&&this!=missles.get(i))
//					{
//						this.live=false;
//						missles.get(i).setLive(false);
//					}
//				}
			}
			else
			{	
				try
				{
					if(x>allTanks.get(0).getX()&&x<allTanks.get(0).getX()+Tank.SIZE&&y>allTanks.get(0).getY()&&y<allTanks.get(0).getY()+Tank.SIZE)
					{
						if(!allTanks.get(0).isProtect())
								allTanks.get(0).setHp(allTanks.get(0).getHp()-power);
						if(allTanks.get(0).getHp()<=0)
						{
							Boom temp=new Boom(allTanks.get(0).getX(), allTanks.get(0).getY());
							new Thread(temp).start();
							booms.add(temp);
							allTanks.get(0).setLive(false);
						}
						this.live=false;
					}
				}catch(Exception e){}
			}
			try {Thread.sleep(30);} catch (InterruptedException e) {}	
		}
		this.live=false;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public boolean isLive() {
		return live;
	}
	public void drawMissle(Graphics g)
	{
		g.setColor(Color.black);
		g.fillOval(x, y, SIZE, SIZE);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
