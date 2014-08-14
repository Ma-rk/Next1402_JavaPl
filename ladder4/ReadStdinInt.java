package ladder4;

import java.io.*;

public class ReadStdinInt {


	static int getInt() {
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
			System.err.println("0 이상의 정수만 입력하세요: ");
			val = getInt();// 입력한 값이 1 이상의 자연수가 아닐 경우 다시 입력하게 함
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
		return val;
	}


	static int getInt(int maxNum) {
		String line = null;
		int val = 0;
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(
					System.in));
			line = is.readLine();
			val = Integer.parseInt(line);// 정수 아닌 값 입력시 익셉션 발생
			if (val < 0 || val > maxNum) {// raise exception if val <=0 or val
											// > maxNum
				throw new NumberFormatException();
			}
		} catch (NumberFormatException ex) {
			System.err.println("0보다 크고 " + maxNum + " 이하인 정수만 입력하세요: ");
			val = getInt(maxNum);// 입력한 값이 범위를 벗어나면 다시 입력하게 함
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
		return val;
	}
	
	static Coordinate pickLeftPoint(int columns, int columnLength) {

		Coordinate barLeftPoint = null;
		int barLeftX = 0;
		int barLeftY = 0;

		System.out.println("삽입할 bar의 좌측 점의 x좌표를 입력하세요.");
		barLeftX = ReadStdinInt.getInt(columns - 1);

		System.out.println("삽입할 bar의 좌측 점의 y좌표를 입력하세요.");
		barLeftY = ReadStdinInt.getInt(columnLength);

		if (Ladder4.ladderAL.get(barLeftX - 1)[barLeftY - 1] != 0) {
			System.out.println("선택한 좌표에는 이미 값이 입력돼 있습니다. 다른 좌표를 선택해 주세요.");
		} else {
			barLeftPoint = new Coordinate(barLeftX, barLeftY);
		}
		return barLeftPoint;
	}

	static Coordinate pichRightPoint(int columns, int columnLength, int barLeftX) {

		Coordinate barRightPoint = null;
		int barRightX = barLeftX + 1;
		int barRightY = 0;

		System.out.println("삽입할 bar의 우측 점의 y좌표를 입력하세요.");
		barRightY = ReadStdinInt.getInt(columnLength);

		if (Ladder4.ladderAL.get(barRightX - 1)[barRightY - 1] != 0) {
			System.out.println("선택한 좌표에는 이미 값이 입력돼 있습니다. 다른 좌표를 선택해 주세요.");
		} else {
			barRightPoint = new Coordinate(barRightX, barRightY);
		}
		return barRightPoint;
	}
}
