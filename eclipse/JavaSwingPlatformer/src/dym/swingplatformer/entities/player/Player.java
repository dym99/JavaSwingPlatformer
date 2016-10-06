package dym.swingplatformer.entities.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dym.swingplatformer.Input;
import dym.swingplatformer.entities.Entity;
import dym.swingplatformer.physics.Rect;
import dym.swingplatformer.physics.Vector2;

public class Player extends Entity{
	public double yvel,xvel;
	private boolean ground;
	public double friction = 0.3;
	public int x=1280/2,y=720/2+6,r=320/2,h=720/2+32;
	private int jumps = 0;
	public Player(Rect bbox, Rect hbox) {
		super(bbox, hbox);
		xvel = 0;
		yvel = 0;
		ground = false;
	}
	public Player(Rect hbox) {
		super(hbox);
	}
	@Override
	public void update() {
		yvel+=0.2;
		if (yvel>16) yvel = 16;
		//Ground collision
		ground = (getHBox().getBottom().y>=h)&&(Math.pow(getHBox().getBottom().x-x,2)+Math.pow(getHBox().getBottom().y-y,2)<=r*r);

		if ((getHBox().getTop().y>=h)&&(Math.pow(getHBox().getBottom().x-x,2)+Math.pow(getHBox().getBottom().y-y,2)<=r*r)) {
			//Hit head on bottom
			if (yvel < 0)
				yvel = 0;
			if (ground) ground=false;
		}
		if ((getHBox().getLeft().y>=h)&&(Math.pow(getHBox().getBottom().x-x,2)+Math.pow(getHBox().getBottom().y-y,2)<=r*r)) {
			//Hit left side on island
			if (xvel<0)
				xvel = 0;
		}
		if ((getHBox().getRight().y>=h)&&(Math.pow(getHBox().getBottom().x-x,2)+Math.pow(getHBox().getBottom().y-y,2)<=r*r)) {
			//Hit right side on island
			if (xvel>0)
				xvel = 0;
		}
		if (ground) {
			if (this.yvel > 0)
				this.yvel = 0;
			this.setPos(new Vector2(getHBox().x,h-32));
			jumps = 4;
		}
		//
		if (Input.keysDown.contains(KeyEvent.VK_LEFT)) {
			xvel-=friction;
			if (xvel<-4) {
				xvel = -4;
			}
		} else {
			if (xvel<0)
				xvel+=friction;
		}
		if (Input.keysDown.contains(KeyEvent.VK_RIGHT)) {
			xvel+=friction;
			if (xvel>4) {
				xvel = 4;
			}
		} else {
			if (xvel>0)
				xvel-=friction;
		}
		if (Input.keysDown.contains(KeyEvent.VK_Z)) {
			jump();
			Input.keysDown.remove((Object)KeyEvent.VK_Z);
		}
		if (Input.keysDown.contains(KeyEvent.VK_X)) {
			lightAttack();
			Input.keysDown.remove((Object)KeyEvent.VK_X);
		}
		if (Input.keysDown.contains(KeyEvent.VK_C)) {
			if (!ground) {
				if (jumps>0) {
					yvel = -5;	
					jumps--;
				}
			}
			Input.keysDown.remove((Object)KeyEvent.VK_C);
		}

		
		
		
		move(new Vector2(xvel,yvel));
		if (Math.abs(xvel)<=friction&&!Input.keysDown.contains(KeyEvent.VK_LEFT)&&!Input.keysDown.contains(KeyEvent.VK_RIGHT)) xvel=0;
	}
	public void jump() {
		if (ground||jumps>1) {
			yvel = -5;	
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
		if (!ground) {
			if (jumps>0) {
				yvel = -5;	
				jumps--;
			}
		}
	}

}
