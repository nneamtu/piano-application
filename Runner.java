import java.awt.Color;

import javax.swing.JFrame;

/**
 * Author: Natalie Neamtu
 * Date: Nov 29, 2016
 * Assignment: Runner.java
 */

public class Runner {

	private static String[][] song1 = { {"q", "C5"}, {"w", "D5"}, {"e", "E5"}, {"r", "F5"}, {"t", "G5"}};
	private static String[][] mary = { {"t", "D5"}, {"r", "C5"}, {"3", "Bb4"}, {"r", "C5"},
										{"t", "D5"}, {"t", "D5"}, {"t", "D5"},
										{"r", "C5"}, {"r", "C5"}, {"r", "C5"},
										{"t", "D5"}, {"u", "F5"}, {"u", "F5"},
										{"t", "D5"}, {"r", "C5"}, {"3", "Bb4"}, {"r", "C5"},
										{"t", "D5"}, {"t", "D5"}, {"t", "D5"}, {"t", "D5"},
										{"r", "C5"}, {"r", "C5"}, {"t", "D5"}, {"r", "C5"}, {"3", "Bb4"} };
	private static String[][] beet = { {"]", "E5"}, {"=", "Eb5"}, {"]", "E5"}, {"=", "Eb5"}, {"]", "E5"}, 
										{"o", "B4"}, {"[", "D5"}, {"p", "C5"},
										{"i", "A4"}, //{"q", "A2"}, 
										{"q", "E3"}, {"e", "A3"},
										{"t", "C4"}, {"u", "E4"}, {"o", "A4"}, 
										{"p", "B4"}, //{"q", "E2"}, 
										{"q", "E3"}, {"3", "Ab3"}, 
										{"y", "E4"}, {"8", "Ab4"}, {"o", "B4"}, 
										{"p", "C5"}, //{"q", "A2"}, 
										{"q", "E3"}, {"e", "A3"},
										{"y", "E4"}, {"]", "E5"}, {"=", "Eb5"}, {"]", "E5"}, {"=", "Eb5"}, {"]", "E5"},
										{"o", "B4"}, {"[", "D5"}, {"p", "C5"},
										{"i", "A4"}, //{"q", "A2"}, 
										{"q", "E3"}, {"e", "A3"},
										{"t", "C4"}, {"u", "E4"}, {"o", "A4"},
										{"p", "B4"}, //{"q", "E2"}, 
										{"q", "E3"}, {"3", "Ab3"}, 
										{"y", "E4"}, {"p", "C5"}, {"o", "B4"},  {"i", "A4"} };
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MyJPanel panel = new MyJPanel();

		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.addKeyListener(new MyKeyListener(panel));

		frame.add(panel);
		frame.setSize(1400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		panel.play(beet);
		

	}

}
