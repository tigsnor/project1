package project1.ver07;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager extends Exception{
	
	
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	Scanner scan = new Scanner(System.in);
	
	
	public void dataInput() { //데이터 입력
		
		int choice=0;
		
		System.out.println("데이터입력을 시작합니다.");
		SubMenuItem.showSubMenu();//메뉴출력
		
		String name, phoneNumber, major, companyName, grade;
		PhoneInfo store = null;//true false 확인용
		try {
			choice = scan.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("숫자를 입력.");
			choice = 0;
		}			
		catch(Exception e) 
		{
			System.out.println("오류발생");	
		}		
		
		scan.nextLine();
		if(choice==SubMenuItem.NORMAL) {	//일반 입력 후 추가
			System.out.print("이름:");name = scan.nextLine();
			System.out.print("전화번호:");phoneNumber = scan.nextLine();
			store=new PhoneInfo(name,phoneNumber);
			System.out.println("======입력완료=======");
		}

		else if(choice==SubMenuItem.SCHOOL) { //동창 입력 후 추가
			System.out.print("이름:");name = scan.nextLine();
			System.out.print("전화번호:");phoneNumber = scan.nextLine();
			System.out.print("전공:"); major = scan.nextLine();
			System.out.print("학년:"); grade = scan.nextLine();
			PhoneSchoolInfo storeSc=new PhoneSchoolInfo(name, phoneNumber, major, grade);
			store=storeSc;
			System.out.println("======입력완료=======");
			
		}
		else if(choice==SubMenuItem.COMPANY) { //직장인 입력 후 추가
			System.out.print("이름:");name = scan.nextLine();
			System.out.print("전화번호:");phoneNumber = scan.nextLine();
			System.out.print("회사:"); companyName = scan.nextLine();
			PhoneCompanyInfo storeCo=new PhoneCompanyInfo(name, phoneNumber, companyName);
			store=storeCo;
			System.out.println("======입력완료=======");
		}
		else System.out.println("잘못입력하셨습니다.");
		
					
			//덮어쓰기
		if(set.add(store) == false){
			System.out.println("덮어쓸까요? Y(y)/N(n)");
			
			String re = scan.nextLine();
		
			if(re.equals("Y")||re.equals("y"))
			{	
				Iterator itr = set.iterator();
				while(itr.hasNext()) {
					PhoneInfo saname = (PhoneInfo)itr.next();
					
					if(saname.name.equals(store.name))
					{
						set.remove(saname);
						set.add(store);
						System.out.println("====덮어쓰기 성공====");
					
					}
					else {
						System.out.println("====덮어쓰기 실패====");
					
					}
				}
			}
			else if (re.equals("N")||re.equals("n")) {
				System.out.println("====덮어쓰기를 취소합니다====");
			}
			else {
				System.out.println("잘못입력하셨습니다.");			
			}
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
}
