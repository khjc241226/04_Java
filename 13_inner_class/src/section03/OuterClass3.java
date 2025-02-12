package section03;

public class OuterClass3 {
	// 외부 클래스의 인스턴스 변수
	private String instanceMessage = "Hello";
	
	
	public void outerDisplay() {
		// 외부 클래스의 멤버 메서드에 선언된 지역 변수
		String localMessage = " World!!";

		/* 지역 내부 클래스 정의 */
		
		// (default) 접근 제어자
		// - 같은 패키지 내에서 접근 가능
		// - 접근 제어자를 작성하지 않은 상태 == (default)
		class LocalInnerClass{
			
			public void innerDisplay() {
				// 외부 클래스의 멤버 변수, 지역 변수 접근 가능!
				System.out.println(instanceMessage + localMessage);
			}
		}
		
		/* 지역 내부 클래스를 이용해 객체 생성 */
		LocalInnerClass inner = new LocalInnerClass();
		inner.innerDisplay();
	}
	
	// 다른 메서드에서는 지역 내부 클래스 호출 불가
	public void method() {
		// 오류 발생!
//		LocalInnerClass inner = new LocalInnerClass();
	}
	
	
	
	
}