package pb;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import lightButton.LightButton;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.*;
public class Main implements ActionListener{
		private JFrame f;
		private PanelX p;
		private LightButton butStart;
		private LightButton butHelp;
		private LightButton butExit;
		private int width,height;
		private JDialog set;
		protected int style;
		private String mode;
		private boolean shit;
		private Help help=new Help(); 
		AudioClip backGroundSound;
		public Main(){
			setF(new JFrame("Pushing Box"));
			p=new PanelX();
			p.setLayout(null);
			butStart=new LightButton(20,210,140,50,"START");
			butHelp=new LightButton(20,263,140,50,"HELP");
			butExit=new LightButton(20,316,140,50,"EXIT");
			butStart.addActionListener(this);
			butHelp.addActionListener(this);
			butExit.addActionListener(this);
			p.add(butStart);
			p.add(butHelp);
			p.add(butExit);
			getF().add(p);
			getF().setSize(0,0);
			width=800;height=830;
			getF().setDefaultCloseOperation(3);
			getF().setResizable(false);
			getF().setVisible(true);
			for (int i = 0; i <= width; i+=60) {
					getF().setSize(i,i*(height/width));
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {}
				
			}
			backGroundSound = Applet.newAudioClip (getCompleteURL ("gimme_my_sword_Zelda.wav"));
			backGroundSound.loop ();
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main();
	}
	private class PanelX extends JPanel
	{
		private static final long serialVersionUID = 5954299196924652990L;
		private ImageIcon background;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			background=new ImageIcon("Mainbackground.png");
			g.drawImage(background.getImage(), 0, 0, 800, 830, 0, 0, background.getIconWidth(), background.getIconHeight(), null);
		}
	}
	public void over()
	{
		for (int i = width; i >=0; i-=60) {
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
			System.exit(0);
		}
		else if(e.getSource()==butStart)
		{
			dialog();
			if(shit==false){
			try {
				new MainFrame(style, mode);
			} catch (Exception e1) {
			}
			}
		}
		else if(e.getSource()==butHelp)
		{
			help.setVisible(true);
		}
	}
	private void dialog() {
		// TODO Auto-generated method stub
		set = new JDialog(f,true);
		set.setVisible(false);
		set.setTitle("map setting");
		set.setBounds(200,100, 400, 600);
		JLabel Show=new JLabel(new ImageIcon("start.png"));
		Show.setBounds(150, 0, 243, 400);
		ButtonGroup mapGroup=new ButtonGroup();
		final JRadioButton map1=new JRadioButton("easy level");
		final JRadioButton map2=new JRadioButton("normal level");
		final JRadioButton map3=new JRadioButton("hard level");
		map1.setSelected(true);
		mapGroup.add(map1);
		mapGroup.add(map2);
		mapGroup.add(map3);
		Font mapFont = new Font("Arial",3,16);
		map1.setFont(mapFont);
		map2.setFont(mapFont);
		map3.setFont(mapFont);
		map1.setBounds(0, 0, 150, 120);
		map2.setBounds(0, 140, 150, 120);
		map3.setBounds(0, 280, 150, 120);
		JPanel pdialog = new JPanel(null);
		final JComboBox<String> list = new JComboBox<String>();
		list.addItem("time record mode");
		list.addItem("practice mode");
		list.setBounds(100, 410, 250, 30);
		JLabel labMap = new JLabel("mode");
		labMap.setFont(new Font("Arial", 1, 20));
		labMap.setBounds(20, 410, 80, 30);
		JButton butOk = new JButton("start game");
		butOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode=(String)list.getSelectedItem();
				set.setVisible(false);
				if(map1.isSelected())	style=1;		
				else if(map2.isSelected()) style=2;
				else if (map3.isSelected()) style=3;
				over();
			}
		});
		set.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
            	shit=true;
            }
        } );
		butOk.setBounds(120, 470, 140, 30);
		pdialog.add(map1);
		pdialog.add(map2);
		pdialog.add(map3);
		pdialog.add(butOk);
		pdialog.add(labMap);
		pdialog.add(list);
		pdialog.add(Show);
		set.add(pdialog);
		set.setVisible(true);
		
	}
	public void setF(JFrame f) {
		this.f = f;
	}
	public JFrame getF() {
		return f;
	}
	public URL getCompleteURL (String fileName)
	{
		try
		{
			return new URL ("file:" + System.getProperty ("user.dir") + "/" + fileName);
		}
		catch (MalformedURLException e)
		{
			System.err.println (e.getMessage ());
		}
		return null;
	}

}
