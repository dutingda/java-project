package barrier;

import javax.swing.ImageIcon;

public class Gold extends Barrier {

	public Gold(int x, int y) {
		super(x, y);

			setFace(new ImageIcon(Gold.class.getResource("/img/gold_1.png")).getImage());
	}
}