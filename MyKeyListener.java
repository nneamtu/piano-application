import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Author: Natalie Neamtu
 * Date: Nov 29, 2016
 * Assignment: MyKeyListener.java
 */

public class MyKeyListener implements KeyListener {
	private MyJPanel panel;

	public MyKeyListener(MyJPanel p){
		panel = p;
	}

	@Override
	public void keyTyped(KeyEvent e){
		if (panel.hasKeysLeft() && Character.toString(e.getKeyChar()).equals(panel.getCurrentKey())){
			playFile(panel.getCurrentNote() + ".wav");
			panel.goToNextKey();
		}
	}

	private void playFile(String filename){
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		AudioStream a = null;
		try {
			a = new AudioStream(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		AudioPlayer.player.start(a);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

}
