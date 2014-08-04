package ladder4;

import java.util.ArrayList;

public class RunLadder {
	private enum Direction {
		HOIZENTAL, VERTICAL
	};

	ArrayList<int[]> ladderAL;
	int columns;
	int columnLength;

	RunLadder(int columns, int columnLength, ArrayList<int[]> ladderAL) {
		this.columns = columns;
		this.columnLength = columnLength;
		this.ladderAL = ladderAL;
	}

	void userExecuteInput() {
		// get the player number
		ReadStdinInt readStdinInt = new ReadStdinInt();

		System.out.println("select player number: ");
		System.out.print("(enter 0 to quit)");
		int selectedPlayerNumber = ReadStdinInt.getInt(columns);

		// run the ladder game
		while (selectedPlayerNumber != 0) {
			runLadder(selectedPlayerNumber);

			System.out.println("select player number: ");
			System.out.print("(enter 0 to quit)");
			selectedPlayerNumber = readStdinInt.getInt(columns);
		}
		System.out.println("==game over==");
	}

	// run the game
	void runLadder(int selectedPlayerNumber) {
		Direction lastMovedDirection = Direction.VERTICAL;
		Coordinate cp = new Coordinate(selectedPlayerNumber - 1, 0);

		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		while (cp.getPointY() < columnLength) {

			displayCurrentPoint(cp);// 루프 돌 때마다 현재 상태를 화면에 출력

			if (cp.getPointY() > columnLength - 1) {// 사다리의 맨 밑을 벗어나면 중단
				break;
			} else if (ladderAL.get(cp.getPointX())[cp.getPointY()] == 0 || lastMovedDirection == Direction.HOIZENTAL) {
				// 노드의 값이 0이거나 지난번 이동이 좌우이동이었으면 한줄 아래로 이동
				cp.setPointY(cp.getPointY() + 1);
				lastMovedDirection = Direction.VERTICAL;
			} else {// 아니면 좌나 우로 이동
				if (ladderAL.get(cp.getPointX())[cp.getPointY()] >= 0) {
					cp.setPointY(ladderAL.get(cp.getPointX())[cp.getPointY()]-1);
					cp.setPointX(cp.getPointX() + 1);
				} else if (ladderAL.get(cp.getPointX())[cp.getPointY()] <= 0) {
					cp.setPointY(-ladderAL.get(cp.getPointX())[cp.getPointY()]-1);
					cp.setPointX(cp.getPointX() - 1);
				}
				lastMovedDirection = Direction.HOIZENTAL;
			}
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}

	void displayCurrentPoint(Coordinate cp) {
		for (int y = 0; y < columnLength; y++) {
			for (int x = 0; x < columns; x++) {
				if (cp.getPointX() == x && cp.getPointY() == y) {
					System.out.print(ladderAL.get(x)[y] + " *");
				} else {
					System.out.print(ladderAL.get(x)[y]);
				}
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("======================================================");
	}
}
