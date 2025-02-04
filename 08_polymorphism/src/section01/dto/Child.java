package section01.dto;

/**
 * Child 클래스
 * (Parent 상속)
 */
public class Child extends Parent{

	private String car;
	
	public Child() { 
		super();
	}
	
	// 매개 변수 있는 생성자
	public Child(String lastName, int money, String car) {
		super(lastName, money); // 부모의 매개변수 있는 생성자 호출
		this.car = car;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	@Override
	public String toString() {
		// Parent [lastName=제갈, money=10000] / Child [car=car변수]
		return super.toString() + " / Child [car=" + car + "]";
	}
	
	
	
}
