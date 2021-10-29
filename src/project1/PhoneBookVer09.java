package project1;

import java.util.Scanner;

import project1.ver09.PhoneInfo;
import project1.ver09.PhoneBookManager;

public class PhoneBookVer09 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();

		Scanner scan = new Scanner(System.in);
		
		//기능을 담당하는 핸들러 클래스의 객체 생성
		//초기값으로 100명의 정보를 저장할수 있는 Friend타입의 객체배열 생성
		//무한루프 조건으로 특정 입력에만 종료할수 있는 구조를 만들어준다.
		manager.connect();
		while(true) {
			manager.printMenu();
			
			
			int choice = scan.nextInt();
			switch(choice) 
			{
			case 1:
				manager.dataInput();
				break;//break문을 만나면 switch문을 탈출한다. 
			case 2:
				manager.dataSerch();
				break;
			case 3:
				manager.dataDelete();
				break;
			case 4:
				System.out.println("프로그램을종료합니다.");
				manager.close();//jdbc자원반납
				return;//main메서드의 종료이므로 프로그램 자체의 종료로 이어진다.
			}
		}////while 끝
	}
}
//
//입력 : dataInput()
//PreparedStatement 클래스 이용
//검색 : dataSearch()
//Statement 클래스 이용
//삭제 : dataDelete()
//PreparedStatement 클래스 이용
