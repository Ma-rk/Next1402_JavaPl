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

			/**
			 * if 내의 로직을 Coordinate 객체 내부로 이동해 본다.
			 * 지금과 이 때의 차이점을 인식해 본다. from javajigi
			 */
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
			/**
			 * 위 로직의 복잡도가 너무 높다.
			 * 복잡도를 낮출 수 방법이 없을까?
			 * ladderAL을 가지는 별도의 객체를 이 객체에서 위 로직을 수행하도록 할 수 없을까? 
			 * 4단계 동영상 한번 보면 좋겠다. from javajigi
			 */
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}

	void displayCurrentPoint(Coordinate cp) {
		/**
		 * http://youtu.be/jTD8gjuKJG4 : 디버그 로그 메시지 구현
		 * http://youtu.be/T6-LOoGKgDE : 리팩토링, enum을 활용한 다형성
		 * http://youtu.be/0hn71C22UBI : 리팩토링을 통해 Position 객체 도출
		 * 
		 * 이 동영상을 보고 좀 더 간소화할 수 있는 방법 찾아본다.
		 * 이와 같은 방식으로 앞의 runLadder() 메소드를 리팩토링해 본다. from javajigi
		 */
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
