package project1.ver08;

public interface MenuItem {
	int DATAINPUT = 1, DATASEARCH =2, DATADELETE = 3, DATAALLSHOW=4, SAVEOPTION=5, END=6;
	public static void printMenu() {
		System.out.println("=====메뉴선택=====");
		System.out.print("1. 데이터 입력 ");
		System.out.print("2. 데이터 검색 ");
		System.out.println("3. 데이터 삭제");
		System.out.print("4. 주소록 출력 ");
		System.out.print("5. 저장옵션 ");
		System.out.println("6. 프로그램 종료");

	}
}
