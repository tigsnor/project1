package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.PhoneInfo;
import project1.ver08.AutoSave;
import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;

public class PhoneBookVer08 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
		manager.readBookManager();//처음에 정보를 가져오기위한 호출
		AutoSave au = new AutoSave(manager);
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
					break; 
				case MenuItem.DATASEARCH:
					manager.dataSearch();
					break;
				case MenuItem.DATADELETE:
					manager.dataDelete();
					break;
				case MenuItem.DATAALLSHOW:
					manager.dataAllShow();
					break;
					
				case MenuItem.SAVEOPTION:
					if(!au.isAlive()) { //쓰레드가 죽어있으면 새로 선언하기
						au = new AutoSave(manager);
						manager.autoSave(au);
					}
					else if(au.isAlive()){ //살아있으면 그냥 있는거
						manager.autoSave(au);
					}
					break;
				case MenuItem.END:
					System.out.println("프로그램을종료합니다.");
					manager.savePhoneInfo();
					
					return;
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
