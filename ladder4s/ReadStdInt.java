/**
 * 
 */
package ladder4s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadStdInt {

	static int getNonNegativeInt() {
		String line = null;
		int val = 0;
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			line = is.readLine();
			val = Integer.parseInt(line);// 정수 아닌 값 입력시 익셉션 발생
			if (val <= 0) {// 0 이하의 값일때 익셉션 발생
				throw new NumberFormatException();
			}
		} catch (NumberFormatException ex) {
			System.err.println("0 이상의 정수만 입력하세요: ");
			val = getNonNegativeInt();// 입력한 값이 1 이상의 자연수가 아닐 경우 다시 입력하게 함
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
		return val;
	}

	static int getNonNegativeInt(int max) {
		int val = getNonNegativeInt();
		if (val > max) {
			System.out.println(max + "0 이하의 정수로 다시 입력하세요: ");
			val = getNonNegativeInt();
		}
		return val;
	}
}