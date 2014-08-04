package ladder4;

import java.util.ArrayList;

public class Ladder4 {
	public static void main(String[] args) {

		ReadStdinInt readStdinInt = new ReadStdinInt();

		ArrayList<int[]> ladderAL = new ArrayList<int[]>();

		// number of columns of ladder
		System.out.print("사다리 기둥의 개수를 입력하세요: ");
		int columns = readStdinInt.getInt();

		// number of bars of ladder
		System.out.print("사다리 기둥의 길이를 설정하세요: ");
		int columnLength = readStdinInt.getInt();

		// generate ladder
		GenerateLadder ladderGenerate = new GenerateLadder(columns, columnLength, ladderAL);
		ladderGenerate.insertBars();

		// execute game
		RunLadder ladderRun = new RunLadder(columns, columnLength, ladderAL);
		ladderRun.userExecuteInput();
	}
}
