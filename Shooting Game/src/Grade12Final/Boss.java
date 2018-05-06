package Grade12Final;

import java.util.Random;

public class Boss extends FlyingObject implements Enemy,BigAward{
	private int xSpeed = 1;		//speed moving across x-axis
	private int ySpeed = 2;		//speed moving across y-axis
	private int awardType=1;	//a number represents big fire
	
	
	
	public Boss(){
		life =10;		//boss's health
		this.image = ShootGame.boss;		//boss's image
		width = image.getWidth();		//boss's width
		height = image.getHeight();		//boss's height
		x = (int)(Math.random()*(ShootGame.WIDTH-this.width));		//location of new created boss on random x-axis
		y = height/5;	
	}
	//parameter:\
	//description:restrict boss in the game frame
	//return:bollean is the boss out of bound
	public boolean outOfBounds() {
		return false;
	}

	//parameter:\
	//description:boss movement
	//return:\
	public void step() {
		x+=xSpeed;
		y+=ySpeed;
	if(x>ShootGame.WIDTH-this.width/2){//moving left
		xSpeed = -1;
	}
	if(x<0){//moving right
		xSpeed = 1;
	}
	if(y>ShootGame.HEIGHT-this.height/2){//moving up
		ySpeed = -1;
	}
	if(y<0){//moving down
		ySpeed = 1;
	}
	}
	
	public int getScore() {//boss's score
		return 1000;
	}

	public int getAward() {//get big fire after kill the boss
		return awardType;
	}

}
