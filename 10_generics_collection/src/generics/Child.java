package generics;

public class Child extends Parent{

	private int number;
	
	// 기본 생성자
	public Child() {}
	
	// 매개변수가 있는 생성자
	public Child(int number) {
		this.number = number; 
	}
	
	@Override
	public String toString() {
		return super.toString() + " / number : " + number;
	}
	
}
