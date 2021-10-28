package project1.ver08;

import java.io.FileWriter;
import java.io.PrintWriter;

import project1.ver07.PhoneInfo;

public class AutoSave extends Thread{
	
	PhoneBookManager pn;
	
	public AutoSave(PhoneBookManager pn) {
		this.pn = pn;
	}
	
	public void run(){
		
		try {
			while(true) 
			{
				pn.savePhoneInfo();
				sleep(5000);
				System.out.println("자동저장성공");
			}
		}
		catch (InterruptedException e) {
			System.out.println("저장오류발생");
			e.printStackTrace();
		}
		catch (Exception e) {}
	}
}