// The "AudioDemo" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AudioDemo implements KeyListener
{
	JFrame frame; // needs to be static since I need to access this in the constructor for the goodbye clip
	JPanel myPanel;
	AudioClip backGroundSound;
	AudioClip beep;
	AudioClip hello;
	AudioClip goodbye; 
	JLabel label;
	
	public AudioDemo ()
	{
		frame = new JFrame ("Audio Demo");
		myPanel = new JPanel ();	
		myPanel.setPreferredSize(new Dimension(500, 100));
		 
		myPanel.setLayout (new BoxLayout (myPanel, BoxLayout.PAGE_AXIS));
		myPanel.setBackground (Color.white);
		myPanel.setBorder (BorderFactory.createEmptyBorder (10,10,10,10));


		backGroundSound = Applet.newAudioClip (getCompleteURL ("loop.au"));
		beep = Applet.newAudioClip (getCompleteURL ("beep.au"));
		hello = Applet.newAudioClip (getCompleteURL ("hello.wav"));
		goodbye = Applet.newAudioClip (getCompleteURL ("goodbye.wav"));

		label = new JLabel ("Press 'H' - Horn or 'B' - Background Sound");	
		myPanel.add (label);
		myPanel.setFocusable (true); // Need this to set the focus to the panel in order to add the keyListener
		myPanel.addKeyListener (this);
		
		// To set "goodbye" to play when window closes
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowClosing (java.awt.event.WindowEvent windowEvent) {
		    	goodbye.play ();
				try
				{
					Thread.sleep (1200);
				}
				catch (InterruptedException e)
				{
				}
		    	System.exit(0);
		    }   
		});		
        
        // Play "hello" when program starts
		hello.play ();
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);



	} // AudioDemo constructor
	
	public void keyPressed (KeyEvent kp) {
		char key = Character.toUpperCase (kp.getKeyChar ());
		if (key == 'H')
			beep.play ();
		else if (key == 'B') {
			label.setText("Background music playing - Press 'H' - Horn");
			backGroundSound.loop ();
		}
		else {
			label.setText ("Press 'H' - Horn or 'B' - Background Sound");
			backGroundSound.stop ();
		}	
	}
	
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
	
	// Gets the URL needed for newAudioClip
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

	public static void main (String [] args){
		new AudioDemo ();
			
		
	}


}