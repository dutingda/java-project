package Grade12Final;
import java.awt.image.BufferedImage;

//Hero plane is flying object
public class Hero extends FlyingObject{
	
	private BufferedImage[] images = {}; 	//Hero plane picture
	private int index = 0;     //Hero plane picture index
	
	private int doubleFire;  //double fire
	private int life; 	//left lives
	private int bigFire;	
	
	//initial data
	public Hero(){
	
		life = 3;  //initial three lives
		doubleFire = 0;   //initial fire
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1}; //hero plane picture array
		image = ShootGame.hero0;  //initial picture
		
		width = image.getWidth();
		height = image.getHeight();
		x = 150;		//initial location
		y = 400;
	}
	//parameter:\
	//description:obtain double fire
	//return: int represent double fire index
	public int isDoubleFire() {
		return doubleFire;
	}
	
	//set double fire
	public void setDoubleFire(int doubleFire) {
		this.doubleFire = doubleFire;
	}
	
	
	public void setBigFire(int bigFire) {
		this.bigFire = bigFire;
	}
	//parameter:\
	//description:increase fire
	//return:\
	public void addDoubleFire(){
		doubleFire += 20;
	}
	//parameter:\
	//description:set up big fire
	//return:\
	public void addBigFire(){
		bigFire +=40;
	}
	
	//parameter:\
	//description:increase life
	//return:\
	public void addLife(){  
		life++;
	}
	//parameter:\
	//description:subtract a life
	//return:\
	public void subtractLife(){  
		life--;
	}
	
	//obtain life
	public int getLife(){
		return life;
	}
	
	//parameter:x:mouse x-axis location
	//			y:mouse y-axis location
	//description:hero plane moves to mouse's location
	//return:\
	public void moveTo(int x,int y){   
		this.x = x - width/2;
		this.y = y - height/2;
	}
	//parameter:\
	//description:restrict hero plane in the game frame
	//return: is the hero out of bound or not
	@Override
	public boolean outOfBounds() {
		return false;  
	}
	
	//parameter:\
	//description:bullets' movement
	//return:bullets object
	public Bullet[] shoot(){   
		int xStep = width/4;    //distance between bullets  
		int yStep = 20;  
		if(doubleFire>0){  //when double fire is on
			Bullet[] bullets = new Bullet[3];
			
			bullets[0] = new Bullet(x+1*xStep,y-yStep); 	//distance between bullet and hero plane
			bullets[1] = new Bullet(x+3*xStep,y-yStep);
			bullets[2] = new Bullet(x+2*xStep,y-yStep);
			
			doubleFire-=1;
			return bullets;
			}
		else if(bigFire>0){	//when big fire is on
            Bullet[] bullets = new Bullet[5];
			
			bullets[0] = new Bullet(x+1*xStep,y-yStep); 	//distance between bullet and hero plane
			bullets[1] = new Bullet(x+3*xStep,y-yStep);
			bullets[2] = new Bullet(x+2*xStep,y-yStep);
			bullets[3] = new Bullet(x+xStep/10,y-yStep);
			bullets[4] = new Bullet(x+4*xStep,y-yStep);
			doubleFire-=1;
			return bullets;
		   	
		}else{      //single fire
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(x+2*xStep,y-yStep);  	//distance between bullet and hero plane
			  
			return bullets;
		}
	}

		

	
		
	//parameter:\
	//description:switch picture when hero plane is moving
	//return:\
	@Override
	public void step() {
		if(images.length>0){
			image = images[index++/10%images.length];  
		}
	}
	
	//parameter:other:a filying object
	//description:check if the bullet hit something or not
	//return:boolean, if the bullet hit a flying object or not
	public boolean hit(FlyingObject other){
		
		int x1 = other.x - this.width/2;                 	//x-axis min distance
		int x2 = other.x + this.width/2 + other.width;  	 //x-axis max distance
		int y1 = other.y - this.height/2;              	 	//y-axis min distance
		int y2 = other.y + this.height/2 + other.height;	 //y-axis max distance
	
		int herox = this.x + this.width/2;              //hero plane's midpoint location
		int heroy = this.y + this.height/2;              
		
		return herox>x1 && herox<x2 && heroy>y1 && heroy<y2;   	//when hero plane hit with another flying object
	}
	
}










