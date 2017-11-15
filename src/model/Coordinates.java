package model;

public class Coordinates implements Comparable<Coordinates> {
	
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
	
	@Override
	public int compareTo(Coordinates c) {
		if(x < c.x) {
			return -1;
		} else if(x == c.x) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
