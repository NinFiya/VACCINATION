public class Citizen {
	
	private String citizenName;
	private String ICNum;
	private String state;
	private int age;
	private String category;
	private String FirstDose; //set value to null 
	private String SecondDose; //set value to null
	private String Certificate; //set value to null
	
	public Citizen(String citizenName, String ICNum, String state, int age, String category, String FirstDose, String SecondDose, String Certificate)
	{
		this.citizenName = citizenName;
		this.ICNum = ICNum;
		this.state = state;
		this.age = age;
		this.category = category;
		this.FirstDose = FirstDose;
		this.SecondDose = SecondDose;
		this.Certificate = Certificate;
	}
	
	public void setcitizenlist(String citizenName,String ICNum,String state,int age,String category,String FirstDose,String SecondDose,String Certificate)
	{
		this.citizenName = citizenName;
		this.ICNum = ICNum;
		this.state = state;
		this.age = age;
		this.category = category;
		this.FirstDose = FirstDose;
		this.SecondDose = SecondDose;
		this.Certificate = Certificate;
	}
	
	public String getCitizenName(String citizenName)
	{
		return citizenName;
	}
	public void setCitizenName(String citizenName)
	{
		this.citizenName = citizenName;
	}
	public String getICNum(String ICNum)
	{
		return ICNum;
	}
	public void setICNum(String ICNum)
	{
		this.ICNum = ICNum;
	}
	public String getState(String state)
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return age;
	}
	public String getCategory(String Category)
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public String getFirstDose(String FirstDose)
	{
		return FirstDose;
	}
	public void setFirstDose(String FirstDose)
	{
		this.FirstDose = FirstDose;
	}
	public String getSecondDose(String SecondDose)
	{
		return SecondDose;
	}
	public void setSecondDose(String SecondDose)
	{
		this.SecondDose = SecondDose;
	}
	public String getCertificate(String Certifacate)
	{
		return Certificate;
	}
	public void setCertificate(String Certificate)
	{
		this.Certificate = Certificate;
	}
	
	//printer
	public String toString()
	{
		return String.format("\n| %30s | %15s | %30s | %5s | %10s | %10s | %10s | %10s |",citizenName,ICNum,state,age,category,FirstDose,SecondDose,Certificate);
	}
}
