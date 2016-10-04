package dym.swingplatformer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

import dym.swingplatformer.entities.Entity;

public class Display extends JPanel {
	
	private static final long serialVersionUID = -8020239050987765909L;
	public int x=1280/2,y=720/2+6,r=320/2,h=720/2+32;
	public Display() {
		this.setPreferredSize(new Dimension(1280,720));
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		g.drawImage(Game.testIsland, 1280/2-Game.testIsland.getWidth()/2, 720/2-Game.testIsland.getHeight()/2+128, null);
		g.setColor(Color.GREEN);
		g.drawOval(x-r, y-r, r*2, r*2);
		g.drawLine(0, h, 1280, h);;
		for (Entity e : SceneManager.ent) {
			e.drawme(g);
		}
	}
}
