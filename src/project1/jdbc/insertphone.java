package project1.jdbc;

import java.sql.SQLException;


public class insertphone extends pConnectjdbc{
	
	public insertphone() {	
		super("study", "1234");
	}
	
	/*
	쇼핑몰 과제에서 "상품입력" 프로그램 작성
	 	: PreparedStatement 객체를 사용한다.
	 */
	@Override
	public void execute() {
		//1.쿼리문작성
		String sql = "INSERT INTO phonebook_tb VALUES "
				+ "(?, ?, ?)";
		
		try {
			//2.prepared 객체 생성
			psmt = con.prepareStatement(sql);
					
			//3.인파라미터 설정
			psmt.setString(1, scanValue("이름"));//이름
			psmt.setString(2, scanValue("전화번호"));//전화번호
			psmt.setString(3, scanValue("생년월일"));//생년월일
			
			//4.쿼리실행
			int row = psmt.executeUpdate();
			
			//5.결과확인
			System.out.println(row +"행이 입력되었습니다.");
		}
		catch(SQLException e) {
			System.out.println("상품입력시 오류발생됨");
			e.printStackTrace();
		}
		finally {
			//6.자원반납
			close();
		}
	}
	
	public static void main(String[] args) {		
		new insertphone().execute();
	}

}