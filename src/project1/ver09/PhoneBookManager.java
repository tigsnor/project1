package project1.ver09;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;



public class PhoneBookManager {
		
	Scanner scan = new Scanner(System.in);
	
	//jdbc객체
	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;
	
	public PhoneBookManager() {

	}
	
	/////////////////////////////////////////////////JDBC연결
	
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:xe", "kosmo", "1234");
			System.out.println("DB 연결 성공");
		}
		catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("알 수 없는 예외발생");
		}
	}
	
	////////////////////////////////////////////////JDBC연결
	
	public static void printMenu() { //메뉴 출력
		System.out.println("=======선택하세요(JDBC)=======");
		System.out.print("1. 데이터 입력 ");
		System.out.println("2. 데이터 검색 ");
		System.out.print("3. 데이터 삭제 ");
		System.out.println("4. 전체 데이터 출력");
		System.out.println("5. 프로그램 종료");
	}
	
	public void dataInput(){ ////데이터 입력
		String name, phoneNumber, birthday;
		//기본정보 입력(연락처의 공통사항)
		System.out.print("이름:");name = scan.nextLine();
		System.out.print("전화번호:");phoneNumber = scan.nextLine();
		System.out.print("생년월일:");birthday = scan.nextLine();
		
		//jdbc 입력
		try {
			//Statement 객체 생성을 위한 메서드 호출
			stmt = con.createStatement();
			//쿼리문(SQL) 작성
			String sql = "INSERT INTO phonebook_tb VALUES "
					+ " (?, ?, ?)";
			//쿼리문 실행 및 결과값 반환
			psmt = con.prepareStatement(sql);
			
			//3.인파라미터 설정
			psmt.setString(1, name);//이름
			psmt.setString(2, phoneNumber);//번호
			psmt.setString(3, birthday);//생년월일
			psmt.executeUpdate();//업데이트
			
			//insert문에 대한 결과 출력
			System.out.println("입력이 완료되었습니다.");
		}
		catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("제약조건에 위배됩니다.");
		}
		catch(SQLDataException e)
		{
			System.out.println("날짜를 잘못 입력하셨습니다.");
		}
		catch(SQLException e) {
			System.out.println("쿼리실행에 문제가 발생하였습니다.");
		}
	}
	
	public void dataSerch() { ////데이터 검색

		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름:");
		String searchName = scan.nextLine();
		
		//jdbc검색
		try {
			//Statement 객체 생성을 위한 메서드 호출
			stmt = con.createStatement();
			
			String sql = " SELECT pname, pnum, pbirth "
					+ " FROM phonebook_tb WHERE 1=1 ";
						
			if(searchName!=null) {
				sql = sql + " AND pname "
						+ " LIKE '%"+ searchName +"%' ";
			}

			//쿼리실행
			//1. 수행결과로 ResultSet 객체의 값을 반환합니다.
			//2. SELECT 구문을 수행할 때 사용되는 함수입니다
			rs = stmt.executeQuery(sql);
			
			System.out.println(" 이름     전화번호      생년월일");
			while(rs.next()){
				String pname = rs.getString("pname");
				String pnum = rs.getString("pnum");
				Date pbirth = rs.getDate("pbirth");
				
				System.out.printf("%-3s %8s %8s\n\n", 
						pname, pnum, pbirth);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}////end of searchInfo
	
	public void dataDelete() { ////데이터 삭제
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		
		////JDBC삭제
		try {
			String sql = "DELETE FROM phonebook_tb WHERE pname=?";
			psmt = con.prepareStatement(sql);			
			psmt.setString(1, deleteName); 
			psmt.executeUpdate();//업데이트
			
			System.out.println(deleteName +"행이 삭제 되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}////end of deleteInfo	
	
	public void dataShow() {
		System.out.println("전체정보출력");
		try {
			stmt = con.createStatement();
			
			String sql = " SELECT pname, pnum, pbirth "
					+ " FROM phonebook_tb ";
			//쿼리실행
			rs = stmt.executeQuery(sql);
			
			System.out.println(" 이름     전화번호      생년월일");
			while(rs.next()){
				String pname = rs.getString("pname");
				String pnum = rs.getString("pnum");
				Date pbirth = rs.getDate("pbirth");
				
				System.out.printf("%-3s %8s %8s\n", 
						pname, pnum, pbirth);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public void close() {//자원반납
		try {
			if(stmt!=null) stmt.close();  
			if(psmt!=null) psmt.close();
			if(con!=null) con.close(); 
			if(rs!=null) rs.close();
			System.out.println("DB자원반납완료\n");
		}
		catch(SQLException e) {
			System.out.println("자원반납시 오류가 발생하였습니다.");
		}
	}////end of close
	


}
