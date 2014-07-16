package ladder1;

import java.io.*;
import java.util.Random;

/*
 * 칼럼의 개수, 바의 개수에 사용할 정수를 입력받기 위해 사용하는 클래스 
 */
class ReadStdinInt {

	/*
	 * 칼럼의 개수, 바의 개수에 사용할 정수를 입력받기 위해 사용하는 메소드
	 */
	int getInt() {
		String line = null;
		int val = 0;
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(
					System.in));
			line = is.readLine();
			val = Integer.parseInt(line);// 정수 아닌 값 입력시 익셉션 발생
			if (val <= 0) {// 0 이하의 값일때 익셉션 발생
				throw new NumberFormatException();
			}
		} catch (NumberFormatException ex) {
			System.err.println("0보다 큰 정수만 입력하세요: ");
			val = getInt();// 입력한 값이 1 이상의 자연수가 아닐 경우 다시 입력하게 함
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
		return val;
	}
}

/*
 * 사다리를 구성하는 변수와
 * 사다리 생성 및 출력에 필요한 메소드를 가진 클래스 
 */
class GenerateLadder {

	// 사다리의 역할을 하는 배열.
	// 배열 한칸이 사다리의 기둥 하나고, 각 칸에 들어있는 값이 출발 지점을 선택하면 도착하는 도착 지점
	int[] ladderArray = null;
	
	int columns;

	// 생성자를 통해 사다리를 생성한다.
	// 기둥의 개수는 columns의 값으로,
	// 각 기둥별 도착지점 번호는 0부터 시작하여 순차적으로 삽입하여 초기화 한다.
	GenerateLadder(int columns) {
		this.columns=columns;
		ladderArray = new int[columns];
		for (int i = 0; i < columns; i++) {
			ladderArray[i] = i;
		}
	}

	//기둥 사이의 공간의 개수는 (기둥 개수 - 1)이다. 
	//그중 하나를 랜덤으로 골라 그 앞과 뒤의 도착지점의 번호를 스왑함으로써
	//바를 삽입하는 효과를 낸다
	void insertBar(int bars) {
		Random rd = new Random();
		int insertPosition = 0;
		for (int i = 0; i < bars; i++) {
			insertPosition = rd.nextInt(columns - 1);
			swapGoalByBar(insertPosition);
		}
	}

	//지정한 포지션의 앞과 뒤의 도착지점의 번호를 스왑한다
	void swapGoalByBar(int insertPosition) {
		int temp = 0;
		temp = ladderArray[insertPosition];
		ladderArray[insertPosition] = ladderArray[insertPosition + 1];
		ladderArray[insertPosition + 1] = temp;
	}

	//각 출발지점별 도착지점의 번호를 콘솔에 출력한다
	void displayLadder() {
		System.out.println();
		for (int i = 0; i < columns; i++) {
			System.out.println("> " + (i + 1));
			System.out.println(ladderArray[i] + 1);
			System.out.println();
		}
	}
}

public class Ladder1 {

	public static void main(String[] args) {

		ReadStdinInt readStdinInt = new ReadStdinInt();
		// 사다리 칼럼의 개수
		System.out.print("사다리 기둥의 개수를 입력하세요: ");
		int columns = readStdinInt.getInt();
		// 사다리 바의 개수
		System.out.print("사다리에 삽입할 바의 개수를 입력하세요: ");
		int bars = readStdinInt.getInt();

		// 입력한 개수의 칼럼을 가진 사다리 생성
		GenerateLadder ld = new GenerateLadder(columns);

		// 칼럼의 개수로 입력한 값이 1일때는 바를 삽입하지 않는다
		if (columns > 1) {
			// 입력한 개수만큼의 바를 사다리에 삽입(진짜로 삽입하는 건 아니고 삽입한 것과 같은 효과만 연출)
			ld.insertBar(bars);
		}

		// 완성된 사다리의 출발지점별 도착지점 출력
		ld.displayLadder();

	}

}
