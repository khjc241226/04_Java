package basic;


/* 현실에서의 객체 : 
 *    속성(data), 기능(method) 을 가지고있는 식별 가능한 것
 * 
 * 
 * 객체 지향 프로그래밍(OOP, Object Oriented Programming) 
 *  - "객체와 객체가 상호 작용을하면 사건이 발생한다" 개념을
 *    프로그램 만들 때 적용한 패러다임
 *    
 *    
 * 클래스(class == 설계도)
 * - 객체가 가지고있는 속성, 기능을 정의한 것
 * - 이를 통해 새로운 자료형을 만들 수 있기 때문에 
 *   "사용자 정의 자료형" 이라고도 한다
 * 
 * 
 * 자바에서 객체(Object)
 * - 클래스에 정의된 내용을 토대로
 *  new 연산에 의해 JVM Heap 메모리 영역에 생성된 것
 */

public class Car {

	// 필드(Filed) == 멤버 변수 - 객체의 속성
	String brand;
	String model;
	int year;
	
	
	// 메서드(Method) - 객체의 기능
	public void start() {
		System.out.println("시동을 켭니다.");
	}
	
	public void stop() {
		System.out.println("시동을 끕니다.");
	}
	
}



