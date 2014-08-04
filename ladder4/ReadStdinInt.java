package ladder4;

import java.io.*;

/**
 * @FileName: ReadStdinInt.java
 * @Project : ladder4
 * @Date : 2014. 7. 30.
 * @author : markk
 * @history :
 * @desc :
 */
public class ReadStdinInt {

	/*
	 * get int for num of column, num of bar ( num > 0 )
	 */
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

	/*
	 * get int for current player ( num of column >= num > 0 )
	 */
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
}
