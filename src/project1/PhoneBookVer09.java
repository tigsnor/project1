package project1;

import java.util.Scanner;

import project1.ver09.PhoneInfo;
import project1.ver09.PhoneBookManager;

public class PhoneBookVer09 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();

		Scanner scan = new Scanner(System.in);
		
		
		manager.connect();//처음 실행시 JDBC연결
		
		while(true) {
			manager.printMenu();
			
			
			int choice = scan.nextInt();
			switch(choice) 
			{
			case 1:
				manager.dataInput();
				break;
			case 2:
				manager.dataSerch();
				break;
			case 3:
				manager.dataDelete();
				break;
			case 4:
				System.out.println("프로그램을종료합니다.");
				manager.close();//프로그램을 종료할때 자원반납
				return;
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
