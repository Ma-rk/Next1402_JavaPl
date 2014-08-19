package ladder4s;

import java.util.ArrayList;

public class Ladder extends ArrayList<int[]> {
	private int columns;
	private int columnLength;
	private int barDensity;

	// static ArrayList<int[]> ladder = new ArrayList<int[]>();

	public Ladder() {
		getColumns();
		getLadderLength();
		getBarDensity();
	}

	private void getColumns() {
		System.out.println("게임 인원수를 설정하세요.");
		this.columns = ReadStdInt.getNonNegativeInt();
	}

	private void getLadderLength() {
		System.out.println("사다리의 길이를 설정하세요.");
		this.columnLength = ReadStdInt.getNonNegativeInt();
	}

	private void getBarDensity() {
		System.out.println("삽입할 바의 밀도를 설정하세요(입력한 수의 역수로 적용됨).");
		this.barDensity = ReadStdInt.getNonNegativeInt();
	}

	public void generateLadder(Ladder ladder) {
		for (int i = 0; i < columns; i++) {
			ladder.add(new int[columnLength]);
		}
		insertBars(ladder, new Coordinate(0, 0), new Coordinate(0, 0));
	}

	private void connectDots(Ladder ladder, Coordinate leftPoint, Coordinate rightPoint) {
		ladder.get(leftPoint.getX())[leftPoint.getY()] = rightPoint.getY() + 1;
		ladder.get(rightPoint.getX())[rightPoint.getY()] = -(leftPoint.getY() + 1);
	}

	void insertBars(Ladder ladder, Coordinate leftPoint, Coordinate rightPoint) {
		// int에서 1을 빼는 로직을 for문의 조건으로 넣었다. 개선의 여지가 있을까...
		for (leftPoint.getX(); leftPoint.getX() < columns - 1; leftPoint.incrementX()) {
			for (leftPoint.getY(); leftPoint.getY() < columnLength; leftPoint.incrementY()) {
				System.out.println("try left point: " + leftPoint.getX() + ", " + leftPoint.getY());
				if (getBarInsertionPermission() && isEmptyPoint(ladder, leftPoint.getX(), leftPoint.getY())) {
					System.out.println("got left permission");
					rightPoint = getRightPoint(ladder, leftPoint);
					connectDots(ladder, leftPoint, rightPoint);
				}
			}
			leftPoint.resetY();
		}
	}

	private Coordinate getRightPoint(Ladder ladder, Coordinate leftPoint) {
		int rightX = leftPoint.getX() + 1;
		int rightY;
		int i = 0;
		while (true) {
			System.out.println("getRightPoint" + rightX + ", " + i);
			if (getBarInsertionPermission() && isEmptyPoint(ladder, rightX, i)) {
				rightY = i;
				System.out.println("got right permission\n");
				break;
			}
			if (i < columnLength) {
				i++;
			} else {
				i = 0;
			}
		}
		return new Coordinate(rightX, rightY);
	}

	private boolean isEmptyPoint(Ladder ladder, int x, int y) {
		System.out.println("isEmptyPoint: " + x + ", " + y + (ladder.get(x)[y] == 0));
		return ladder.get(x)[y] == 0;
	}

	boolean getBarInsertionPermission() {
		return Math.random() < (1.0 / (double) barDensity);
		// double rv = Math.random();
		// double density = (1.0 / (double) barDensity);
		// if (rv > density)
		// return true;
		// else
		// return false;
	}

	public void display(Ladder ladder) {
		for (int y = 0; y < columnLength; y++) {
			for (int x = 0; x < columns; x++) {
				System.out.print(ladder.get(x)[y] + "\t");
			}
			System.out.println();
		}
		RunLadder.drawHorizentalLine("=", calcLadderWidth());
	}

	int calcLadderWidth() {
		return 8 * (columns - 1) + 3;
	}
}
