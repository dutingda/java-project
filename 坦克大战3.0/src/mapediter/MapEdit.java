package mapediter;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import lightButton.LightButton;

import tankwar.Main;
import tankwar.TankWar;

public class MapEdit implements ActionListener{
	public static final int COLS = TankWar.AREA_WIDTH/50;
	public static final int ROWS = TankWar.AREA_HEIGHT/50;
	private JDialog f;
	private JPanel p;
	private ButtonX[][] but;
	private Image image[];
	private JPanel pp;
	private JButton butLoad;
	private JButton butSave;
	private JButton butExit;
	private FileNameExtensionFilter fs;
	private JFileChooser fc;
	private final Main m;

	public MapEdit(Main m) {
		this.m = m;
		f=new JDialog(m.getF(),true);
		f.setTitle("Tank War Map Editer V1.0");
		fc=new JFileChooser();
		fs = new FileNameExtensionFilter("Map file", "map");
		fc.setFileFilter(fs);
		fc.setCurrentDirectory(new File("map"));
		p=new JPanel(new GridLayout(ROWS,COLS));
		pp=new JPanel(null);
		p.setBounds(0, 0,TankWar.AREA_WIDTH , TankWar.AREA_HEIGHT);
		image=new Image[7];
		image[0]=new ImageIcon(MapEdit.class.getResource("/pic/whiteback.jpg")).getImage();
		image[1]=new ImageIcon(MapEdit.class.getResource("/img/wall_1.png")).getImage();
		image[2]=new ImageIcon(MapEdit.class.getResource("/img/iron_1.png")).getImage();
		image[3]=new ImageIcon(MapEdit.class.getResource("/img/gold_1.png")).getImage();
		image[4]=new ImageIcon(MapEdit.class.getResource("/img/born_1.png")).getImage();
		image[5]=new ImageIcon(MapEdit.class.getResource("/img/born_enemy_1.png")).getImage();
		image[6]=new ImageIcon(MapEdit.class.getResource("/img/home_1.png")).getImage();
		but=new ButtonX[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j <COLS; j++) {
				but[i][j]=new ButtonX(i, j);
				but[i][j].addActionListener(this);
				p.add(but[i][j]);
			}
		}
		butLoad=new LightButton(100, TankWar.AREA_HEIGHT+2, 150, 50,"Load Map File");
		butSave=new LightButton(300, TankWar.AREA_HEIGHT+2, 150, 50,"Save Map File");
		butExit=new LightButton(500, TankWar.AREA_HEIGHT+2, 150, 50,"Exit Editer");
		butLoad.addActionListener(this);
		butSave.addActionListener(this);
		butExit.addActionListener(this);
		pp.add(butLoad);
		pp.add(butSave);
		pp.add(butExit);
		pp.add(p);
		f.add(pp);
		f.setSize(TankWar.AREA_WIDTH, TankWar.AREA_HEIGHT+100);
		f.setVisible(true);
	}
	private class ButtonX extends JButton
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 9043445464870977913L;
		private int sr;
		private int sc;
		private int w;
		private int h;
		private int count;
		public ButtonX(int sr,int sc) {
			this.sr=sr;
			this.sc=sc;
			setCount(0);
			w = image[0].getWidth(null)/(COLS);
			h = image[0].getHeight(null)/(ROWS);
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(getCount()==0)
			{
				g.drawImage(image[0], 0,0,this.getWidth(),this.getHeight(), w*sc, sr*h, w*sc+w, sr*h+h, null);
			}
			else
			{
				g.drawImage(image[getCount()], 0,0,this.getWidth(),this.getHeight(), 0, 0, 50, 50, null);
			}
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getCount() {
			return count;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==butLoad)
		{
			fc.showOpenDialog(f);
			FileInputStream read=null;
			try {
				read = new FileInputStream(fc.getSelectedFile());
			} catch (Exception e1) {return;}
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j <COLS; j++) {
					try {
						but[i][j].setCount(read.read());
						but[i][j].repaint();
					} catch (Exception e1) {return;}
				}
			}
		}
		else if(e.getSource()==butSave)
		{
			int c4=0,c5=0,c6=0;
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j <COLS; j++) {
					switch (but[i][j].count) {
					case 4:
						c4++;
						break;
					case 5:
						c5++;
						break;
					case 6:
						c6++;
						break;
					}
				}
			}
				System.out.println(c4+"--"+c5+"--"+c6);
					if(c4!=1)
					{
						JOptionPane.showMessageDialog(f, "必须有且只有一个我方出生点（蓝毯子）");
						return;
					}
					if(c5<1)
					{
						JOptionPane.showMessageDialog(f, "必须有超过一个的敌方出生点（红毯子）");
						return;
					}
					if(c6!=1)
					{
						JOptionPane.showMessageDialog(f, "必须有且只有一个我方基地（苹果）");
						return;
					}
			fc.showSaveDialog(f);
			FileOutputStream write=null;
			try {
				write = new FileOutputStream(fc.getSelectedFile());
			} catch (Exception e1) {return;}
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j <COLS; j++) {
					try {
						write.write(but[i][j].getCount());
					} catch (Exception e1) {return;}
				}
			}
			try {
				write.close();
			} catch (Exception e1) {}
		}
		else if(e.getSource()==butExit)
		{
			f.setVisible(false);
			m.getF().setVisible(true);
		}
		else
		{
			ButtonX b=(ButtonX)e.getSource();
			if(b.getCount()!=6)
			{
				b.setCount(b.getCount()+1);
			}
			else
			{
				b.setCount(0);
			}
			b.repaint();
		}
	}
}
