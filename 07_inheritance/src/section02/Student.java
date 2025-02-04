package section02;

import java.io.Serializable;

/**
 * Person 클래스를 상속 받은 Student 클래스
 */

// * Person이 final 클래스인 경우
// The type Student cannot subclass the final class Person
public class Student extends Person{

	private String schoolName; // 학교명
	
	/* super() 생성자
	 * - super : 극상의, 상위의, 위쪽의
	 * 
	 * - 현재 클래스의 상위 클래스(부모) 생성자를 호출하는 구문
	 * 
	 * - super() 생성자는 반드시
	 *   자식 생성자의 첫 번째 줄에 작성 되어야 한다!!!
	 *   (미작성 시 컴파일러 자동 추가)  
	 * 
	 * - 코드 길이 감소, 재사용성 증가
	 * 
	 */
	
	
	// 기본 생성자
	public Student() {
		super(); // 부모 기본 생성자
		System.out.println("[Student 기본 생성자로 생성됨]");
		
//		super(); // 부모 기본 생성자
		// Constructor call must be the first statement in a constructor
	}
	
	
	
	// 매개 변수가 있는 생성자
	// -> Student가 가지고 있는 
	// 모든 필드(schoolName, name, age) 초기화
	public Student(String name, int age, String schoolName) {
		// 부모의 매개 변수 있는 생성자를 호출 -> 코드 길이 감소
		super(name, age);
		// this.name = name; // 부모 필드 직접 접근 불가(private)
		// setName(name);
		// setAge(age);
		this.schoolName = schoolName;
		
		System.out.println("[Student 매개 변수가 있는 생성자로 생성됨]");
	}

	
	// getter/setter
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	
	/* super 참조 변수(부모 참조 변수)
	 * - 자식 내 부모 객체를 참조하는 변수
	 * - 부모의 필드/메서드에 접근하기 위해 사용
	 */
	
	// 연속으로 재정의
  // Object.toString() -> Person.toString() -> Student.toString()
	@Override 
	public String toString() {
		
		// super.toString() : 부모의 toString() 메서드 호출
		// -> name : 홍길동 / age : 20
		return super.toString() + " / schoolName : " + schoolName;
		
//		return String.format(
//				"name : %s / age : %d / schoolName : %s", 
//				getName(), getAge(), schoolName);
	}
	
	
	/* 오버라이딩 성립 조건
	 * [변경 불가]
	 * - 반환형
	 * - 메서드명
	 * - 매개변수(개수, 순서, 타입)
	 * 
	 * [변경 가능]
	 * - 접근 제어자(기존 -> 넓은 범위)
	 * - 예외 처리  (기존 -> 좁은 범위)
	 */
	
	/* Person.introduce() 메서드 오버라이딩(재정의) */
	
	// * Person.introduce()를 final 메서드로 변경한 경우
	// Cannot override the final method from Person
	
	@Override // 오버라이딩 명시 + 성립 조건 맞는지 검사 지시
	public String introduce(String alias) {
		return String.format(
				"[Student가 재정의] 내 이름은 %s, %s 이죠!", 
				super.getName(), alias);
	}
	
	
	
	
}
