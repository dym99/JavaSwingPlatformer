package dym.swingplatformer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Display extends JPanel {
	
	private static final long serialVersionUID = -8020239050987765909L;
	
	public Display() {
		
	}
	
	public void update() {
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 480);
	}
}
