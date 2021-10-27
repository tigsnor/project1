package project1.ver06;

public interface MenuItem {
	int DATAINPUT = 1, DATASEARCH =2, DATADELETE = 3, DATAALLSHOW=4;
	public static void printMenu() {
		System.out.println("선택하세요...");
		System.out.print("1. 데이터 입력 ");
		System.out.print("2. 데이터 검색 ");
		System.out.println("3. 데이터 삭제");
		System.out.print("4. 주소록 출력 ");
		System.out.println("5. 프로그램 종료");

	}
}
