package dynamite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
	boolean backgroundRswitch = true, rectMoveSwitchX = false, rectMoveSwitchY = false, rectMoveSwitchNegX = false, rectMoveSwitchNegY = false;
	Timer tm = new Timer(12, this);
	JLabel jl = new JLabel("Throw me into fire");
	int varyingWidth = 1280, varyingHeight = 720;
	int twoMeasures = 234;
	int timeCorrection = 80, timeCorrection2 = 0, timeCorrection3 = -40;
	int rectWidth = 100, rectHeight = 100, rectX = 200, rectY = 200;
	int rectWidthBridge = 100, rectHeightBridge = 100, rectXBridge = 640, rectYBridge = 360;
	int radians = 0, bridgeRadians = 0;
	boolean bridge = false, newRedSwitch = false, finalChorus = false, finalSizeSwitch = false;
	int newRed = 250;

    public MyPanel() {
        setBackground(new Color(backgroundR, 0, 0));
    }

    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        jl.setFont(new Font("Serif", Font.ITALIC, 60));
        jl.setForeground(Color.GRAY);
        g.setColor(new Color(backgroundR, 0, 0));
        g.fillRect(0, 0, varyingWidth, varyingHeight);
        g.setColor(new Color(200, 200, 200));
        g.fillOval(x1, -7, 5, 5);
        Graphics2D g2dim = (Graphics2D)g;
        
        if (varyingWidth == 0) {
        	varyingWidth = 1280;
        	varyingHeight = 720;
        }
        if (x1 == twoMeasures * 2) {
        	jl.setText("It's better than the sea");
    	}
        if (x1 == twoMeasures * 4) {
        	jl.setText("Hold on tight I'm dynamite, I'll");
    	}
        if (x1 == twoMeasures * 6) {
        	jl.setText("...make you history");
    	}
        if (x1 >= twoMeasures * 10 && x1 < twoMeasures * 46) {
        	jl.setText("");

        	varyingWidth -= 2;
        	varyingHeight--;
        }
        
        if (x1 == twoMeasures * 46 + timeCorrection) {
        	jl.setText("Throw me into fire");
        	varyingWidth = 1280;
        	varyingHeight = 720;
        }
        if (x1 == twoMeasures * 48 + timeCorrection) {
        	jl.setText("It's better than the sea");
        }
        if (x1 == twoMeasures * 50 + timeCorrection) {
        	jl.setText("Hold on tight I'm dynamite, I'll");
    	}
        if (x1 == twoMeasures * 52 + timeCorrection) {
        	jl.setText("...make you history");
    	}
        
        if (x1 >= twoMeasures * 57 + timeCorrection && x1 < (twoMeasures * 93) + timeCorrection2) {
        	jl.setText("");
        	g.setColor(new Color(0, 200, 0, 100));

            for (int i = 0; i < 350; i+=10) {
            	Rectangle rect3 = new Rectangle(rectX, rectY, rectWidth, rectHeight);
            	g2dim.rotate(Math.toRadians(radians + 1), rectX, rectY);
            	g2dim.draw(rect3);
                g2dim.fill(rect3);
            }
        	rectMoveSwitchX = true;
        	varyingWidth -= 2;
        	varyingHeight--;
        }
        
        if (rectX >= 1000) {
        	rectMoveSwitchX = false;
        	rectMoveSwitchY = true;
        	rectMoveSwitchNegX = false;
        	rectMoveSwitchNegY = false;
        }
        if (rectY >= 500) {
        	rectMoveSwitchY = false;
        	rectMoveSwitchX = false;
        	rectMoveSwitchNegX = true;
        	rectMoveSwitchNegY = false;
        }
        if (rectX < 200) {
        	rectMoveSwitchNegX = false;
        	rectMoveSwitchX = false;
        	rectMoveSwitchNegY = true;
        	rectMoveSwitchY = false;
        }
        if (rectY < 200) {
        	rectMoveSwitchX = true;
        	rectMoveSwitchY = false;
        	rectMoveSwitchNegX = false;
        	rectMoveSwitchNegY = false;
        }
        
        
        if (x1 == twoMeasures * 93 + timeCorrection2) {
        	jl.setText("Throw me into fire");
        	varyingWidth = 1280;
        	varyingHeight = 720;
        }
        if (x1 == twoMeasures * 95 + timeCorrection2) {
        	jl.setText("It's better than the sea");
        }
        if (x1 == twoMeasures * 97 + timeCorrection2) {
        	jl.setText("Hold on tight I'm dynamite, I'll");
    	}
        if (x1 == twoMeasures * 99 + timeCorrection2) {
        	jl.setText("...make you history");
    	}
        
        if (x1 == twoMeasures * 101 + timeCorrection3) {
        	jl.setText("Throw me into fire");
        }
        if (x1 == twoMeasures * 103 + timeCorrection3) {
        	jl.setText("It's better than the sea");
        }
        if (x1 == twoMeasures * 105 + timeCorrection3) {
        	jl.setText("Hold on tight I'm dynamite, I'll");
    	}
        if (x1 == twoMeasures * 107 + timeCorrection3) {
        	jl.setText("...make you history");
    	}
        
        if (x1 >= twoMeasures * 108 + timeCorrection2 && x1 < twoMeasures * 115 + timeCorrection3) {
        	jl.setText("");
        	
        	if (x1 % (twoMeasures/2) == 0) {

            	Rectangle rect2 = new Rectangle(0, 0, 1280, 720);
            	g2dim.draw(rect2);
                g2dim.fill(rect2);
    		}
        }
        if (x1 >= twoMeasures * 115 + timeCorrection3 && x1 < twoMeasures * 135 + timeCorrection3) {
        	bridge = true;
        	if (newRed <= 5) {
				newRedSwitch = false;
			}
        	if (newRed >= 250) {
        		newRedSwitch = true;
        	}

        	g.setColor(new Color(200, 200, 0, 50));
        	
        	for (int i = 0; i < 350; i+=10) {
            	Rectangle rect3 = new Rectangle(rectXBridge, rectYBridge, rectWidthBridge, rectHeightBridge);
            	g2dim.rotate(Math.toRadians(bridgeRadians + i), rectXBridge, rectYBridge);
            	g2dim.draw(rect3);
                g2dim.fill(rect3);
            }
        	g.setColor(new Color(newRed, 240, 255, 100));
        	for (int i = 0; i < 350; i+=10) {
            	Rectangle rect3 = new Rectangle(rectXBridge, rectYBridge, rectWidthBridge - 50, rectHeightBridge - 50);
            	g2dim.rotate(Math.toRadians(bridgeRadians + i), rectXBridge, rectYBridge);
            	g2dim.draw(rect3);
                g2dim.fill(rect3);
            }
        }
        if (x1 >= twoMeasures * 135 + timeCorrection3 && x1 <= twoMeasures * 159 + timeCorrection3) {

        	g.setColor(new Color(255, 255, 255));
        	Rectangle rect3 = new Rectangle(0, 0, 1280, 720);
        	g2dim.draw(rect3);
            g2dim.fill(rect3);
            g.setColor(new Color(200, 240, 0, 100));
            
            for (int i = 0; i < 350; i+=10) {
            	Rectangle rect4 = new Rectangle(rectXBridge, rectYBridge, rectWidthBridge, rectHeightBridge);
            	g2dim.rotate(Math.toRadians(bridgeRadians + i), rectXBridge, rectYBridge);
            	g2dim.draw(rect4);
                g2dim.fill(rect4);
            }
        	g.setColor(new Color(255, 240, 90, 120));
        	for (int i = 0; i < 350; i+=10) {
            	Rectangle rect5 = new Rectangle(rectXBridge, rectYBridge, rectWidthBridge - 50, rectHeightBridge - 50);
            	g2dim.rotate(Math.toRadians(bridgeRadians + i), rectXBridge, rectYBridge);
            	g2dim.draw(rect5);
                g2dim.fill(rect5);
            }
        	if (x1 % 20 == 0) {
        		g.setColor(new Color(255, 0, 0, 150));
        		g.fillOval(640, 360, 400, 400);
        		g.setColor(new Color(0, 255, 0, 150));
        		g.fillOval(640, 360, 80, 80);
    		}
        	if (x1 % 16 == 0 ) {
        		g.setColor(new Color(255, 255, 0, 150));
        		g.fillOval(640, 360, 800, 800);
        	}
        	finalChorus = true;
        }
        if (x1 >= twoMeasures * 159 + (timeCorrection3 * 2)) {
        	g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, 1280, 720);
        }

    	this.add(jl);
        tm.start();
    }  
    
	public void actionPerformed(ActionEvent e) {
		x1+=2;
		y1 = y1 + 1;
		if (rectMoveSwitchX == true) {
			rectX++;
			radians++;
		}
		if (rectMoveSwitchY == true) {
			rectY++;
			radians++;
		}
		if (rectMoveSwitchNegX == true) {
			rectX--;
			radians++;
		}
		if (rectMoveSwitchNegY == true) {
			rectY--;
			radians++;
		}

		
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
		
		if (bridge == true) {
			bridgeRadians++;
			if (rectWidthBridge <= 400) {
			rectWidthBridge++;
			rectHeightBridge++;
			newRedSwitch = false;
			}
			else {
				newRedSwitch = true;
			}
		}
		
		if (finalChorus == true && finalSizeSwitch == true) {
			bridgeRadians++;
			rectWidthBridge++;
			rectHeightBridge++;
			if (rectWidthBridge >= 200) {
				finalSizeSwitch = false;
			}
		}
		else if (finalChorus == true && finalSizeSwitch == false) {
			bridgeRadians++;
			rectWidthBridge--;
			rectHeightBridge--;
			if (rectWidthBridge <= 50) {
				finalSizeSwitch = true;
			}
		}
		
		repaint();
	}
}

