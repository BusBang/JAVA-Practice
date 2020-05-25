package company.model.vo;

public class Company {
	private int companyNo;
	private String companyName;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int companyNo, String companyName) {
		super();
		this.companyNo = companyNo;
		this.companyName = companyName;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	} 
	

}
