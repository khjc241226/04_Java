package section01.dto;

/**
 * 부모 역할 클래스
 * (Object 상속)
 */
public class Parent extends Object {
	
	// 필드 == 멤버 변수
	private String lastName = "제갈";
	private int money = 10000;
	
	// 기본 생성자
	public Parent() {
		super(); // 부모 생성자 호출(미작성시 컴파일러가 추가)
		// -> Object()
	}

	// 매개 변수가 있는 생성자
	// [자동 완성 단축키] alt + shift + s -> o
	public Parent(String lastName, int money) {
		super();
		this.lastName = lastName;
		this.money = money;
	}

	// getter/setter 
	//[자동 완성 단축키] alt + shift + s -> r
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


	/* Object.toString() 오버라이딩 */
	
	// [오버라이딩 자동 완성 방법 1]
	// alt + shift + s -> Override/implement Methods... 클릭
	
	// [오버라이딩 자동 완성 방법 2]
	// 오버라이딩 하려는 메서드 이름 작성 후 ctrl + space 자동완성
	
	// [오버라이딩 자동 완성 방법 3 - toString() 만 가능]
	// alt + shift + s -> s -> 엔터
	@Override
	public String toString() {
		return "Parent [lastName=" + lastName + ", money=" + money + "]";
	}
	
	
	
	
}
