package ladder4;

class GenerateLadder {
	int columns;
	int columnLength;

	GenerateLadder(int columns, int columnLength) {
		this.columns = columns;
		this.columnLength = columnLength;
		generateColumns();
	}

	void generateColumns() {
		for (int i = 0; i < columns; i++) {
			Ladder4.ladderAL.add(new int[columnLength]);
		}
	}

	void insertBars() {

		System.out.println("선택한 위치에 bar를 삽입합니다.");
		System.out.println("지정한 칼럼과 그 다음 칼럼의 사이에 삽입됩니다. 맨 마지막 칼럼은 선택할 수 없습니다.");
		boolean insertingBar = true;
		while (insertingBar) {

			Coordinate barLeftPoint = null;
			Coordinate barRightPoint = null;

			while (barLeftPoint == null) {
				barLeftPoint = ReadStdinInt.pickLeftPoint(columns, columnLength);
			}

			while (barRightPoint == null) {
				barRightPoint = ReadStdinInt.pichRightPoint(columns, columnLength, barLeftPoint.getX());
			}

			Ladder4.ladderAL.get(barLeftPoint.getX()-1)[barLeftPoint.getY()-1] = barRightPoint.getY();
			Ladder4.ladderAL.get(barRightPoint.getX()-1)[barRightPoint.getY()-1] = -barLeftPoint.getY();

			System.out.println("다음과 같은 위치에 bar를 입력했습니다.");
			displayCurrentBars();

			System.out.println("bar를 더 입력하시겠습니까? (1: 계속 입력, 2: 중단)");
			if (ReadStdinInt.getInt() != 1) {
				break;
			}
		}
	}

//	private Coordinate pickLeftPoint() {
//
//		Coordinate barLeftPoint = null;
//		int barLeftX = 0;
//		int barLeftY = 0;
//
//		System.out.println("삽입할 bar의 좌측 점의 x좌표를 입력하세요.");
//		barLeftX = ReadStdinInt.getInt(columns - 1);
//
//		System.out.println("삽입할 bar의 좌측 점의 y좌표를 입력하세요.");
//		barLeftY = ReadStdinInt.getInt(columnLength);
//
//		if (Ladder4.ladderAL.get(barLeftX - 1)[barLeftY - 1] != 0) {
//			System.out.println("선택한 좌표에는 이미 값이 입력돼 있습니다. 다른 좌표를 선택해 주세요.");
//		} else {
//			barLeftPoint = new Coordinate(barLeftX, barLeftY);
//		}
//		return barLeftPoint;
//	}

//	private Coordinate pichRightPoint(int barLeftX) {
//
//		Coordinate barRightPoint = null;
//		int barRightX = barLeftX + 1;
//		int barRightY = 0;
//
//		System.out.println("삽입할 bar의 우측 점의 y좌표를 입력하세요.");
//		barRightY = ReadStdinInt.getInt(columnLength);
//
//		if (Ladder4.ladderAL.get(barRightX - 1)[barRightY - 1] != 0) {
//			System.out.println("선택한 좌표에는 이미 값이 입력돼 있습니다. 다른 좌표를 선택해 주세요.");
//		} else {
//			barRightPoint = new Coordinate(barRightX, barRightY);
//		}
//		return barRightPoint;
//	}

	void displayCurrentBars() {
		for (int y = 0; y < columnLength; y++) {
			for (int x = 0; x < columns; x++) {
				System.out.print(Ladder4.ladderAL.get(x)[y]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("======================================================");
	}
}