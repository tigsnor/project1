package project1.jdbc;

import java.util.Scanner;


public class delephone extends pConnectjdbc{
	public delephone() {
		super("study", "1234");
	}
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.수정, 2.삭제");
			System.out.print("메뉴를 선택하세요");
			try {
				int menu = scanner.nextInt();
				if(menu==1) {
					String sql = "UPDATE phonebook_tb "
							+ " SET pnum=? , pbirth=? ";
					String searchStr = scanValue("검색할이름");
					if(searchStr!=null) {
						sql = sql + " WHERE pname "
								+ " = '%"+ searchStr +"%' ";
					}
				
					psmt = con.prepareStatement(sql);	
					
					
					psmt.setString(1, scanValue("전화번호"));
					psmt.setString(2, scanValue("생년월일"));
					int affected = psmt.executeUpdate();
					System.out.println(affected +"행이 수정 되었습니다.");
				}
				else if(menu==2) {
					String sql = "DELETE FROM phonebook_tb WHERE pname=?";
					psmt = con.prepareStatement(sql);			
					psmt.setString(1, scanValue("이름")); 
					int affected = psmt.executeUpdate();
					System.out.println(affected +"행이 삭제 되었습니다.");
				}
				scanner.nextLine();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("1.계속, 2.종료");
			System.out.print("계속하시겠습니까?");
			String retry = scanner.nextLine();
			if(retry.equalsIgnoreCase("2"))
				break;
		}
		System.out.println("종료되었습니다.");
	}
	
	public static void main(String[] args) {
		new delephone().execute();
	}

}
