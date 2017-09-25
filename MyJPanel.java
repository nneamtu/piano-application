import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * Author: Natalie Neamtu
 * Date: Nov 24, 2016
 * Assignment: MyJPanel.java
 */

public class MyJPanel extends JPanel {

	private String[][] song;
	private int idx;
	private JLabel header;
	private JLabel[] lr1; //label row 1
	private JLabel[] lr2; //label row 2
	private ArrayList<String> ROW1;
	private ArrayList<String> ROW2;
	private static final Color UNHIGHLIGHTED = Color.WHITE;
	private static final Color HIGHLIGHTED = Color.GREEN;
	
	

	public MyJPanel(){
		idx = 0;
		song = null;
		setLayout(new GridBagLayout());
		header = new JLabel("");
		lr1 = new JLabel[13];
		lr2 = new JLabel[14];
		
		ROW1 = new ArrayList<String>();
		ROW1.add("2");
		ROW1.add("3");
		ROW1.add("4");
		ROW1.add("5");
		ROW1.add("6");
		ROW1.add("7");
		ROW1.add("8");
		ROW1.add("9");
		ROW1.add("0");
		ROW1.add("-");
		ROW1.add("=");
		
		ROW2 = new ArrayList<String>();
		ROW2.add("q");
		ROW2.add("w");
		ROW2.add("e");
		ROW2.add("r");
		ROW2.add("t");
		ROW2.add("y");
		ROW2.add("u");
		ROW2.add("i");
		ROW2.add("o");
		ROW2.add("p");
		ROW2.add("[");
		ROW2.add("]");
		
	}

	//keys represents the desired order of key presses
	//idx represents the next desired position in keys

	public int getIdx(){
		return idx;
	}

	public String getCurrentKey(){
		return song[idx][0];
	}
	
	public String getCurrentNote(){
		return song[idx][1];
	}

	/**
	 * Increases current index by 1
	 * @return true if there are more keys left to play, false if there are no more keys
	 */
	public void goToNextKey(){
		updateKeyGUI(getCurrentKey(), false);
		idx++;
		if (idx < song.length){
			updateKeyGUI(getCurrentKey(), true);
		} else {
			end();
		}
	}


	public boolean hasKeysLeft(){
		return idx < song.length;
	}

	/**
	 * Play given song
	 * @param s the song, in the form: 
	 * [num notes][2]
	 * s[r][0] = key (ex. "q")
	 * s[r][1] = note name (ex. "C4")
	 * 
	 */
	public void play(String[][] s){
		song = s;
		if (song.length > 0){
//			keyName = new JLabel(Character.toString(keys[idx]));
//			keyName.setHorizontalAlignment(SwingConstants.CENTER);
//			keyName.setFont(new Font("Cambria", 0, 50));
//			add(keyName, BorderLayout.CENTER);
			setUpGUI();
			updateKeyGUI(getCurrentKey(), true);
			//revalidate();
			//repaint();
		} else {
			header = new JLabel("Error: there is no song to play.");
			header.setHorizontalAlignment(SwingConstants.CENTER);
			header.setFont(new Font("Cambria", 0, 30));
			add(header, BorderLayout.NORTH);
			revalidate();
			repaint();
		}

	}

	private void end() {
		remove(header);
		revalidate();
		repaint();
		header = new JLabel("All done! Bravo!");
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Cambria", 0, 30));
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 28;
		g.fill = GridBagConstraints.BOTH;
		g.anchor = GridBagConstraints.CENTER;
		g.weighty = 1.0;
		g.weightx = .5;
		add(header, g);
		revalidate();
		repaint();

	}
//	public void test() throws InterruptedException{
//		keyName = new JLabel("1");
//		add(keyName);
//		Thread.sleep(500);
//		remove(keyName);
//		validate();
//		repaint();
//		Thread.sleep(500);
//		keyName = new JLabel("2");
//		add(keyName);
//		validate();
//		repaint();
//	}
	
	private void updateKeyGUI(String key, boolean highlighted){
		int idx;
		if (ROW1.contains(key)){
			idx = ROW1.indexOf(key);
			if (highlighted)
				lr1[idx + 1].setBackground(HIGHLIGHTED);
			else
				lr1[idx + 1].setBackground(UNHIGHLIGHTED);
		} else {
			idx = ROW2.indexOf(key);
			if (highlighted)
				lr2[idx + 1].setBackground(HIGHLIGHTED);
			else
				lr2[idx + 1].setBackground(UNHIGHLIGHTED);
		}
		revalidate();
		repaint();
	}
	/**
	 * Sets up GUI with all keys unhighlighted and header displaying "Press the highlighted key:"
	 */
	public void setUpGUI(){
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		GridBagConstraints g = new GridBagConstraints();
		JLabel[] dummyRow = new JLabel[28];
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		
		
		g.fill = GridBagConstraints.BOTH;
		g.anchor = GridBagConstraints.CENTER;
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = .5;
		g.weighty = 0;
		
		for (int i = 0; i < 28; i++){
			g.gridx = i;
			dummyRow[i] = new JLabel();
			add(dummyRow[i], g);
		}
		
		g.weighty = 1.0;
		g.gridx = 0;
		g.gridy++;
		g.gridwidth = 28;
		header = new JLabel("Press the highlighted key:");
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Cambria", 0, 30));
		add(header, g);
		
		g.weighty = .232;
		g.gridy ++;
		add(blank1, g);
		
		g.weighty = .589;
		g.gridy ++;
		g.gridwidth = 3;
		lr1[0] = new JLabel();
		add(lr1[0], g);
		
		g.gridwidth = 2;
		g.insets = new Insets(2,2,2,2);
		for (int i = 1; i < 12; i++){
			g.gridx = i * 2 + 1;
			lr1[i] = new JLabel(ROW1.get(i-1).toUpperCase());
			lr1[i].setFont(new Font("Cambria", 1, 20));
			lr1[i].setOpaque(true);
			lr1[i].setBackground(UNHIGHLIGHTED);
			lr1[i].setBorder(raisedbevel);
			lr1[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(lr1[i], g);
		}
		
		g.insets = new Insets(0,0,0,0);
		g.gridx = 25;
		g.gridwidth = 3;
		lr1[12] = new JLabel();
		add(lr1[12], g);
		
		g.gridx = 0;
		g.gridy ++;
		g.gridwidth = 2;
		lr2[0] = new JLabel();
		add(lr2[0], g);
		
		g.insets = new Insets(2,2,2,2);
		for (int i = 1; i < 13; i++){
			g.gridx = i * 2;
			lr2[i] = new JLabel(ROW2.get(i-1).toUpperCase());
			lr2[i].setFont(new Font("Cambria", 1, 20));
			lr2[i].setOpaque(true);
			lr2[i].setBackground(UNHIGHLIGHTED);
			lr2[i].setBorder(raisedbevel);
			lr2[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(lr2[i], g);
		}
		
		g.insets = new Insets(0,0,0,0);
		g.gridx = 26;
		lr2[13] = new JLabel();
		add(lr2[13], g);
		
		g.weighty = .901;
		g.gridx = 0;
		g.gridy ++;
		g.gridwidth = 28;
		add(blank2, g);
		
	}
}


