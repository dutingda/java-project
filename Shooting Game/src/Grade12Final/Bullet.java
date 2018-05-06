package Grade12Final;

//Bullet is flying object
public class Bullet extends FlyingObject {
	private int xspeed = 1;		//speed moving across x-axis
	private int yspeed = 1;		//speed moving across y-axis
	private static int x2;		//bullet's location on x-axis
	private static int y2;		//bullet's location on y-axis
	
	//initial data
	public Bullet(int x,int y){
		this.x = x;
		this.y = y;
		this.image = ShootGame.bullet;
	}
	//parameters: 	x1: bullet new x location after moving
	//				y1: bullet new y location after moving
	//description: 	change bullet location
	//return:\
	public static void moveTo(int x1,int y1){
		x2 = x1;
		y2 = y1;
		
	}
	
	//parameters:\
	//description:calculate the new location
	//return:\
	@Override
	public void step(){   
		y-=yspeed*4;
		if(x2>this.x)		//bullet move toward right
		x-=xspeed;
		
		if(x2<this.x){		//bullet move toward left
	    int xspeed = -1;
	    x-=xspeed;
		}
		
		
	}

	@Override
	//parameter:\
	//check whether bullet is out of bound or not
	//return: boolean, is the bullet out or not
	public boolean outOfBounds() {// beyond the top of the game frame
		return y<-height;
	}
	
	//parameter:
	//description:
	//return:
	public boolean outOfBounds1() {// beyond the right of the game frame
		return x>ShootGame.WIDTH;	
	}
	//parameter:
	//description:
	//return:
	public boolean outOfBounds2() {// beyond the left of the game frame
		return x<-width;
	
	}
}
