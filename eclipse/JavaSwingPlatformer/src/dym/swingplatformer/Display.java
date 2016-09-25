package dym.swingplatformer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import dym.swingplatformer.entities.Entity;

public class Display extends JPanel {
	
	private static final long serialVersionUID = -8020239050987765909L;
	
	public Display() {
		this.setPreferredSize(new Dimension(640,480));
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 480);
		for (Entity e : SceneManager.ent) {
			e.drawme(g);
		}
	}
}
