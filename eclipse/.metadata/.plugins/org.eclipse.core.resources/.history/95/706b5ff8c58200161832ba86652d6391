package dym.swingplatformer.entities;

import java.awt.Graphics;

import dym.swingplatformer.physics.Rect;
import dym.swingplatformer.physics.Vector2;

public abstract class Entity {
	private Rect bbox,hbox;
	public Entity(Rect bbox, Rect hbox) {
		this.bbox = bbox;
		this.hbox = hbox;
	}
	public Entity(Rect hbox) {
		this.bbox = hbox;
		this.hbox = hbox;
	}
	public void update() {
		
	}
	public void drawme(Graphics g) {
		
	}
	public void move(Vector2 mov) {
		bbox.x+=mov.x;
		bbox.y+=mov.y;
		hbox.x+=mov.x;
		hbox.y+=mov.y;
	}
	public Rect getBBox() {
		return bbox;
	}
	public Rect getHBox() {
		return hbox;
	}
}
