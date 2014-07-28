package ladder4;

import java.io.*;

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
			System.err.println("0 이상의 정수만 입력하세요: ");
			val = getInt();// 입력한 값이 1 이상의 자연수가 아닐 경우 다시 입력하게 함
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
		return val;
	}

	int getInt(int maxNum) {
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
			val = getInt();// 입력한 값이 범위를 벗어나면 다시 입력하게 함
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
		return val;
	}
}
