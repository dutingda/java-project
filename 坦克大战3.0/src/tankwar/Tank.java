package tankwar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import barrier.Gold;
import barrier.Home;
import barrier.Iron;
import barrier.Wall;



public class Tank{
	public static final int SIZE=50;
	public  int hpMax=50;
	private int x;
	private int y;
	private int hp=50;
	private int level=1;
	private int style;
	private int power;
	private int speed=5;
	private Direction dir;
	private ImageIcon myPlane_U;
	private ImageIcon myPlane_R;
	private ImageIcon myPlane_D;
	private ImageIcon myPlane_L;
	private boolean up,left,right,down;
    private boolean self;
    private boolean live;
	private ArrayList<Tank> allTank;
	private final ArrayList<Wall> walls;
	private final ArrayList<Iron> irons;
	private final ArrayList<Gold> golds;
	private final Home home;
	private final ArrayList<Missle> missles;
	private long noFire;
	private final ArrayList<Boom> booms;
	private long fireTime;
	private boolean isProtect;
	public Direction getDir() {
		return dir;
	}
	protected static enum Direction{U,L,D,R}
	public Tank(int x,int y,boolean self,ArrayList<Tank> allTank,ArrayList<Wall> walls,ArrayList<Iron> irons,ArrayList<Gold> golds,ArrayList<Missle> missles,Home home,ArrayList<Boom>booms,int style) throws Exception{
		this.missles = missles;
		this.booms = booms;
		this.setX(x);
		this.setY(y);
		this.self=self;
		this.style=style;
		this.allTank = allTank;
		this.walls = walls;
		this.irons = irons;
		this.golds = golds;
		this.home = home;
		dir=Direction.R;
		setLive(true);
		if(!self) level=1+new Random().nextInt(3);
		re();
		
	}
	public void re()
	{
		switch (style) {
		case 1:
			switch (level)
			{
			case 1:
				power=10;
				speed=3;
				hp=80;
				hpMax=80;
				fireTime=30l;
				break;
			case 2:
				power=12;
				speed=4;
				hp=100;
				hpMax=100;
				fireTime=25l;
				break;
			case 3:
				power=14;
				speed=5;
				hp=120;
				hpMax=120;
				fireTime=20l;
				break;
			}
			break;
		case 2:
			switch (level)
			{
			case 1:
				power=12;
				speed=4;
				hp=50;
				hpMax=50;
				fireTime=30l;
				break;
			case 2:
				power=16;
				speed=5;
				hp=60;
				hpMax=60;
				fireTime=25l;
				break;
			case 3:
				power=20;
				speed=6;
				hp=70;
				hpMax=70;
				fireTime=20l;
				break;
			}
			break;
		case 3:
			switch (level)
			{
			case 1:
				power=2;
				speed=6;
				hp=40;
				hpMax=40;
				fireTime=15l;
				break;
			case 2:
				power=3;
				speed=8;
				hp=50;
				hpMax=50;
				fireTime=10l;
				break;
			case 3:
				power=4;
				speed=10;
				hp=60;
				hpMax=60;
				fireTime=5l;
				break;
			}
		}
		if(self)
		{
		myPlane_U=new ImageIcon(Tank.class.getResource("/img/tank"+style+"_self_up_"+level+".png"));
		myPlane_R=new ImageIcon(Tank.class.getResource("/img/tank"+style+"_self_right_"+level+".png"));
		myPlane_D=new ImageIcon(Tank.class.getResource("/img/tank"+style+"_self_down_"+level+".png"));
		myPlane_L=new ImageIcon(Tank.class.getResource("/img/tank"+style+"_self_left_"+level+".png"));
		}
		else
		{
			myPlane_U=new ImageIcon(Tank.class.getResource("/img/tank"+style+"_enemy_up_"+level+".png"));
			myPlane_R=new ImageIcon(Tank.class.getResource("/img/tank"+style+"_enemy_right_"+level+".png"));
			myPlane_D=new ImageIcon(Tank.class.getResource("/img/tank"+style+"_enemy_down_"+level+".png"));
			myPlane_L=new ImageIcon(Tank.class.getResource("/img/tank"+style+"_enemy_left_"+level+".png"));
			hp/=2;
			hpMax/=2;
		}
	}
	public void drawTank(Graphics g)
	{
		switch (dir) {

		case U:
			g.drawImage(myPlane_U.getImage(), getX(), getY(), null);
			g.setColor(Color.RED);
			g.drawRect(getX(), getY()-11, SIZE,5);
			g.fillRect(getX(), getY()-11, SIZE*hp/hpMax, 5);
			break;
		case R:
			g.drawImage(myPlane_R.getImage(), getX(), getY(), null);
			g.setColor(Color.RED);
			g.drawRect(getX(), getY()-11, SIZE,5);
			g.fillRect(getX(), getY()-11, SIZE*hp/hpMax, 5);
			break;
		case D:
			g.drawImage(myPlane_D.getImage(), getX(), getY(), null);
			g.setColor(Color.RED);
			g.drawRect(getX(), getY()-11, SIZE,5);
			g.fillRect(getX(), getY()-11, SIZE*hp/hpMax, 5);
			break;
		case L:
			g.drawImage(myPlane_L.getImage(), getX(), getY(), null);
			g.setColor(Color.RED);
			g.drawRect(getX(), getY()-11, SIZE,5);
			g.fillRect(getX(), getY()-11, SIZE*hp/hpMax, 5);
			break;
		}
		if(isProtect())
		{
			Random r=new Random();
			Graphics2D gg = (Graphics2D)g;
			gg.setStroke(new BasicStroke(2));
			g.setColor(Color.BLUE);
			g.drawLine(x-r.nextInt(5), y-r.nextInt(5), x-r.nextInt(5)+SIZE, y-r.nextInt(5));
			g.drawLine(x-r.nextInt(5), y-r.nextInt(5), x-r.nextInt(5), y-r.nextInt(5)+SIZE);
			g.drawLine(x-r.nextInt(5), y-r.nextInt(5)+SIZE, x-r.nextInt(5)+SIZE, y-r.nextInt(5)+SIZE);
			g.drawLine(x-r.nextInt(5)+SIZE, y-r.nextInt(5), x-r.nextInt(5)+SIZE, y-r.nextInt(5)+SIZE);
		}
	}
	public void move() {
		if(up&&getY()>0&&noMove(getX(), getY())&&noMove(getX()+SIZE-1,getY()-speed))setY(getY() - speed);
		else if(right&&getX()<TankWar.AREA_WIDTH-50&&noMove(getX()+SIZE, getY())&&noMove(getX()+speed+SIZE, getY()+SIZE-1))setX(getX() + speed);
		else if(down&&getY()<TankWar.AREA_HEIGHT-80&&noMove(getX(), getY()+speed+SIZE)&&noMove(getX()+SIZE-1, getY()+speed+SIZE))setY(getY() + speed);
		else if(left&&getX()>0&&noMove(getX(), getY())&&noMove(getX(), getY()+SIZE-1))setX(getX() - speed);
	}
	public void keyPress(KeyEvent e)
	{
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			up=true;
			dir=Direction.U;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			dir=Direction.R;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			dir=Direction.D;
			break;
		case KeyEvent.VK_LEFT:
			left=true;
			dir=Direction.L;
			break;
		}
	}
	public void keyReleased(KeyEvent e)
	{
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		}
	}
	public boolean noMove(int willX,int willY)
	{
		for (int i = 0; i < allTank.size(); i++) {
			if(willX>allTank.get(i).getX()&&willX<allTank.get(i).getX()+SIZE&&willY>allTank.get(i).getY()&&willY<allTank.get(i).getY()+SIZE) return false;
		}
		for (int i = 0; i < walls.size(); i++) {
			if(willX>walls.get(i).getX()&&willX<walls.get(i).getX()+SIZE&&willY>walls.get(i).getY()&&willY<walls.get(i).getY()+SIZE) return false;
		}
		for (int i = 0; i < irons.size(); i++) {
			if(willX>irons.get(i).getX()&&willX<irons.get(i).getX()+SIZE&&willY>irons.get(i).getY()&&willY<irons.get(i).getY()+SIZE) return false;
		}
		for (int i = 0; i < golds.size(); i++) {
			if(willX>golds.get(i).getX()&&willX<golds.get(i).getX()+SIZE&&willY>golds.get(i).getY()&&willY<golds.get(i).getY()+SIZE) return false;
		}
		if(willX>home.getX()&&willX<home.getX()+SIZE&&willY>home.getY()&&willY<home.getY()+SIZE) return false;
		return true;
	}
	public void fire()
	{
		if(noFire<fireTime) return;
		noFire=0l;
		if(style!=3)
		{
		Missle mis=new Missle(x,y,this,allTank, walls,irons,golds,home, booms, missles);
		new Thread(mis).start();
		missles.add(mis);
		}
		else
		{
			Missle mis=new Missle(x-10,y-10,this,allTank, walls,irons,golds,home, booms, missles);
			Missle mis2=new Missle(x+10,y+10,this,allTank, walls,irons,golds,home, booms, missles);
			new Thread(mis).start();
			new Thread(mis2).start();
			missles.add(mis);
			missles.add(mis2);
		}
	}
	public void protect()
	{
		setProtect(true);
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
					try
					{
						Thread.sleep(10000);
						setProtect(false);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}
		}).start();
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isSelf() {
		return self;
	}
	public void setHp(int hp){
		this.hp=hp;
	}
	public int getHp(){
		return hp;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public boolean isLive() {
		return live;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setNoFire(long noFire) {
		this.noFire = noFire;
	}
	public long getNoFire()
	{
		return noFire;
	}
	public int getPower()
	{
		return power;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
	public void setProtect(boolean isProtect)
	{
		this.isProtect = isProtect;
	}
	public boolean isProtect()
	{
		return isProtect;
	}
}
