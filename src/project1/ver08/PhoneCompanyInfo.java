package project1.ver08;

class PhoneCompanyInfo extends PhoneInfo {
	String companyName;
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사:"+companyName);
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
