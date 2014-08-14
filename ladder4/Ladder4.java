package ladder4;

import java.util.ArrayList;

public class Ladder4 {
	public static ArrayList<int[]> ladderAL = new ArrayList<int[]>();

	public static void main(String[] args) {

		// number of columns of ladder
		System.out.print("사다리 기둥의 개수를 입력하세요: ");
		int columns = ReadStdinInt.getInt();

		// number of bars of ladder
		System.out.print("사다리 기둥의 길이를 설정하세요: ");
		int columnLength = ReadStdinInt.getInt();

		// generate ladder
		GenerateLadder ladderGenerate = new GenerateLadder(columns, columnLength);
		ladderGenerate.insertBars();

		// execute game
		RunLadder ladderRun = new RunLadder(columns, columnLength);
		ladderRun.userExecuteInput();
	}
}
