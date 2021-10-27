package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택:");
			int menu = scan.nextInt();
			scan.nextLine();
			System.out.println();
			
			if(menu==1) {
				
			System.out.print("이름:");
			String name = scan.nextLine();
			
			System.out.print("전화번호:");
			String phoneNumber = scan.nextLine();
			
			System.out.print("생년월일:");
			String birthday = scan.nextLine();
			System.out.println();
			
			PhoneInfo pi1 = new PhoneInfo (name, phoneNumber, birthday);
			pi1.showPhoneInfo();
			}
			else if(menu==2) {
			System.out.println("프로그램을 종료합니다.");
			break;
			}
			else 
			System.out.println("바른 번호를 입력하시오");
		}
	}
}
