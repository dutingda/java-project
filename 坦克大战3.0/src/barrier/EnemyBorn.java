package barrier;

import javax.swing.ImageIcon;

public class EnemyBorn extends Barrier {

	public EnemyBorn(int x, int y) {
		super(x, y);
			setFace(new ImageIcon( EnemyBorn.class.getResource("/img/born_enemy_1.PNG")).getImage());
	}

}
