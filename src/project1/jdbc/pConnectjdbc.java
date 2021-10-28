package project1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class pConnectjdbc implements connectjdbc {
	 
	public Connection con;
	public PreparedStatement psmt; //동적쿼리 실행을 위한 객체
	public Statement stmt; //정적쿼리 실행을 위한 객체
	public ResultSet rs;
	
	//기본(디폴트)생성자
	public pConnectjdbc() {
		System.out.println("pConnectjdbc 기본생성자 호출");
	}
	//인자생성자1 : 아이디, 패스워드를 인자로 받음
	public pConnectjdbc(String user, String pass) {
		System.out.println("pConnectjdbc 인자생성자 호출");
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	//인자생성자2 : 드라이버명까지 인자로 받음
	public pConnectjdbc(String driver, String user, String pass) {
		System.out.println("pConnectjdbc 인자생성자 호출");
		try {
			Class.forName(driver);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	//오라클에 연결
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	//오버라이딩의 목적으로 정의한 메서드. 쿼리실행은 각 클래스에서 기술함. 
	@Override
	public void execute() {
		//실행부없음 
	}
	//자원반납
	@Override
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		}
		catch(Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
	//사용자로부터 입력값을 받기 위한 메서드
	@Override
	public String scanValue(String title) {		
		Scanner scan = new Scanner(System.in);
		System.out.print(title +"을(를) 입력(exit->종료):");
		String inputStr = scan.nextLine();
		/*
		equalsIgnoreCase()
			: equals()와 동일하게 문자열이 같은지를 비교하는 메소드로
			대소문자를 구분없이 비교할 수 있다. 
		 */		
		if("EXIT".equalsIgnoreCase(inputStr)) {   
			System.out.println("프로그램을 종료합니다.");
			close(); 
			System.exit(0);//프로그램 자체를 즉시 종료시킴.
		}
		
		return inputStr; 
	}
}



