package dym.swingplatformer.physics;

public class Vector2 {
	public double x, y;
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Vector2 add(Vector2 o) {
		this.x+=o.x;
		this.y+=o.y;
		return this;
	}
	public Vector2 sub(Vector2 o) {
		this.x-=o.x;
		this.y-=o.y;
		return this;
	}
	public Vector2 mul(Vector2 o) {
		this.x*=o.x;
		this.y*=o.y;
		return this;
	}
	public Vector2 div(Vector2 o) {
		if (o.x!=0) {
			this.x/=o.x;
		}
		if (o.y!=0) {
			this.y/=o.y;
		}
		return this;
	}
	public Vector2 normalize() {
		double h = Math.sqrt(x*x+y*y);
		if (h!=0) {
			x/=h;
			y/=h;
		}
		return this;
	}
}
