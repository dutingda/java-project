package tankwar;

import javax.swing.BorderFactory;

public class Abort extends Help {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5211352451752924696L;
	public Abort() {
		this.setTitle("关于本游戏");
		this.getText().setBorder(BorderFactory.createTitledBorder("关于"));
	}
	@Override
	public String str() {
		return "\t\tTank War 2.0\r\n" +
				"\t游戏作者：徐文俊\r\n" +
				"\tQQ:33916545\r\n" +
				"\t测试：大飞   二萌\r\n" +
				"\t特别鸣谢：陆东林老师   陈亮老师\r\n" +
				"本游戏图片均来自于网络，如有侵权，请联系作者。\r\n" +
				"    如要使用本软件在商业用途，请联系作者\r\n" +
				"    \t版权所有  侵权必究！！";
		
	}
}
