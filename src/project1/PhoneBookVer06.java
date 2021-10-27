package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver02.PhoneInfo;
import project1.ver05.PhoneBookManager;
import project1.ver06.MenuSelectException;
import project1.ver07.MenuItem;

public class PhoneBookVer06 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager(100);
		while(true) {
			manager.printMenu();
			try 
			{	
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			if(choice>5 || choice<1) {
				MenuSelectException ex = new MenuSelectException();
				throw ex;
			}
			
			switch(choice) 
				{
				case MenuItem.DATAINPUT:
					manager.dataInput();
					break;//break문을 만나면 switch문을 탈출한다. 
				case MenuItem.DATASEARCH:
					manager.dataSerch();
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
			}
			catch(InputMismatchException e) {
					System.out.println("숫자를 입력하시오.");
			}			
			catch(Exception e) {
				
			}
		}////while끝
	}
}
