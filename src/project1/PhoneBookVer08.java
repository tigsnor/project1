package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver02.PhoneInfo;
import project1.ver07.MenuItem;
import project1.ver07.MenuSelectException;
import project1.ver07.PhoneBookManager;

public class PhoneBookVer08 {

	public static void main(String[] args) {
		//기능을 담당하는 핸들러 클래스의 객체 생성re.equals("y")||re.equals("Y")
		//초기값으로 100명의 정보를 저장할수 있는 Friend타입의 객체배열 생성
		//무한루프 조건으로 특정 입력에만 종료할수 있는 구조를 만들어준다.
		PhoneBookManager manager = new PhoneBookManager();
		while(true) 
		{			
			try 
			{	
				Scanner scan = new Scanner(System.in);
				MenuItem.printMenu();
				int select = scan.nextInt();
				scan.nextLine();
				switch(select) 
				{
				case MenuItem.DATAINPUT:
					manager.dataInput();
					break;//break문을 만나면 switch문을 탈출한다. 
				case MenuItem.DATASEARCH:
					manager.dataSearch();
					break;
				case MenuItem.DATADELETE:
					//System.out.println("간략정보출력");
					manager.dataDelete();
					break;
				case MenuItem.DATAALLSHOW:
					//System.out.println("전체정보출력");
					manager.dataAllShow();
					break;
				case 5:
					System.out.println("프로그램을종료합니다.");
					return;//main메서드의 종료이므로 프로그램 자체의 종료로 이어진다.
				}
				
				if(select>5 || select<1) 
				{
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("숫자를 입력하시오");
			}
			catch(Exception e) 
			{
				System.out.println("오류발생");	
			}			
		}

	}
}
