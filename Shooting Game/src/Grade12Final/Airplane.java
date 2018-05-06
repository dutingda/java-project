package Grade12Final;

import java.util.Random;
//enemy plane, it is flying object and also enemy
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 3; //moving speed (only downward)
	
	public Airplane(){
		life =1;		//enemy plane health
		this.image = ShootGame.airplane;		//enemy plane picture
		width = image.getWidth();		//enemy plane's width
		height = image.getHeight();		//enemy plane's height
		y = -height;          		//location of new created enemy plane on random x-axis
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);
	}
	
	@Override
	public int getScore() {  
		return 5;
	}
	//parameter:\
	//description:remove enemy plane when it is below the game frame
	//return:boolean is  enemy out of bound or not
	@Override
	public 	boolean outOfBounds() {   
		return y>ShootGame.HEIGHT;
	}
	//parameter:\
	//description:enemy plane movement
	//return:\
	@Override
	public void step() {   
		y += speed;
	}

}

