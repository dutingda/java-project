package Grade12Final;

import java.util.Random;
//bee is a flying object
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;  		//speed moving across x-axis
	private int ySpeed = 2;   		//speed moving across y-axis
	private int awardType;    		//a number represents a type of award
	
	public Bee(){
		this.image = ShootGame.bee;		//bee's image
		width = image.getWidth();		//bee's width
		height = image.getHeight();		//bee's height
		y = -height;					
		Random rand = new Random();		//location of new created enemy plane on random x-axis
		x = rand.nextInt(ShootGame.WIDTH - width);
		awardType = rand.nextInt(2);  
	}
	
	public int getType(){
		return awardType;
	}
	//parameter:\
	//description:remove bee that is out of bound
	//return:boolean, is bee out of bounds or not
	@Override
	public boolean outOfBounds() {
		return y>ShootGame.HEIGHT;
	}
	//parameter:\
	//description:bee's movement
	//return:\
	@Override
	public void step() {      
		x += xSpeed;		//moving across x-axis
		y += ySpeed;		//moving across y-axis
		if(x > ShootGame.WIDTH-width){  	//move left
			xSpeed = -1;
		}
		if(x < 0){			//move right
			xSpeed = 1;
		}
	}
}