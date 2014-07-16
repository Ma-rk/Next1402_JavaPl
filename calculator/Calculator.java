package calculator;

class Calculation {
	String inputString = "";

	public Calculation(String calcInput) {
		this.inputString = calcInput;
	}

	/*
	 * 스플릿 메소드. input: 문자 output: 컴마와(,) 개행문자(\n)를 구분자로 이용하여
	 * 문자열에서 int를 추출해낸 int
	 * 배열 intput이 빈 문자열이면 null을 리턴함
	 */
	int[] splition() {
		int calcNumbers[] = null;
		if (!inputString.isEmpty()) {
			String[] calcStrings = inputString.split(",|\n");
			calcNumbers = new int[calcStrings.length];
			for (int i = 0; i < calcStrings.length; i++) {
				calcNumbers[i] = Integer.parseInt(calcStrings[i]);
			}
		}
		return calcNumbers;
	}

	/*
	 * 더하기 메소드. input: int 배열 output: input의 모든 숫자를 더한 int
	 */
	int executeAdd(int[] calcNumbers) {
		int addResult = 0;
		try {
			for (int i = 0; i < calcNumbers.length; i++) {
				addResult = addResult + calcNumbers[i];
			}
		} catch (NullPointerException e) {
			System.out.println(e);
			addResult = 0;
		}
		return addResult;
	}

	/*
	 * 곱하기 메소드. input: int 배열 output: input의 모든 숫자를 곱한 int
	 */
	int executeMultiply(int[] calcNumbers) {
		int addResult = 1;
		try {
			for (int i = 0; i < calcNumbers.length; i++) {
				addResult = addResult * calcNumbers[i];
			}
		} catch (NullPointerException e) {
			System.out.println(e);
			addResult = 0;
		}
		return addResult;
	}
}

public class Calculator {

	public static void main(String[] args) {

		// String inputString = "7,23,5\n6";
		String inputString = "";

		Calculation calc = new Calculation(inputString);
		int[] splitionResult = calc.splition();

		// 더하기 실행
		int addResult = calc.executeAdd(splitionResult);
		System.out.println("합: " + addResult);

		// 곱하기 실행
		int multiplyResult = calc.executeMultiply(splitionResult);
		System.out.println("곱: " + multiplyResult);
	}
}
