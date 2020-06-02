package kr.or.iei.point;

public class Gold extends Grade{
	//grade 변수, name 변수, point 변수 --> private 변수라서 가져올 수 없다. super를 이용해야함.
	//getter, setter 상속 완료
	public Gold() {

	}
	public Gold(String grade, String name, int point) {
		//매개변수 값을 대입했음
		super(grade,name,point); 
		// super는 첫줄에서만 호출이 가능
		//this.grade = grade;
		//this.name = name;
		//this.point = point;
	}
	@Override //오버라이딩? 부모의 메소드를 자식이 재정의해서 사용하는 것. (부모에 없는 메소드를 입력 시 오류로 알려줌)
	public double getBonus() { //같은 이름을 가진 메소드에 매개변수도 없어서 오버로딩이 안 되야하는데 ? --> 오버라이딩
		return 0.05*getPoint(); //getPoint라는 메소드를 가져옴.
	}
	

}
