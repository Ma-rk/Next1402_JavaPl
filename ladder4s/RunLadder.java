package ladder4s;

public class RunLadder {

	static void drawHorizentalLine(String block, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(block);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Ladder ladder = new Ladder();
		ladder.generateLadder(ladder);
		ladder.display(ladder);

	}
}