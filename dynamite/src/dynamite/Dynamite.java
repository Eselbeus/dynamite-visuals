package dynamite;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Dynamite extends JFrame {
	
	public Dynamite () {
		setSize(1280, 720);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		Dynamite d = new Dynamite();
	}

}
