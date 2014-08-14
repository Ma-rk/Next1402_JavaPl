package ladder4;

public class RunLadder {
	private enum Direction {
		HOIZENTAL, VERTICAL
	};

	int columns;
	int columnLength;

	RunLadder(int columns, int columnLength) {
		this.columns = columns;
		this.columnLength = columnLength;
	}

	void userExecuteInput() {
		System.out.println("select player number: ");
		System.out.print("(enter 0 to quit)");
		int selectedPlayerNumber = ladder4.ReadStdinInt.getInt(columns);

		// run the ladder game
		while (selectedPlayerNumber != 0) {
			runLadder(selectedPlayerNumber);

			System.out.println("select player number: ");
			System.out.print("(enter 0 to quit)");
			selectedPlayerNumber = ladder4.ReadStdinInt.getInt(columns);
		}
		System.out.println("==game over==");
	}

	// run the game
	void runLadder(int selectedPlayerNumber) {
		Direction lastMovedDirection = Direction.VERTICAL;
		Coordinate cp = new Coordinate(selectedPlayerNumber - 1, 0);

		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		while (cp.getY() < columnLength) {

			displayCurrentPoint(cp);// 루프 돌 때마다 현재 상태를 화면에 출력

			if (Ladder4.ladderAL.get(cp.getX())[cp.getY()] == 0 || lastMovedDirection == Direction.HOIZENTAL) {
				cp.down();
				lastMovedDirection = Direction.VERTICAL;
			} else {// 아니면 좌나 우로 이동
				if (Ladder4.ladderAL.get(cp.getX())[cp.getY()] > 0) {
					cp.right();
				} else if (Ladder4.ladderAL.get(cp.getX())[cp.getY()] < 0) {
					cp.left();
				}
				lastMovedDirection = Direction.HOIZENTAL;
			}
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}

	void displayCurrentPoint(Coordinate cp) {
		for (int y = 0; y < columnLength; y++) {
			for (int x = 0; x < columns; x++) {
				System.out.print(Ladder4.ladderAL.get(x)[y]);
				if (cp.getX() == x && cp.getY() == y) {
					System.out.print(" *");
				}
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("======================================================");
	}
}
