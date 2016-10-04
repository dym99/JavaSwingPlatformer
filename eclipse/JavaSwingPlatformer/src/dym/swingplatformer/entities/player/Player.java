package dym.swingplatformer.entities.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dym.swingplatformer.Input;
import dym.swingplatformer.entities.Entity;
import dym.swingplatformer.physics.Rect;
import dym.swingplatformer.physics.Vector2;

public class Player extends Entity{
	public double yvel;
	private boolean ground;
	private int jumps = 0;
	public Player(Rect bbox, Rect hbox) {
		super(bbox, hbox);
		yvel = 0;
		ground = false;
	}
	public Player(Rect hbox) {
		super(hbox);
	}
	@Override
	public void update() {
		yvel+=0.3;
		//Ground collision
		if (this.getHBox().y>480-32) {
			if (this.yvel > 0)
				this.yvel = 0;
			this.setPos(new Vector2(getHBox().x,480-32));
		}
		ground = getHBox().collideRect(new Rect(0,480-2,640,32));
		if (ground) {
			jumps = 3;
		}
		//
		if (Input.keysDown.contains(KeyEvent.VK_LEFT)) {
			move(new Vector2(-2,0));
		}
		if (Input.keysDown.contains(KeyEvent.VK_RIGHT)) {
			move(new Vector2(2,0));
		}
		if (Input.keysDown.contains(KeyEvent.VK_Z)) {
			jump();
			Input.keysDown.remove((Object)KeyEvent.VK_Z);
		}
		move(new Vector2(0,yvel));
	}
	public void jump() {
		if (ground||jumps>0) {
			yvel = -6;	
			jumps--;
		}
	}
	@Override
	public void drawme(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)(getBBox().x+0.5), (int)(getBBox().y+0.5), (int)(getBBox().w+0.5), (int)(getBBox().h+0.5));
	}
	
	public void lightAttack() {
		
	}
	public void heavyAttack() {
		
	}

}
