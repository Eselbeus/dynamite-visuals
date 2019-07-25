package dynamite;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Timer;


public class Dynamite {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
	}
		
	private static void createAndShowGUI() {
	    JFrame jf = new JFrame("Swing Paint Demo");
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.setSize(1280, 720);
	    jf.add(new MyPanel());
	    jf.pack();
	    jf.setVisible(true);
	}
	
}

class MyPanel extends JPanel implements ActionListener {
	
	int backgroundR = 40, backgroundG = 0, backgroundB = 0;
	int x1 = 0, x2 = 500, y1 = 100, y2 = 500;
	Timer tm = new Timer(10, this);
	

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(new Color(backgroundR, 0, 0));
    }

    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.setColor(new Color(backgroundR, 0, 0));
        g.fillRect(0, 0, 1280, 720);
        g.setColor(new Color(200, 200, 200));
        g.fillOval(x1, 7, 5, 5);
        tm.start();
    }  
    
	public void actionPerformed(ActionEvent e) {
		x1++;
		y1 = y1 + 1;
		backgroundR = backgroundR + 1;
		repaint();
	}
}

