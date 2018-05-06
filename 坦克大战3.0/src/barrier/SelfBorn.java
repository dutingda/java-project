package barrier;

import javax.swing.ImageIcon;

public class SelfBorn extends Barrier {

	public SelfBorn(int x, int y) {
		super(x, y);
			setFace(new ImageIcon(SelfBorn.class.getResource("/img/born_1.png")).getImage());
	}

}
