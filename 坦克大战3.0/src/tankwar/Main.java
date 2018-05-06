package tankwar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lightButton.LightButton;
import mapediter.MapEdit;


public class Main implements ActionListener{
		private JFrame f;
		private PanelX p;
		private LightButton butStart;
		private LightButton butEdit;
		private LightButton butHelp;
		private LightButton butAbort;
		private int width;
		private int height;
		private LightButton butExit;
		private JDialog set;
		private Help help=new Help();
		private Abort about=new Abort(); 
		private String map;
		private int max;
		protected int style;
		public Main() {
			setF(new JFrame("TankWar 3.0"));
			p=new PanelX();
			p.setLayout(null);
			butStart=new LightButton(20,210,140,50,"START");
			butEdit=new LightButton(20,263,140,50,"Map Editer");
			butHelp=new LightButton(20,316,140,50,"Help Doc");
			butAbort=new LightButton(20,369,140,50,"About");
			butExit=new LightButton(20,422,140,50,"Exit");
			butStart.addActionListener(this);
			butEdit.addActionListener(this);
			butHelp.addActionListener(this);
			butAbort.addActionListener(this);
			butAbort.addActionListener(this);
			butExit.addActionListener(this);
			p.add(butStart);
			p.add(butEdit);
			p.add(butHelp);
			p.add(butAbort);
			p.add(butExit);
			getF().add(p);
			getF().setSize(0,0);
			width=800;height=830;
			getF().setDefaultCloseOperation(3);
			getF().setResizable(false);
			getF().setVisible(true);
			for (int i = 0; i < width; i+=20) {
					getF().setSize(i,i*(height/width));
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {}
				
			}
		}
	public static void main(String[] args) {
		new Main();
	}

	private class PanelX extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 5954299196924652990L;
		private ImageIcon backgrond;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			backgrond=new ImageIcon(Main.class.getResource("/pic/start2.jpg"));
			g.drawImage(backgrond.getImage(), 0, 0, 800, 830, 0, 0, backgrond.getIconWidth(), backgrond.getIconHeight(), null);
		}
	}
	public void over()
	{
		for (int i = width; i >=0; i-=20) {
			getF().setSize(i,i*(height/width));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
				}
		getF().setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==butExit)
		{
			over();
		}
		else if(e.getSource()==butEdit)
		{
			new MapEdit(this);
		}
		else if(e.getSource()==butStart)
		{
			dialog();
			try {
				new TankWar(map,max,f,style);
			} catch (Exception e1) {
			}
		}
		else if(e.getSource()==butHelp)
		{
			help.setVisible(true);
		}
		else if(e.getSource()==butAbort)
		{
			about.setVisible(true);
		}
		
	}
	private void dialog() {
		set = new JDialog(f,true);
		set.setVisible(false);
		set.setTitle("��Ϸ����");
		set.setBounds(200,100, 400, 600);
		JLabel tankShow=new JLabel(new ImageIcon(Main.class.getResource("/pic/tanks.jpg")));
		tankShow.setBounds(150, 0, 243, 400);
		ButtonGroup tankGroup=new ButtonGroup();
		final JRadioButton tank1=new JRadioButton("����̹�ˣ�");
		final JRadioButton tank2=new JRadioButton("��ս̹�ˣ�");
		final JRadioButton tank3=new JRadioButton("����̹�ˣ�");
		tank1.setSelected(true);
		tankGroup.add(tank1);
		tankGroup.add(tank2);
		tankGroup.add(tank3);
		Font tankFont = new Font("����",3,22);
		tank1.setFont(tankFont);
		tank2.setFont(tankFont);
		tank3.setFont(tankFont);
		tank1.setBounds(0, 0, 150, 120);
		tank2.setBounds(0, 140, 150, 120);
		tank3.setBounds(0, 280, 150, 120);
		JPanel dp = new JPanel(null);
		File dir = new File("map");
		String mapNames[]=dir.list();
		final JComboBox list = new JComboBox();
		for (int i = 0; i < mapNames.length; i++) {
			list.addItem(mapNames[i]);			
		}
		list.setBounds(100, 410, 250, 30);
		JLabel labMap = new JLabel("��ͼ��");
		labMap.setFont(new Font("����", 1, 20));
		labMap.setBounds(20, 410, 80, 30);
		JLabel labMax=new JLabel("�о�������");
		labMax.setFont(new Font("����", 1, 16));
		labMax.setBounds(20, 470, 120, 30);
		final JSlider slider = new JSlider(10, 50);
		slider.setBounds(150, 470, 230, 50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(2);
		final TextField showMax = new TextField(String.valueOf(slider.getValue()));
		showMax.setFont(new Font("", 0, 20));
		showMax.setBackground(Color.WHITE);
		showMax.setEditable(false);
		showMax.setBounds(100, 470, 30, 30);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showMax.setText(String.valueOf(slider.getValue()));
			}
		});
		JButton butOk = new JButton("��ʼ��Ϸ");
		butOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				max=slider.getValue();
				map=(String)list.getSelectedItem();
				set.setVisible(false);
				if(tank1.isSelected())	style=1;		
				else if(tank2.isSelected()) style=2;
				else if (tank3.isSelected()) style=3;
				over();
			}
		});
		butOk.setBounds(120, 530, 140, 30);
		dp.add(tank1);
		dp.add(tank2);
		dp.add(tank3);
		dp.add(tankShow);
		dp.add(butOk);
		dp.add(showMax);
		dp.add(labMap);
		dp.add(list);
		dp.add(labMax);
		dp.add(slider);
		set.add(dp);
		set.setVisible(true);		
	}
	public void setF(JFrame f) {
		this.f = f;
	}
	public JFrame getF() {
		return f;
	}
}
