package model;

public class Coordinates {
	
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + getX() + "," + getY() + "]";
	}
	
	public int distanceTo(Coordinates c) {
		return (Math.abs(x-c.getX()) + Math.abs(y-c.getY()));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
