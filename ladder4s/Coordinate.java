package ladder4s;

public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int pointX, int pointY) {
		this.x = pointX;
		this.y = pointY;
	}

	public Coordinate(int pointX) {
		this.x = pointX;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	public void resetX() {
		x = 0;
	}
	
	public void resetY() {
		y = 0;
	}

	public void down() {
		incrementY();
	}
}