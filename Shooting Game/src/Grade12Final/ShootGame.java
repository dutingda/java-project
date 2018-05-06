package Grade12Final;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShootGame extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400; 	//frame width
	public static final int HEIGHT = 654; 	//frame height
	//game state
	private int state;
	private static final int START = 0;
	private static final int RUNNING = 1;
	private static final int PAUSE = 2;
	private static final int GAME_OVER = 3;
	private int score = 0; 	//score
	private Timer timer; 	//time
	private int intervel = 1000 / 100; 	//time interval
	//pictures
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage boss;
	private FlyingObject[] flyings = {};//enemy array
	private Bullet[] bullets = {}; 		//bullets array
	private Hero hero = new Hero(); 	//hero plane
    
	//initial picture sources
	static { 
		try {
			background = ImageIO.read(ShootGame.class
					.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			boss = ImageIO.read(ShootGame.class.getResource("boss.png"));
		
			airplane = ImageIO
					.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO
					.read(ShootGame.class.getResource("gameover.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); 	//draw background
		paintHero(g); 							//draw hero plane
		paintBullets(g); 						//draw bullets
		paintFlyingObjects(g); 					//draw flying objects
		paintScore(g); 							//draw score
		paintState(g); 							//draw state
	
	}
	//parameter: graphics g
	//description:draw hero plane
	//return:\
	public void paintHero(Graphics g) {
		g.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
	}
	//parameter: graphics g
	//description:draw bullets
	//return:\
	public void paintBullets(Graphics g) {
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			g.drawImage(b.getImage(), b.getX() - b.getWidth() / 2, b.getY(), null);
		}
	}
	//parameter: graphics g
	//description:draw flying object
	//return:\
	public void paintFlyingObjects(Graphics g) {
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject f = flyings[i];
			g.drawImage(f.getImage(), f.getX(), f.getY(), null);
		}
	}
	//parameter: graphics g
	//description:paint score
	//return:\
	public void paintScore(Graphics g) {
		int x = 10;
		int y = 25; 
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
		g.setColor(new Color(0x3A3B3B));
		g.setFont(font); 
		g.drawString("SCORE:" + score, x, y); 
		y += 20; 
		g.drawString("LIFE:" + hero.getLife(), x, y); 
	}
	//parameter: graphics g
	//description:	draw game state
	//return:\
	public void paintState(Graphics g) {
		switch (state) {
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE: 
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER: 
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly");
		ShootGame game = new ShootGame(); 	//frame object
		frame.add(game); 
		frame.setSize(WIDTH, HEIGHT); 		//frame size
		frame.setAlwaysOnTop(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setIconImage(new ImageIcon("images/icon.jpg").getImage()); 	//frame icon
		frame.setLocationRelativeTo(null);		//initial location
		frame.setVisible(true); 
		frame.setResizable(false);
		game.action();
	}
	
	//parameter:\
	//description:mouse adapter
	//return:\
	public void action() {
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) { 
				if (state == RUNNING) {		//run game when game is running
					int x = e.getX();
					int y = e.getY();
					int x1 = e.getX();
					int y1 = e.getY();
					hero.moveTo(x, y);
					Bullet.moveTo(x1,y1);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) { 
				if (state == PAUSE) { 	//run game when game is pausing
					state = RUNNING;
				}
			}

			@Override
			public void mouseExited(MouseEvent e) { 
				if (state != GAME_OVER) { 	//stop game when game is running
					state = PAUSE;
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) { 
				switch (state) {
				case START:		//operate when game state is running
					state = RUNNING; 
					break;
				case GAME_OVER: 	//game over
					flyings = new FlyingObject[0];	//clear flying object
					bullets = new Bullet[0]; 		//remove bullets
					hero = new Hero(); 				//recreate hero plane
					score = 0; 						//reset score
					state = START; 					//set game state to start
					break;
				}
			}
		};
		this.addMouseListener(l); 
		this.addMouseMotionListener(l); 

		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (state == RUNNING) { 
					enterAction(); 		//flying object enter
					stepAction(); 		//movement
					shootAction(); 		//hero plane shooting
					bangAction(); 		//bullet hit flying object
					outOfBoundsAction(); //remove out of bound flying object and bullets
					checkGameOverAction();	//check whether the game is over or not
				}
				repaint();
			}

		}, intervel, intervel);
	}

	int flyEnteredIndex = 0; //flying object enter count
	//parameter:\
	//description: create enter flying object
	//return:\
	public void enterAction() {
		flyEnteredIndex++;
		if (flyEnteredIndex % 40 == 0) { 	//create a flying object per 400ms
			FlyingObject obj = nextOne();	//create a random flying object
			flyings = Arrays.copyOf(flyings, flyings.length + 1);
			flyings[flyings.length - 1] = obj;
		}
	}
	//parameter:\
	//description:movement
	//return:\
	public void stepAction() {
		for (int i = 0; i < flyings.length; i++) { //flying object move one step
			FlyingObject f = flyings[i];
			f.step();
		}
		

		for (int i = 0; i < bullets.length; i++) { //bullet move one step
			Bullet b = bullets[i];
			b.step();
			}
		
		hero.step(); //hero plane move one step
	}
	//parameter:\
	//description:flying object move one step
	//return:\
	public void flyingStepAction() {	
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject f = flyings[i];
			f.step();
		}
	}

	int shootIndex = 0; //shoot time count
	//parameter:\
	//description: bullet action
	//return:\
	public void shootAction() {
		shootIndex++;
		if (shootIndex % 25 == 0) { 	//create a bullet per 250ms
			Bullet[] bs = hero.shoot();	//hero plane shoot bullet
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length); //increase the size of bullets array
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length,
					bs.length);	//add new bullet array into the old one
		}
	}
	//parameter:\
	//description:check collision between bullets and flying objects
	//return:\
	public void bangAction() {
		int index=-1;
		for (int i = 0; i < bullets.length; i++) { 
			Bullet b = bullets[i];
			
			if(bang(b)){
				index=i;
				break;
			}
		}
		if(index!=-1 ){
			Bullet b=bullets[index];
			bullets[index]=bullets[bullets.length-1];
			bullets[bullets.length-1]=b;
			bullets=Arrays.copyOf(bullets,bullets.length-1);
		}
	}
	//parameter:\
	//description:remove out of bound flying objects
	//return:\
	public void outOfBoundsAction() {
		int index = 0; 
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];		//alive flying object
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject f = flyings[i];
			if (!f.outOfBounds()) {
				flyingLives[index++] = f;		//keep in bound object
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);		//keep objects that not out of bounds
		index = 0; 			//reset index to zero
		Bullet[] bulletLives = new Bullet[bullets.length];
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			if (!b.outOfBounds()) {
				bulletLives[index++] = b;
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);		//keep bullets that not out of bounds
		index = 0; 
		Bullet[] bulletLeftLives = new Bullet[bullets.length];
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			if (!b.outOfBounds2()) {
				bulletLeftLives[index++] = b;
			}
		}
		bullets = Arrays.copyOf(bulletLeftLives, index);
		index = 0; 
		Bullet[] bulletRightLives = new Bullet[bullets.length];
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			if (!b.outOfBounds1()) {
				bulletRightLives[index++] = b;
			}
		}
		bullets = Arrays.copyOf(bulletRightLives, index);
	
	}
	//parameter:\
	//description:check whether the game is over or not
	//return:\
	public void checkGameOverAction() {
		if (isGameOver()) {
			state = GAME_OVER; 		//change state
		}
	}
	//parameter:\
	//description:check is the game over
	//return: boolean, is the game over or not
	public boolean isGameOver() {

		for (int i = 0; i < flyings.length; i++) {
			int index = -1;
			FlyingObject obj = flyings[i];
			if (hero.hit(obj)) { 		//check collection between hero plane and flying objects
				hero.subtractLife();	//subtract one life
				hero.setDoubleFire(0); 	//remove double fire
				hero.setBigFire(0);		//remove big fire
				index = i; 				//record the hit flying object index
			}
			if (index != -1) {
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = t; 		//switch with the last object

				flyings = Arrays.copyOf(flyings, flyings.length - 1); 		//remove hit flying object
			}
		}

		return hero.getLife() <= 0;
	}
	//parameter: bullet object
	//description: check is the bullet hit a flying object
	//return: boolean, is the bullet hit a flying object or not
	public boolean bang(Bullet bullet) {
		int index = -1; 		//hit flying object index
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject obj = flyings[i];
			if (obj.shootBy(bullet)) { 	//check whether the bullet hit the flying object or not
				index = i; 		//record hit flying object index
				break;
			}
		}
		if (index != -1) { 		//when hit a flying object
			FlyingObject one = flyings[index];		//record the hit flying object

			if(one.life<=0){
			FlyingObject temp = flyings[index]; 	//hit flying object switch with the last flying object
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = temp;

			
			flyings = Arrays.copyOf(flyings, flyings.length - 1); //remove the last flying object (the hit one)
			}else{
				one.life--;
			}
			//check the type of hit object
			if (one instanceof Enemy) { //get score for hit enemy
				Enemy e = (Enemy) one;
				if(one.life<=0){
				score += e.getScore(); 
				}
				
			if(one instanceof BigAward){	//get award and score for hit boss
				BigAward b =(BigAward)one;
				if(one.life<=0){		//check the health of boss
					
			    score += e.getScore();	//gain score
				int type = b.getAward();
				switch(type){
				case BigAward.BIG_FIRE:	//set up big fire
					hero.addBigFire();break;}
				}
			}
			}else if (one instanceof Award) {//get award for hit bee
				Award a = (Award) one;
				int type = a.getType();
				switch (type) {
				case Award.DOUBLE_FIRE:		//set up double fire
					hero.addDoubleFire(); 
					break;
				case Award.LIFE:			//gain an extra life
					hero.addLife(); 
					break;
			
				}
				
				}
		return true;
		}
		return false;
	}
	//parameter:\
	//description:create a random flying object
	//return: a created flying object
	public static FlyingObject nextOne() {
		Random random = new Random();
		int type = random.nextInt(20); 
		if (type == 0) {		//create a bee
			return new Bee();
			
		}if(type==1){			//create a boss
			return new Boss();
		}
		else {					//create an enemy plane
			return new Airplane();
		}
	}

}
