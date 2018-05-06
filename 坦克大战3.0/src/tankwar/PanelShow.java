package tankwar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelShow extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1827558891994483585L;
	private int score;
	private int selfCount;
	private int enemyCount;
	public void setScore(int score) {
		this.score = score;
	}
	public void setSelfCount(int selfCount) {
		this.selfCount = selfCount;
	}
	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}
	private ImageIcon enemy;
	private ImageIcon self;
	private ImageIcon bg;
	public PanelShow() {
		bg=new ImageIcon(PanelShow.class.getResource("/pic/bg.png"));
		enemy=new ImageIcon(PanelShow.class.getResource("/img/TANK1_enemy_up_1.png"));
		self=new ImageIcon(PanelShow.class.getResource("/img/TANK2_self_up_1.png"));
	}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), 0, 0, bg.getIconWidth(), bg.getIconHeight(), null);
			g.setFont(new  Font("Arial", Font.BOLD, 22));
			g.setColor(Color.WHITE);
			g.drawString("Enemy Tank:", 5, 60);
			int j=0,jj=0;
			for (int i = 0; i < enemyCount; i++) {
				g.drawImage(enemy.getImage(), 40*jj, 70+40*j, 40*(jj+1),70+40*(j+1), 0, 0, enemy.getIconWidth(), enemy.getIconHeight(),null);
				jj++;
				if(i%5==0&&i!=0) {j++;jj=0;}
			}
			g.drawString("My Tank:", 5, 490);
			j=0;jj=0;
			for (int i = 0; i < selfCount; i++) {
				g.drawImage(self.getImage(), 40*jj, 500+40*j, 40*(jj+1),500+40*(j+1), 0, 0, self.getIconWidth(), self.getIconHeight(),null);
				jj++;
				if(i%5==0&&i!=0) {j++;jj=0;}
			}
			g.setColor(Color.YELLOW);
			g.drawString("Score:", 5, 600);
			g.setFont(new  Font("Arial", 2, 22));
			g.drawString(String.valueOf(score), 50, 650);
		}

}
