package ladder4;

import java.util.ArrayList;
import java.util.Random;

/*
 * 사다리를 구성하는 변수와
 * 사다리 생성 및 출력에 필요한 메소드를 가진 클래스 
 */
class GenerateLadder {
	ArrayList<int[]> ladderAL;
	int columns;
	int columnLength;

	static int BAR_DENSITY = 3;

	GenerateLadder(int columns, int columnLength, ArrayList<int[]> ladderAL) {
		this.columns = columns;
		this.columnLength = columnLength;
		this.ladderAL=ladderAL;
		generateLadder();
	}

	// generate columns 칼럼 생성
	void generateLadder() {
		for (int i = 0; i < columns; i++) {
			//int[] asdf =new int[columnLength];
			//ladderAL.add(asdf);
			ladderAL.add(new int[columnLength]);
		}
	}

	// insert bars between columns 생성된 칼럼들 사이에 바 삽입
	void insertBars() {
		Random rd = new Random();
		for (int x = 0; x < columns - 1; x++) {// 맨 마지막 칼럼의 직전 칼럼까지만 돈다
			for (int y = 0; y < columnLength; y++) {
				if (ladderAL.get(x)[y] == 0 && rd.nextInt(BAR_DENSITY) == 0) {
					ladderAL.get(x)[y] = 1;
					ladderAL.get(x + 1)[y] = -1;
				}
			}
		}
	}
}