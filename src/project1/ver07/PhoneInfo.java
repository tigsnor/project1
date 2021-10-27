package project1.ver07;

import java.util.Objects;
import java.util.Scanner;


public class PhoneInfo {
	String name; //이름
	String phoneNumber; //전화번호


	//2개의 매개변수를 가진 생성자 오버로딩
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public void showPhoneInfo() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
	}

	public int hashCode()
	{
		int nameHashCode = name.hashCode();
		return nameHashCode;
	}
	public boolean equals(Object obj)
	{
		PhoneInfo ph = (PhoneInfo)obj;
		if(ph.name.equals(this.name))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}

