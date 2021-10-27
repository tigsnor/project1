package project1.ver08;


class PhoneSchoolInfo extends PhoneInfo{
	String major;
	int grade;
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ grade);
	}
	public int hashCode()
	{
		int nameHashCode = name.hashCode();
		return nameHashCode;
	}
	public boolean equals(Object obj)
	{
		PhoneInfo ph = (PhoneInfo)obj;
		if(ph.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
}
