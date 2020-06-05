package kh.or.department.model.vo;

public class Department {
	private int deptNo;
	private String deptName;
	private String deptImage;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptImage() {
		return deptImage;
	}
	public void setDeptImage(String deptImage) {
		this.deptImage = deptImage;
	}
	public Department(int deptNo, String deptName, String deptImage) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.deptImage = deptImage;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
