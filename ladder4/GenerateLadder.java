package ladder4;

import java.util.ArrayList;
import java.util.Random;

/**
 * @FileName: GenerateLadder.java
 * @Project : ladder4
 * @Date : 2014. 7. 30.
 * @author : markk
 * @history :
 * @desc :
 */

/**
 * 사용자의 값을 입력받는 부분과 사다리타기를 생성하는 부분을 분리해본다.
 * 현재는 이 클래스가 2개 이상의 역할을 하고 있다. from javajigi
 */
class GenerateLadder {
	ArrayList<int[]> ladderAL;
	int columns;
	int columnLength;

	static int BAR_DENSITY = 3; // the value will be applied as 1/BAR_DENSITY

	GenerateLadder(int columns, int columnLength, ArrayList<int[]> ladderAL) {
		this.columns = columns;
		this.columnLength = columnLength;
		this.ladderAL = ladderAL;
		generateLadder();
	}

	void generateLadder() {
		for (int i = 0; i < columns; i++) {
			ladderAL.add(new int[columnLength]);
		}
	}

	// insert bars between columns
	void insertBars() {
		System.out.println("선택한 위치에 bar를 삽입합니다.");
		System.out.println("지정한 칼럼과 그 다음 칼럼의 사이에 삽입됩니다. 맨 마지막 칼럼은 선택할 수 없습니다.");
		boolean insertingBar = true;
		while (insertingBar) {

			int targetColumn = 0;
			int targetIndex1 = 0;
			boolean selectingLeftPoint = true;
			while (selectingLeftPoint) {

				System.out.println("삽입할 bar의 좌측 점의 x좌표를 입력하세요.");
				targetColumn = ReadStdinInt.getInt(columns - 1);

				System.out.println("삽입할 bar의 좌측 점의 y좌표를 입력하세요.");
				targetIndex1 = ReadStdinInt.getInt(columnLength);

				if (ladderAL.get(targetColumn - 1)[targetIndex1 - 1] != 0) {
					System.out.println("선택한 좌표에는 이미 값이 입력돼 있습니다. 다른 좌표를 선택해 주세요.");
				} else {
					selectingLeftPoint = false;
				}
			}

			int targetIndex2 = 0;
			boolean selectingRightPoint = true;
			while (selectingRightPoint) {
				System.out.println("삽입할 bar의 우측 점의 y좌표를 입력하세요.");
				targetIndex2 = ReadStdinInt.getInt(columnLength);

				if (ladderAL.get(targetColumn - 1 + 1)[targetIndex2 - 1] != 0) {
					System.out.println("선택한 좌표에는 이미 값이 입력돼 있습니다. 다른 좌표를 선택해 주세요.");
				} else {
					selectingRightPoint = false;
				}
			}

			ladderAL.get(targetColumn - 1)[targetIndex1 - 1] = targetIndex2;
			ladderAL.get(targetColumn - 1 + 1)[targetIndex2 - 1] = -targetIndex1;
			System.out.println("다음과 같은 위치에 bar를 입력했습니다.");
			displayCurrentBars();

			System.out.println("bar를 더 입력하시겠습니까? (1: 계속 입력, 2: 중단)");
			if (ReadStdinInt.getInt() != 1) {
				break;
			}
		}
	}

	void displayCurrentBars() {
		for (int y = 0; y < columnLength; y++) {
			for (int x = 0; x < columns; x++) {
				System.out.print(ladderAL.get(x)[y]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("======================================================");
	}

}