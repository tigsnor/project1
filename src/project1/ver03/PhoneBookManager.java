package project1.ver03;

import java.util.Scanner;



public class PhoneBookManager {
	
	private PhoneInfo[] inPhone;
	//실제 저장된 연락처 갯수
	private int numOfPhone; 
	
	
	
	public PhoneBookManager(int num) {
		//num의 크기의 객체배열 생성
 		inPhone = new PhoneInfo[num];
 		//최초 실행시 저장된 객체가 없으므로 0으로 초기화
		numOfPhone = 0;
	}

	Scanner scan = new Scanner(System.in);
	
	public static void printMenu() { //메뉴 출력
		System.out.println("선택하세요...");
		System.out.print("1. 데이터 입력 ");
		System.out.print("2. 데이터 검색 ");
		System.out.println("3. 데이터 삭제");
		System.out.print("4. 주소록 출력 ");
		System.out.println("5. 프로그램 종료");

	}
	
	public void dataInput() { //데이터 입력
		String name, phoneNumber, birthday;
		//기본정보 입력(연락처의 공통사항)
		System.out.print("이름:");name = scan.nextLine();
		System.out.print("전화번호:");phoneNumber = scan.nextLine();
		System.out.print("생년월일:");birthday = scan.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phoneNumber, birthday);
		inPhone[numOfPhone++] = info;
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
	
	public static void main(String[] args)
	{		
		Scanner scan = new Scanner(System.in);
		
		//기능을 담당하는 핸들러 클래스의 객체 생성
		//초기값으로 100명의 정보를 저장할수 있는 Friend타입의 객체배열 생성
		PhoneBookManager manager = new PhoneBookManager(100);
		//무한루프 조건으로 특정 입력에만 종료할수 있는 구조를 만들어준다.
		while(true) {
			printMenu();
			
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				manager.dataInput();
				break;//break문을 만나면 switch문을 탈출한다. 
			case 2:
				manager.dataSerch();
				break;
			case 3:
				//System.out.println("간략정보출력");
				manager.dataDelete();
				break;
			case 4:
				//System.out.println("전체정보출력");
				manager.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을종료합니다.");
				return;//main메서드의 종료이므로 프로그램 자체의 종료로 이어진다.
			}////switch 끝
		}////while 끝
	}////main 끝


}
