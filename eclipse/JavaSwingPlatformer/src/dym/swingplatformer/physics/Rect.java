package dym.swingplatformer.physics;

public class Rect {
	public double x,y,w,h;
	public Rect(double w, double h) {
		x = 0;
		y = 0;
		this.w = w;
		this.h = h;
	}
	public Rect(double x, double y, double w, double h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public boolean collideRect(Rect rect) {
		if (this.x<=rect.x+rect.w&&this.x+this.w>=rect.x) {
			if (this.y<=rect.y+rect.h&&this.y+this.h>=rect.y) {
				return true;
			}
		}
		return false;
	}
	public Vector2 getBottom() {
		return new Vector2(x+(w/2),y+h);
	}
	public Vector2 getTop() {
		return new Vector2(x+(w/2),y);
	}
	public Vector2 getLeft() {
		return new Vector2(x,y+(h/2));
	}
	public Vector2 getRight() {
		return new Vector2(x+w,y+(h/2));
	}
}