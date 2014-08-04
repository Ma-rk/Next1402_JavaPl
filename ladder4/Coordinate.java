package ladder4;

/**
 * @FileName: Coordinate.java
 * @Project : ladder4
 * @Date : 2014. 7. 30.
 * @author : markk
 * @history :
 * @desc : stores coordinate value
 */
public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int pointX, int pointY) {
		this.x = pointX;
		this.y = pointY;
	}

	public int getPointX() {
		return x;
	}

	public void setPointX(int pointX) {
		this.x = pointX;
	}

	public int getPointY() {
		return y;
	}

	public void setPointY(int pointY) {
		this.y = pointY;
	}
}