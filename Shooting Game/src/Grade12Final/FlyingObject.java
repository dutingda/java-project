package Grade12Final;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected int life;		//number of left life
	protected int x;    //x-axis index
	protected int y;    //y-axis index
	protected int width;    //width of flying objects
	protected int height;   //height of flying objects
	protected BufferedImage image;   

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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	//parameter:\
	//description:check whether the flying object is out of bounds or not
	//return:return true or false
	public abstract boolean outOfBounds();
	
	//parameter:\
	//description:flying object move one step
	//return:\
	public abstract void step();
	
	//parameter:bullet object
	//description:check is the flying object shot by bullet or not
	//return:boolean,is flying object shot by bullets
	public boolean shootBy(Bullet bullet){
		int x = bullet.x;  
		int y = bullet.y; 
		return this.x<x && x<this.x+width && this.y<y && y<this.y+height;
	}
	
}
