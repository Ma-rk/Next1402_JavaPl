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
	
/**
 * 한번 초기화한 객체 데이터를 set method를 통해 변경하지 않도록 하는 습관을 들인다. from javajigi
 */
}