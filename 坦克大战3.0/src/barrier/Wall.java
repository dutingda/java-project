package barrier;

import javax.swing.ImageIcon;

public class Wall extends Barrier {

	public Wall(int x, int y) {
		super(x, y);
		setHp(20);
			setFace(new ImageIcon(Wall.class.getResource("/img/wall_1.png")).getImage());
	}
}
