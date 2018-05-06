package tankwar;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Help extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5567643909843911042L;
	private JPanel p;
	private JTextArea text;
	private ScrollPane sp;
	public Help() {
		this.setBounds(200, 200, 400, 400);
		this.setTitle("帮助文档");

		p=new JPanel(new BorderLayout());
		sp=new ScrollPane();
		setText(new JTextArea());
		sp.add(getText());
		getText().setFont(new Font("宋体", 1, 15));
		getText().setBorder(BorderFactory.createTitledBorder("帮助文档"));
		getText().setText(str());
		getText().setEditable(false);
		p.add(sp,BorderLayout.CENTER);
		this.add(p);
	}
	public String str() {
		return "1.控制：\r\n" +
				"\t↑坦克向上\r\n" +
				"\t↓坦克向下\r\n" +
				"\t←坦克向左\r\n" +
				"\t→坦克向右\r\n" +
				"\t空格 开火\r\n" +
				"2.关于地图：\r\n" +
				"\t地图中棕色障碍和银色障碍是可以摧毁的障碍\r\n" +
				"\t金色为不能摧毁的障碍\r\n" +
				"\t蓝色地毯为我方坦克出生点\r\n" +
				"\t红色地毯为敌方坦克出生点\r\n" +
				"\t苹果为我方基地\r\n" +
				"\t地图可使用地图编辑器生成新地图或修改地图\r\n" +
				"3.游戏规则:\r\n" +
				"\t我方坦克剩余数量为0时游戏结束，判负\r\n" +
				"\t我方基地呗摧毁时游戏结束，判负\r\n" +
				"\t敌方坦克剩余数量为0时游戏结束，判胜\r\n" +
				"\t将在3.0版本中加入道具系统双人游戏系统，敬请期待。" +
				"\r\n\r\n\t\t祝游戏愉快";
		
	}
	public void setText(JTextArea text) {
		this.text = text;
	}
	public JTextArea getText() {
		return text;
	}
}
