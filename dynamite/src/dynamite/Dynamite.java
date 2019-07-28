package dynamite;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
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
	    JFrame jf = new JFrame("Dynamite");
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
	boolean backgroundRswitch = true;
	Timer tm = new Timer(12, this);
	JLabel jl = new JLabel("Throw me into fire");
	int varyingWidth = 1280, varyingHeight = 720;
	int twoMeasures = 199;
	

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(new Color(backgroundR, 0, 0));
    }

    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        jl.setFont(new Font("Serif", Font.ITALIC, 48));
        jl.setForeground(Color.GRAY);
        g.setColor(new Color(backgroundR, 0, 0));
        g.fillRect(0, 0, varyingWidth, varyingHeight);
        g.setColor(new Color(200, 200, 200));
        g.fillOval(x1, 7, 5, 5);
        
//        if (x1 >= 200) {
//        	g.fillOval(x1, 70, 5, 5);
//        }
        if (varyingWidth == 0) {
        	varyingWidth = 1280;
        	varyingHeight = 720;
        }
        if (x1 == twoMeasures) {
        	jl.setText("It's better than the sea");
    	}
        if (x1 == twoMeasures * 2) {
        	jl.setText("Hold on tight I'm dynamite");
    	}
        if (x1 == twoMeasures * 3) {
        	jl.setText("...I'll make you history");
    	}
        if (x1 >= twoMeasures * 5 && x1 < 1912) {
        	jl.setText("");
//        	g.setColor(new Color(backgroundR, 0, 0, 100));
//        	g.fillRect(0, 0, 1280, 720);
        	varyingWidth -= 2;
        	varyingHeight--;
        }
        if (x1 >= 956) {
        	
        }
        if (x1 == 1912) {
        	jl.setText("Throw me into fire");
        	varyingWidth = 1280;
        	varyingHeight = 720;
        }
        if (x1 == 1912 + twoMeasures * 2) {
        	jl.setText("It's better than the sea");
        }
        if (x1 == 1912 + twoMeasures * 3) {
        	jl.setText("Hold on tight I'm dynamite");
    	}
        if (x1 == 1912 + twoMeasures * 4) {
        	jl.setText("...I'll make you history");
    	}
        
    	this.add(jl);
        tm.start();
    }  
    
	public void actionPerformed(ActionEvent e) {
		x1++;
		y1 = y1 + 1;
		if (backgroundRswitch == true) {
			backgroundR++;
			if (backgroundR >= 250) {
				backgroundRswitch = false;
			}
		}
		else {
			backgroundR--;
			if (backgroundR <= 10) {
				backgroundRswitch = true;
			}
		}
		repaint();
	}
}

