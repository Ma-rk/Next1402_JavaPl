package ladder4;

import java.util.ArrayList;

public class Ladder4 {
	/*
	* 요구사항: 사다리 타기 프로그램이 실행되는 과정을 콘솔을 통해 확인할 수 있도록 한다.
	*/
	public static void main(String[] args) {

		ReadStdinInt readStdinInt = new ReadStdinInt();

		ArrayList<int[]> ladderAL = new ArrayList<int[]>();

		// 사다리 칼럼의 개수
		System.out.print("사다리 기둥의 개수를 입력하세요: ");
		int columns = readStdinInt.getInt();

		// 칼럼의 길이
		System.out.print("사다리 기둥의 길이를 설정하세요: ");
		int columnLength = readStdinInt.getInt();

		// 입력한 개수의 칼럼을 가진 사다리 생성
		GenerateLadder ladderGenerate = new GenerateLadder(columns, columnLength, ladderAL);
		ladderGenerate.insertBars();


		// execute game
		RunLadder ladderRun=new RunLadder(columns, columnLength, ladderAL);
		ladderRun.userExecuteInput();
	}
}
