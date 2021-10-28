package project1.ver08;

public class AutoSave extends Thread{
	
	PhoneBookManager pn;
	
	public AutoSave(PhoneBookManager pn) {
		this.pn = pn;
	}
	
	public void run(){
		
		try {
			while(true) {
				pn.savePhoneInfo();
				System.out.println("자동저장성공");
				sleep(5000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("저장오류발생");
			e.printStackTrace();
		}
	}
}