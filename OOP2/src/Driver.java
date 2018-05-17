//Tingda Du
//May 1st
//Description: A program to operate about a series of CDs and songs in one particular CD 
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import lightButton.LightButton;
public class Driver implements MouseListener {
	//The initialized JFrame components for the main driver
	static JFrame frame;
	private PanelX myPanel;
	private JPanel subMenuOne;
	static JPanel subMenuTwo;
	private LightButton wholeCD, certainCD, exit;
	private LightButton displayAll, displayOne, addCD, removeCD, copyCD, subCD, commonSongs, returnMenu;
	private LightButton displayAllSong, displayOneSong, addSong, removeSong, sortSong, returnMenuTwo;
	private static int width, height;
	private JLabel title;
	private JLabel subtitleOne, subtitleTwo;
	private JDialog cdtitle,songtitle;
    private JTextArea textArea;
	AudioClip backGroundSound;

    static ArrayList<CD> cds = new ArrayList<CD>();
    static CD accessedCD;
    
    //constructor to set the layout and basic setting for the panel and frame and the components button inside
	public Driver(){
		frame=new JFrame("CD Driver");
		frame.setLocation(0, 0);
		
		myPanel=new PanelX();
		myPanel.setLayout(null);
		myPanel.setBorder (BorderFactory.createEmptyBorder (50,50,50,50));	
		
		title=new JLabel(new ImageIcon("mainmenu.png"));
		title.setBounds(650,80 , new ImageIcon("mainmenu.png").getIconWidth(), new ImageIcon("mainmenu.png").getIconHeight());

		//The Driver Components
		wholeCD=new LightButton(500,270,440,60,"Accessing your list of CDs");
		certainCD=new LightButton(500,430,440,60,"Accessing within a particular CD");
		exit=new LightButton(800,600,140,60,"Exit");
		wholeCD.addMouseListener(this);
		certainCD.addMouseListener(this);
		exit.addMouseListener(this);
		myPanel.add(wholeCD);
		myPanel.add(certainCD);
		myPanel.add(exit);
		myPanel.add(title);
		
		//set the submenuOne's components and get ready
		subtitleOne=new JLabel(new ImageIcon("Subtitleone.png"));
		subtitleOne.setBounds(70,25,900,60);
		displayAll=new LightButton(100,110,800,60,"Display a list of all your CD");
		displayOne=new LightButton(100,190,800,60,"Display information on a particular CD");
		addCD=new LightButton(100,270,800,60,"Add a CD");
		removeCD=new LightButton(100,350,800,60,"Remove a CD");
		copyCD=new LightButton(100,430,800,60,"Copy a CD");
		subCD=new LightButton(100,510,800,60,"Create a Sub-CD");
		commonSongs=new LightButton(100,590,800,60,"List songs in common between 2 CDs");
		returnMenu=new LightButton(100,670,800,60,"Return back to main menu");
		displayAll.addMouseListener(this);
		displayOne.addMouseListener(this);
		addCD.addMouseListener(this);
		removeCD.addMouseListener(this);
		copyCD.addMouseListener(this);
		subCD.addMouseListener(this);
		commonSongs.addMouseListener(this);
		returnMenu.addMouseListener(this);
		subMenuOne=new JPanel();
		subMenuOne.setLayout(null);
		subMenuOne.setBackground(Color.BLACK);
		subMenuOne.add(displayAll);
		subMenuOne.add(displayOne);
		subMenuOne.add(addCD);
		subMenuOne.add(removeCD);
		subMenuOne.add(copyCD);
		subMenuOne.add(subCD);
		subMenuOne.add(commonSongs);
		subMenuOne.add(returnMenu);
		subMenuOne.add(subtitleOne);
		
		//set the submenuTwo's components and get ready

		subtitleTwo=new JLabel(new ImageIcon("Subtitletwo.png"));
		subtitleTwo.setBounds(70,25,900,60);
		displayAllSong=new LightButton(100,130,800,60,"Display all songs");
		displayOneSong=new LightButton(100,230,800,60,"Display information on a particular song");
		addSong=new LightButton(100,330,800,60,"Add a song");
		removeSong=new LightButton(100,430,800,60,"Remove a song");
		sortSong=new LightButton(100,530,800,60,"Sort songs");
		returnMenuTwo=new LightButton(100,630,800,60,"Return back to main menu");
		displayAllSong.addMouseListener(this);
		displayOneSong.addMouseListener(this);
		addSong.addMouseListener(this);
		removeSong.addMouseListener(this);
		sortSong.addMouseListener(this);
		returnMenuTwo.addMouseListener(this);
		subMenuTwo=new JPanel();
		subMenuTwo.setLayout(null);
		subMenuTwo.setBackground(new Color(156, 93, 82));
		subMenuTwo.add(displayAllSong);
		subMenuTwo.add(displayOneSong);
		subMenuTwo.add(addSong);
		subMenuTwo.add(removeSong);
		subMenuTwo.add(sortSong);
		subMenuTwo.add(returnMenuTwo);
		subMenuTwo.add(subtitleTwo);

		
		//Add driver's panel first to the frame
		frame.add(myPanel);
		frame.pack();
		frame.setSize(0,0);
		width=1500;height=1000;		
		frame.setDefaultCloseOperation(3);
		frame.setResizable(true);
		frame.setVisible(true);
		for (int i = 0; i <= height; i+=100) {
			frame.setSize(i,i*(width/height));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
		String selectedList[]={"qinghuaci.wav","ifyou.wav"};
		backGroundSound = Applet.newAudioClip (getCompleteURL (selectedList[(int)(Math.random()*2)]));
		backGroundSound.loop ();
	}
	//The driver's panel drawing background and JLabel inside
	class PanelX extends JPanel{
		
		private static final long serialVersionUID = 8862340853467366488L;
		private ImageIcon background;
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			this.setBackground(Color.WHITE);
			background=new ImageIcon("Mainbackground.jpeg");
			g.drawImage(background.getImage(), 0, 50, 400, 700, 0, 0, background.getIconWidth(), background.getIconHeight(), null);
			
		}
	}
	//a gradual open method
	public void open(){
		for (int i = 0; i <= height; i+=100) {
			frame.setSize(i,i*(width/height));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
	}
	//a gradual close method
	public void over()
	{
		for (int i = height; i >=0; i-=100) {
			frame.setSize(i,i*(width/height));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
				}
		frame.setVisible(false);
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
	
	public static void main (String[] args) throws IOException, FileNotFoundException{
		//instantiate the Driver
		new Driver();
	}
	
	//using mouselistener to handle the button being hit.
	@Override
	public void mouseClicked(MouseEvent e) {
		//Each button corresponding with different action
		if(e.getSource()==exit){
			over();
			System.exit(0);
		}
		else if(e.getSource()==wholeCD){
			frame.getContentPane().removeAll();
			frame.getContentPane().add(subMenuOne);
			frame.revalidate();
			frame.repaint();
			frame.setVisible(true);
		}
		else if(e.getSource()==certainCD){
			try {
				new SelectCDdialog();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==displayAll){
			cdtitle=new JDialog(frame,true);
			cdtitle.setTitle("All CD names");
			cdtitle.setBounds(200,0,500,700);
			textArea=new JTextArea(10,50);
			textArea.setEditable(false);
			textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
			for(int i = 0; i < cds.size(); i++){
				textArea.append("CD"+(i+1)+": "+cds.get(i).getTitle()+"\n");
			}
			cdtitle.add(new JScrollPane(textArea));
			cdtitle.setVisible(true);
		}
		if(e.getSource()==displayOne){
			try {
				new TestDialog();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==addCD){
			new AddCDdialog();
		}
		if(e.getSource()==removeCD){
			try {
				new removeDialog();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==copyCD){
			try {
				new CopyCDdialog();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==subCD){
			try {
				new SubCDdialog();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==commonSongs){
			try {
				new CommonSongsDialog();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==returnMenu){
			frame.getContentPane().removeAll();
			frame.getContentPane().add(myPanel);
			frame.revalidate();
			frame.repaint();
			frame.setVisible(true);
		}
		if(e.getSource()==displayAllSong){
			songtitle=new JDialog(frame,true);
			songtitle.setTitle("All CD names");
			songtitle.setBounds(200,0,500,700);
			textArea=new JTextArea(10,50);
			textArea.setEditable(false);
			textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
			for(int i = 0; i < accessedCD.songs.size(); i++){
				textArea.append("Song"+(i+1)+": "+accessedCD.songs.get(i).getTitle()+"\n");
			}
			songtitle.add(new JScrollPane(textArea));
			songtitle.setVisible(true);
		}
		if(e.getSource()==displayOneSong){
			try {
				 new DisplayOneSongDialog();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==addSong){
			try {
				  new AddSongDialog();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==removeSong){
			try {
				new removeSongDialog();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==sortSong){
			try {
				new SortSongDialog();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==returnMenuTwo){
			frame.getContentPane().removeAll();
			frame.getContentPane().add(myPanel);
			frame.revalidate();
			frame.repaint();
			frame.setVisible(true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
