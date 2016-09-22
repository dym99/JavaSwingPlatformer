package dym.swingplatformer.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dym.swingplatformer.Input;
import dym.swingplatformer.physics.Rect;
import dym.swingplatformer.physics.Vector2;

public class Player extends Entity{
	public Player(Rect bbox, Rect hbox) {
		super(bbox, hbox);
	}
	public Player(Rect hbox) {
		super(hbox);
	}
	@Override
	public void update() {
		if (Input.keysDown.contains(KeyEvent.VK_LEFT)) {
			move(new Vector2(-2,0));
		}
		if (Input.keysDown.contains(KeyEvent.VK_RIGHT)) {
			move(new Vector2(2,0));
		}
		if (Input.keysDown.contains(KeyEvent.VK_UP)) {
			move(new Vector2(0,-2));
		}
		if (Input.keysDown.contains(KeyEvent.VK_DOWN)) {
			move(new Vector2(0,2));
		}
	}
	@Override
	public void drawme(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)(getBBox().x+0.5), (int)(getBBox().y+0.5), (int)(getBBox().w+0.5), (int)(getBBox().h+0.5));
	}

}
