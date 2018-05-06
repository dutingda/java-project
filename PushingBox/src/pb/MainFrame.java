package pb;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import lightButton.LightButton;


public class MainFrame extends JFrame implements KeyListener, ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5898372865015821147L;
	private Container panel;
	private JLabel player;
	private int playerX;
	private int playerY;
	int count = 0;
	int total = 3;
	private int style;
	private final String mode;
	private LightButton butMainMenu;
	private LightButton butReplay;
	Timer timer;
	boolean timerOn;
	int time;
	public MainFrame (int style,String mode){
		this.style=style;
		this.mode=mode;
		
		if(mode.equals("time record mode")){
		timerOn = false;
		time = 0;
		timer = new Timer (Integer.MAX_VALUE, new TimerEventHandler ());
		addMouseListener (this);
		}
		this.mainFrameBaseUI();
		this.dateInit();
		this.dateUI();
		this.backgroundUI();
		this.addKeyListener(this);
		this.setVisible(true);
		}
	
	private class TimerEventHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			time++;
			repaint (130, 80, 50, 20);
		}
		
	}
	public void paintComponent(Graphics g)
	{		
		super.paintComponents(g);
		if (timerOn)
			g.drawString ("Press the left mouse button to stop the game", 10, 150);
		else
			g.drawString ("Press the left mouse button to start the game", 10, 150);
		
		g.drawString ("Time: " + (time / 10.0), 100, 100);
	} 
	private JLabel[][] uis = new JLabel[12][16];
	private void dateUI() {
		for (int i = 0; i < dates.length; i++) {
			for (int j = 0; j < dates[i].length; j++) {
				if(dates[i][j] == 1){
					JLabel temp = new JLabel(new ImageIcon("1.png"));
					temp.setBounds(10+j*50,10+i*50, 50, 50);
					this.panel.add(temp);
				}
			}
		}
		if(style==1){
			this.playerX = 3;
			this.playerY = 3;
			player = new JLabel(new ImageIcon("-10.png"));
			player.setBounds(10+playerX*50,10+playerY*50, 50, 50);
			this.panel.add(player);


			JLabel tar1 = new JLabel(new ImageIcon("8.png"));
			tar1.setBounds(10+14*50,10+5*50, 50, 50);
			this.panel.add(tar1);
			dates[5][14] = LogicHelper.TARGET;
			uis[5][14] = tar1;
			JLabel tar2 = new JLabel(new ImageIcon("8.png"));
			tar2.setBounds(10+14*50,10+6*50, 50, 50);
			this.panel.add(tar2);
			dates[6][14] = LogicHelper.TARGET;
			uis[6][14] = tar2;
			JLabel tar3 = new JLabel(new ImageIcon("8.png"));
			tar3.setBounds(10+14*50,10+7*50, 50, 50);
			this.panel.add(tar3);
			dates[7][14] = LogicHelper.TARGET;
			uis[7][14] = tar3;


			JLabel box1 = new JLabel(new ImageIcon("4.png"));
			box1.setBounds(10+7*50,10+3*50, 50, 50);
			this.panel.add(box1);
			dates[3][7] = LogicHelper.BOX;
			uis[3][7] = box1;
			JLabel box2 = new JLabel(new ImageIcon("4.png"));
			box2.setBounds(10+7*50,10+5*50, 50, 50);
			this.panel.add(box2);
			dates[5][7] = LogicHelper.BOX;
			uis[5][7] = box2;
			JLabel box3 = new JLabel(new ImageIcon("4.png"));
			box3.setBounds(10+7*50,10+7*50, 50, 50);
			this.panel.add(box3);
			dates[7][7] = LogicHelper.BOX;
			uis[7][7] = box3;

		}
		else if(style==2){
			total=4;
			this.playerX = 3;
			this.playerY = 9;
			player = new JLabel(new ImageIcon("-10.png"));
			player.setBounds(10+playerX*50,10+playerY*50, 50, 50);
			this.panel.add(player);


			JLabel tar1 = new JLabel(new ImageIcon("8.png"));
			tar1.setBounds(10+11*50,10+6*50, 50, 50);
			this.panel.add(tar1);
			dates[6][11] = LogicHelper.TARGET;
			uis[6][11] = tar1;
			JLabel tar2 = new JLabel(new ImageIcon("8.png"));
			tar2.setBounds(10+12*50,10+6*50, 50, 50);
			this.panel.add(tar2);
			dates[6][12] = LogicHelper.TARGET;
			uis[6][12] = tar2;
			JLabel tar3 = new JLabel(new ImageIcon("8.png"));
			tar3.setBounds(10+11*50,10+7*50, 50, 50);
			this.panel.add(tar3);
			dates[7][11] = LogicHelper.TARGET;
			uis[7][11] = tar3;
			JLabel tar4 = new JLabel(new ImageIcon("8.png"));
			tar4.setBounds(10+12*50,10+7*50, 50, 50);
			this.panel.add(tar4);
			dates[7][12] = LogicHelper.TARGET;
			uis[7][12] = tar4;


			JLabel box1 = new JLabel(new ImageIcon("4.png"));
			box1.setBounds(10+5*50,10+8*50, 50, 50);
			this.panel.add(box1);
			dates[8][5] = LogicHelper.BOX;
			uis[8][5] = box1;
			JLabel box2 = new JLabel(new ImageIcon("4.png"));
			box2.setBounds(10+6*50,10+8*50, 50, 50);
			this.panel.add(box2);
			dates[8][6] = LogicHelper.BOX;
			uis[8][6] = box2;
			JLabel box3 = new JLabel(new ImageIcon("4.png"));
			box3.setBounds(10+7*50,10+8*50, 50, 50);
			this.panel.add(box3);
			dates[8][7] = LogicHelper.BOX;
			uis[8][7] = box3;
			JLabel box4 = new JLabel(new ImageIcon("4.png"));
			box4.setBounds(10+6*50,10+7*50, 50, 50);
			this.panel.add(box4);
			dates[7][6] = LogicHelper.BOX;
			uis[7][6] = box4;

		}
		else if(style==3){
			total=6;
			this.playerX = 11;
			this.playerY = 8;
			player = new JLabel(new ImageIcon("-10.png"));
			player.setBounds(10+playerX*50,10+playerY*50, 50, 50);
			this.panel.add(player);

			JLabel tar1 = new JLabel(new ImageIcon("8.png"));
			tar1.setBounds(10+13*50,10+6*50, 50, 50);
			this.panel.add(tar1);
			dates[6][13] = LogicHelper.TARGET;
			uis[6][13] = tar1;
			JLabel tar2 = new JLabel(new ImageIcon("8.png"));
			tar2.setBounds(10+14*50,10+6*50, 50, 50);
			this.panel.add(tar2);
			dates[6][14] = LogicHelper.TARGET;
			uis[6][14] = tar2;
			JLabel tar3 = new JLabel(new ImageIcon("8.png"));
			tar3.setBounds(10+13*50,10+7*50, 50, 50);
			this.panel.add(tar3);
			dates[7][13] = LogicHelper.TARGET;
			uis[7][13] = tar3;
			JLabel tar4 = new JLabel(new ImageIcon("8.png"));
			tar4.setBounds(10+14*50,10+7*50, 50, 50);
			this.panel.add(tar4);
			dates[7][14] = LogicHelper.TARGET;
			uis[7][14] = tar4;
			JLabel tar5 = new JLabel(new ImageIcon("8.png"));
			tar5.setBounds(10+13*50,10+8*50, 50, 50);
			this.panel.add(tar5);
			dates[8][13] = LogicHelper.TARGET;
			uis[8][13] = tar5;
			JLabel tar6 = new JLabel(new ImageIcon("8.png"));
			tar6.setBounds(10+14*50,10+8*50, 50, 50);
			this.panel.add(tar6);
			dates[8][14] = LogicHelper.TARGET;
			uis[8][14] = tar6;
			
			
			JLabel box1 = new JLabel(new ImageIcon("4.png"));
			box1.setBounds(10+2*50,10+7*50, 50, 50);
			this.panel.add(box1);
			dates[7][2] = LogicHelper.BOX;
			uis[7][2] = box1;
			JLabel box2 = new JLabel(new ImageIcon("4.png"));
			box2.setBounds(10+5*50,10+2*50, 50, 50);
			this.panel.add(box2);
			dates[2][5] = LogicHelper.BOX;
			uis[2][5] = box2;
			JLabel box3 = new JLabel(new ImageIcon("4.png"));
			box3.setBounds(10+7*50,10+3*50, 50, 50);
			this.panel.add(box3);
			dates[3][7] = LogicHelper.BOX;
			uis[3][7] = box3;
			JLabel box4 = new JLabel(new ImageIcon("4.png"));
			box4.setBounds(10+5*50,10+4*50, 50, 50);
			this.panel.add(box4);
			dates[4][5] = LogicHelper.BOX;
			uis[4][5] = box4;
			JLabel box5 = new JLabel(new ImageIcon("4.png"));
			box5.setBounds(10+7*50,10+4*50, 50, 50);
			this.panel.add(box5);
			dates[4][7] = LogicHelper.BOX;
			uis[4][7] = box5;
			JLabel box6 = new JLabel(new ImageIcon("4.png"));
			box6.setBounds(10+7*50,10+4*50, 50, 50);
			this.panel.add(box6);
			dates[4][7] = LogicHelper.BOX;
			uis[4][7] = box6;

		}
		
	}
	private int[][] dates = new int[12][16];
	private void dateInit() {
		if(style==1){
			dates = new int[][]{

				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,1,0,1,1,1,0,1,1,1,1,1,0,0,1},
				{1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,1},
				{1,0,1,0,1,1,1,0,0,0,0,0,1,0,0,1},
				{1,0,1,0,1,0,0,0,0,1,1,1,1,0,0,1},
				{1,0,1,0,1,1,1,0,0,0,0,0,1,0,0,1},
				{1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1},
				{1,0,1,0,0,0,0,0,1,1,1,1,1,0,0,1},
				{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			};
		}
		else if(style==2){
			dates = new int[][]{

				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1},
				{1,0,0,1,0,0,0,0,1,1,1,1,1,1,0,1},
				{1,0,0,1,0,0,0,0,1,0,0,0,0,1,0,1},
				{1,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1},
				{1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1},
				{1,0,0,1,1,1,0,0,1,1,1,0,0,0,1,1},
				{1,0,1,1,0,0,0,0,1,0,1,0,0,0,1,1},
				{1,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1},
				{1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1},
				{1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
			};
		}

		else if(style==3){
			dates = new int[][]{
				  {0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},
				  {0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0},
				  {0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0},
				  {0,0,1,1,1,0,0,0,1,1,0,0,0,0,0,0},
				  {0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0},
				  {1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1},
				  {1,0,0,0,1,0,1,1,0,1,1,0,0,0,0,1},
				  {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				  {1,1,1,1,1,0,1,1,1,0,1,0,0,0,0,1},
				  {0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,1},
				  {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
				  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			};
		}
	}


	private void backgroundUI() {
		JLabel floor  = new JLabel(new ImageIcon("floor.png"));
		floor.setBounds(10, 10, 800, 600);
		this.panel.add(floor);
	}

	private void mainFrameBaseUI() {
		this.panel = this.getContentPane();
		this.setSize(826, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel.setLayout(null);
		this.setTitle("Pushing box");
		this.setResizable(false);
		this.getContentPane().setLayout(null);

	}

	private static void move(JLabel c,int vMoveType,int hMoveType){
		c.setLocation(c.getX()-hMoveType*50, c.getY()-vMoveType*50);
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int x = keyCode%2 == 0?39-keyCode:0;
		int y = keyCode%2 == 1?38-keyCode:0;

		if(keyCode >= 37 && keyCode <= 40){

			player.setIcon(new ImageIcon(x+""+y+".png"));
			if(dates[playerX-x][playerY-y] == LogicHelper.WALL)
				return;
		
		
			if(dates[playerX-x][playerY-y] == LogicHelper.FLOOR || dates[playerX-x][playerY-y] == LogicHelper.TARGET){
				move(player,x,y);
				playerX = playerX-x;
				playerY = playerY-y;
				return;
			}
			if(dates[playerX-x][playerY-y] == LogicHelper.BOX || dates[playerX-x][playerY-y] == LogicHelper.BOX_AND_TARGET){

				int code1 = dates[playerX-x][playerY-y];
				int code2 = dates[playerX-x*2][playerY-y*2];
				if(code2 == LogicHelper.FLOOR || code2 == LogicHelper.TARGET){
					JLabel box = uis[playerX-x][playerY-y];
					move(box,x,y);
					uis[playerX-x*2][playerY-y*2] = uis[playerX-x][playerY-y];
					uis[playerX-x][playerY-y] = null;

					if(code1 == LogicHelper.BOX && code2 == LogicHelper.FLOOR ){
						dates[playerX-x*2][playerY-y*2] = LogicHelper.BOX;
						dates[playerX-x][playerY-y] = LogicHelper.FLOOR;
					}
					if(code1 == LogicHelper.BOX && code2 == LogicHelper.TARGET){
						dates[playerX-x*2][playerY-y*2] = LogicHelper.BOX_AND_TARGET;
						dates[playerX-x][playerY-y] = LogicHelper.FLOOR;
						box.setIcon(new ImageIcon("40.png"));
						count++;
					}
					if(code1 == LogicHelper.BOX_AND_TARGET && code2 == LogicHelper.FLOOR ){
						dates[playerX-x*2][playerY-y*2] = LogicHelper.BOX;
						dates[playerX-x][playerY-y] = LogicHelper.TARGET;
						box.setIcon(new ImageIcon("4.png"));
						count--;
					}
					if(code1 == LogicHelper.BOX_AND_TARGET && code2 == LogicHelper.TARGET){
						dates[playerX-x*2][playerY-y*2] = LogicHelper.BOX_AND_TARGET;
						dates[playerX-x][playerY-y] = LogicHelper.TARGET;
						box.setIcon(new ImageIcon("40.png"));
					}

					move(player,x,y);
					playerX = playerX-x;
					playerY = playerY-y;

					victory();
				}
				return;
			}
		}
	}
	
	private void victory()   {
		if(count == total){
			this.removeKeyListener(this);
			JDialog victory = new JDialog(this,"Congratulations! You Win !!!",true);
			victory.setSize(400, 300);
			victory.setLocationRelativeTo(null);
			victory.setLayout(null);

			JLabel info = new JLabel(new ImageIcon("win.png"));
			info.setBounds(2, 2, 380, 180);
			victory.add(info);
			butMainMenu=new LightButton(40,182,140,50,"Main Menu");
			butReplay=new LightButton(220,182,140,50,"Replay");
			butMainMenu.addActionListener(this);
			butReplay.addActionListener(this);
			victory.add(butMainMenu);
			victory.add(butReplay);
			victory.setVisible(true);
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==butMainMenu)
		{	
			this.setVisible(false);
			panel.setVisible(false);			
			dispose();
			try{
				new Main();
			}catch(Exception e1){
				
			}
		}
		else if(e.getSource()==butReplay)
		{
			this.setVisible(false);
			panel.setVisible(false);			
			dispose();
			new MainFrame(style,mode);
		}
	}
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (timerOn)
		{			
			timerOn = false;
			timer.stop ();
		}
		else
		{
			JOptionPane.showMessageDialog (this,"Press OK to continue", "Pause", JOptionPane.INFORMATION_MESSAGE);
			timerOn = true;
			timer.start ();
		}
		repaint ();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}


