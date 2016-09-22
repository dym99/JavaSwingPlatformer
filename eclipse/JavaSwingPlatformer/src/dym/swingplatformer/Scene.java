package dym.swingplatformer;

import java.awt.Graphics;
import java.util.ArrayList;

import dym.swingplatformer.entities.Entity;

public class Scene {
	public ArrayList<Entity> ent;
	public Scene(ArrayList<Entity> entities) {
		ent = entities;
	}
	public void drawme(Graphics g) {
		for (Entity e : ent) {
			e.drawme(g);
		}
	}
}
