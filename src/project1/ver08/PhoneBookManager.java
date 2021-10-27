package project1.ver08;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;






public class PhoneBookManager{
	
	
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	Scanner scan = new Scanner(System.in);
	

	
	public void dataInput() { //데이터 입력
		PhoneInfo store = null;//true false 확인용
		String name, phoneNumber, major, companyName;
		int grade;
		//기본정보 입력(연락처의 공통사항)

		System.out.println("데이터입력을 시작합니다.");
		SubMenuItem.showSubMenu();
		try {
			
		
			int choice=scan.nextInt();
			scan.nextLine();
			//데이터 입력
			if(choice==SubMenuItem.NORMAL) {	//일반 입력 후 추가
				System.out.print("이름:");name = scan.nextLine();
				System.out.print("전화번호:");phoneNumber = scan.nextLine();
				store=new PhoneInfo(name,phoneNumber);
				System.out.println("입력완료!");
			}
			else if(choice==SubMenuItem.SCHOOL) { //동창 입력 후 추가
				System.out.print("이름:");name = scan.nextLine();
				System.out.print("전화번호:");phoneNumber = scan.nextLine();
				System.out.print("전공:"); major = scan.nextLine();
				System.out.print("학년:"); grade = scan.nextInt();
				PhoneSchoolInfo storeSc=new PhoneSchoolInfo(name, phoneNumber, major, grade);
				store=storeSc;
				System.out.println("입력완료!");
				
			}
			else if(choice==SubMenuItem.COMPANY) { //직장인 입력 후 추가
				System.out.print("이름:");name = scan.nextLine();
				System.out.print("전화번호:");phoneNumber = scan.nextLine();
				System.out.print("회사:"); companyName = scan.nextLine();
				PhoneCompanyInfo storeCo=new PhoneCompanyInfo(name, phoneNumber, companyName);
				store=storeCo;
				System.out.println("입력완료!");
			}	
			
			if(set.add(store) == false){
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				String re = scan.nextLine();
	
				if(re.equals("Y")||re.equals("y")) // 
				{	
					Iterator itr = set.iterator();
					while(itr.hasNext()) {
						PhoneInfo object = (PhoneInfo)itr.next();
						
						if(object.name.equals(store.name))
						{
							set.remove(object);
							set.add(store);
							System.out.println("덮어쓰기 성공!");
						}
						else if (re.equals("N")||re.equals("n")) {
							System.out.println("덮어쓰기를 취소합니다.");
						}
						else {
							System.out.println("잘못입력하셨습니다.");
						}
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("오류발생");			
		}
	}

	
	public void dataSearch() { //데이터 검색
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름:");
		String searchName = scan.nextLine();
		
		
		boolean isFind = false;//검색한 정보가 있는지 확인위한 변수
		Iterator<PhoneInfo> itr = set.iterator();//객체생성
		while(itr.hasNext()) {	
			PhoneInfo info = itr.next();			
			//검색할 이름과 이터레이터를 통해 반환되는 객체의 이름을 비교
			if(searchName.equals(info.name)) {
				info.showPhoneInfo();
				isFind = true;//정보를 찾았다면 변경
				return;
			}			
		}

		if(isFind==false) System.out.println("데이터 검색에 실패하였습니다.");
		
	}////end of searchInfo
	
	public void dataDelete() { //데이터 삭제
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름:");
		String deletename = scan.nextLine();
		
		boolean isFind = false;//검색한 정보가 있는지 확인위한 변수
		Iterator<PhoneInfo> itr = set.iterator();//객체생성
		while(itr.hasNext()) {	
			PhoneInfo info = itr.next();			
			//검색할 이름과 이터레이터를 통해 반환되는 객체의 이름을 비교
			if(deletename.equals(info.name)) {
				set.remove(info);
				System.out.println("삭제성공");
				isFind = true;//정보를 찾았다면 변경
				return;
			}			
		}

		if(isFind==false) System.out.println("삭제실패");
		
	}////end of deleteInfo	
	
	public void dataAllShow() { //주소록전체출력
		for(PhoneInfo info : set) {
			info.showPhoneInfo();
			System.out.println("");
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	
	public static void main(String[] args) throws MenuSelectException
	{		

		
		//기능을 담당하는 핸들러 클래스의 객체 생성
		//초기값으로 100명의 정보를 저장할수 있는 Friend타입의 객체배열 생성
		//무한루프 조건으로 특정 입력에만 종료할수 있는 구조를 만들어준다.
		PhoneBookManager manager = new PhoneBookManager();
		while(true) {
			MenuItem.printMenu();
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
			}
			catch(InputMismatchException e) {
					System.out.println("숫자를 입력하시오.");
			}			
			catch(Exception e) {
				
			}
		}////while끝
	}
}
