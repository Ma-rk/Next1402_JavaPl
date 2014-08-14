package ladder4;

public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int pointX, int pointY) {
		this.x = pointX;
		this.y = pointY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void left() {
		y = -Ladder4.ladderAL.get(x)[y] - 1;
		x--;
	}

	public void right() {
		y = Ladder4.ladderAL.get(x)[y] - 1;
		x++;
	}

	public void down() {
		y++;
	}
}