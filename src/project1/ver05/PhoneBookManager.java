package project1.ver05;

import java.util.Scanner;

import project1.ver07.MenuItem;
import project1.ver07.SubMenuItem;





public class PhoneBookManager implements MenuItem, SubMenuItem{
	
	private PhoneInfo[] inPhone;
	//실제 저장된 연락처 갯수
	private int numOfPhone; 
	
	
	
	public PhoneBookManager(int num) {
		//num의 크기의 객체배열 생성
 		inPhone = new PhoneInfo[num];
 		//최초 실행시 저장된 객체가 없으므로 0으로 초기화
		numOfPhone = 0;
	}

	
	public void printMenu() { //메뉴 출력
		System.out.println("선택하세요...");
		System.out.print("1. 데이터 입력 ");
		System.out.print("2. 데이터 검색 ");
		System.out.println("3. 데이터 삭제");
		System.out.print("4. 주소록 출력 ");
		System.out.println("5. 프로그램 종료");

	}
	public void showSubMenu() {
		System.out.println("1.일반 2.동창 3.직장인");
	}
	
	public void dataInput() { //데이터 입력
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber, major, companyName;
		int grade;
		//기본정보 입력(연락처의 공통사항)

		System.out.println("데이터입력을 시작합니다.");
		showSubMenu();
		int choice=scan.nextInt();
		scan.nextLine();
		
		
		if(choice==SubMenuItem.NORMAL) {	//일반 입력 후 추가
			System.out.print("이름:");name = scan.nextLine();
			System.out.print("전화번호:");phoneNumber = scan.nextLine();
			PhoneInfo info = new PhoneInfo(name, phoneNumber);
			inPhone[numOfPhone++] = info;
		}
		else if(choice==SubMenuItem.SCHOOL) { //동창 입력 후 추가
			System.out.print("이름:");name = scan.nextLine();
			System.out.print("전화번호:");phoneNumber = scan.nextLine();
			System.out.print("전공:"); major = scan.nextLine();
			System.out.print("학년:"); grade = scan.nextInt();
			PhoneSchoolInfo info = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			inPhone[numOfPhone++] = info;
		}
		else if(choice==SubMenuItem.COMPANY) { //직장인 입력 후 추가
			System.out.print("이름:");name = scan.nextLine();
			System.out.print("전화번호:");phoneNumber = scan.nextLine();
			System.out.print("회사:"); companyName = scan.nextLine();
			PhoneCompanyInfo info = new PhoneCompanyInfo(name, phoneNumber, companyName);
			inPhone[numOfPhone++] = info;
		}
	}
	
	public void dataSerch() { //데이터 검색
		
		boolean isFind = false;//검색한 정보가 있는지 확인하기 위한 변수
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름:");
		String searchName = scan.nextLine();
		
		//객체배열에 저장된 정보의 갯수만큼 반복
		for(int i=0 ; i<numOfPhone ; i++) {
			/*
			검색을 위해 입력한 이름과 각 인덱스에 저장된 객체의 name변수의
			비교를 통한 문자열검색을 진행한다. 
			 */
			if(searchName.compareTo(inPhone[i].name)==0) {
				//일치하는 이름이 있으면 정보를 출력한다. 
				inPhone[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				isFind = true;//찾는 정보가 있다면 true로 변경
			}
		}		
		if(isFind==false)
			System.out.println("데이터가없습니다.");
	}////end of searchInfo
	
	public void dataDelete() { //데이터 삭제
		Scanner scan = new Scanner(System.in);
		System.out.print("데이터 삭제를 시작합니다..");
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		/*
		배열의 요소 중 삭제된 요소의 인덱스값을 저장할 용도의 변수. 
		요소를 삭제한 후 빈자리를 채워넣을때 사용할 것임. 
		배열은 인덱스이므로 초기값은 -1로 설정한다. 
		 */
		int deleteIndex = -1; 
		
		//저장된 데이터만큼 반복
		for(int i=0 ; i<numOfPhone ; i++) {
			//삭제할 이름이 있는지 검색
			if(deleteName.compareTo(inPhone[i].name)==0) {
				//객체를 삭제하기 위해 null값으로 변경한다. 
				inPhone[i] = inPhone[i+1];
				//삭제된 요소의 index를 저장한다. 
				deleteIndex = i;
				//전체카운트를 1 차감한다. 
				numOfPhone--;
				//하나의 객체를 삭제했다면 즉시 for문 탈출
				break;
			}
		}
		if(deleteIndex==-1) {
			//검색된 데이터가 없어 삭제되지 않았다면 -1을 유지한다.
			System.out.println("데이터 삭제가 안되었습니다.");
		}
		else {
			/*
			객체배열에서 검색된 요소를 삭제한 후 입력된 위치의 바로 뒤
			요소를 앞으로 하나씩 이동시킨다. 
			numOfPhone는 앞에서 1 차감되므로 마지막요소는 무시된다. 
			 */
			for(int i=deleteIndex ; i<numOfPhone ; i++) {
				//inPhone[i] = inPhone[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}////end of deleteInfo	
	
	public void dataAllShow() { //주소록전체출력
		for(int i=0 ; i<numOfPhone ; i++) {
			inPhone[i].showPhoneInfo();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	


}
