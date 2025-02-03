package section01;

/**
 * 부모 역할 클래스
 */
public class Parent {
	
	private String lastName = "김";    // 성
	
	/* private : 현재 클래스/객체만 접근 가능 */ 
	/* protected : 같은 패키지 내 + 상속 관계 직접 접근 가능*/
  protected String firstName = "철수"; // 이름
  
	private String address = "서울시 중구 남대문로 120"; 
	private int money = 10000;
	
	// 기본 생성자
	public Parent() {
		System.out.println("*** Parent 객체 생성됨 ***");
	}

	// getter/setter
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	// 부모만의 기능
	public String introduce() {
		return "저는 Parent 입니다";
	}
	
	
	public String toString() {
		return 
				String.format(
						"@@@@@성 : %s / 이름 : %s / 주소 : %s / 돈 : %d", 
						lastName, firstName, address, money);
	}
	
	
	
	
	
	
	
	
}
