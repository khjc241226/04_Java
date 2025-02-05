package section01.service;

import section01.dto.Child;
import section01.dto.Parent;

public class PolymorphismService {
	
	/* [매개 변수의 다형성]
	 * 
	 * - 매개 변수의 타입을 "부모 타입"으로 설정하여
	 *  모든 '자식 객체 참조 주소'를 전달 받을 수 있도록 함
	 *  (다형성 - 업캐스팅 적용)
	 * 
	 * * 매개 변수(Parameter) : 
	 *   메서드 호출 시 전달된 값을 저장하는 변수
	 */
	
	/* * 참조변수 instanceof 클래스명
	 * 
	 * - "참조변수"가 참조하는 객체가
	 *   "클래스명"로 만들어진 객체가 맞을 경우 true, 아님 false
	 *   
	 * - 상속 관계도 파악이 가능
	 *   (자식 객체 내부의 부모 객체도 인식)
	 */
	
	
	/** 객체의 타입, 필드 정보를 출력하는 메서드
	 * 
	 * @param obj : Object 또는 Object를 상속 받은 객체 참조 변수
	 * (Object는 모든 클래스/객체의 최상위 부모)
	 */
	public void printObject(Object obj) {
		
		// obj에 전달 받을 수 있는 타입 : Object, Parent, Child
		
		String result = null;
		
		/* 자식 타입 부터 검사! */
		if(obj instanceof Child) {
			// obj가 참조하는 객체의 타입이
			// Child 또는 Child를 상속 받은 자식 타입인 경우
			
			Child c = (Child)obj; // Child 다운 캐스팅
			result = "[Child Type]\n";
			result += c.getLastName() + " / " 
			        + c.getMoney() + " / "
			        + c.getCar();
		}
		
		else if(obj instanceof Parent) {
			// obj가 참조하는 객체의 타입이
			// Parent 또는 Parent를 상속 받은 자식 타입인 경우
			
			Parent p = (Parent)obj; // Parent로 다운 캐스팅
			result = "[Parent Type]\n";
			result += p.getLastName() + " / " + p.getMoney();
		}
		
//		else if(obj instanceof Object) { 
		else {
			// obj가 참조하는 객체의 타입이
			// Object 또는 Object를 상속 받은 자식 타입인 경우
			// -> 모든 클래스/객체는 Object의 자식이기 때문에
			//    else에 모두 걸림
			result = "[Object Type] 필드 없음";
		} 
		

		
		System.out.println("-------------------------------------");
		System.out.println(result);
		System.out.println("-------------------------------------");
	}
	
	
	
	
	// 매개 변수의 다형성 확인
	public void test1() {
		
		Object obj    = new Object();
		Parent parent = new Parent("김", 500);
		Child  child  = new Child("이", 6000, "소나타");
		
		printObject(obj);    // 같은 Object 타입 전달 가능
		printObject(parent); // Object의 자식 타입인 Parent 전달 가능
		printObject(child);  // Object의 후손 타입인 Child 전달 가능
	}
	
	
	
	/* [반환형의 다형성]
	 * - 메서드의 반환형을 부모 타입을 설정하여
	 *   return되는 자식 객체의 주소를 참조할 수 있게 함
	 *   
	 * - 다형성의 업캐스팅 적용
	 */
	
	/**
	 * 전달 받은 num 값에 따라 알맞은 객체를 생성/반환하는 메서드
	 * @param num : 1 - Child, 2 - Parent , 나머지 - Object
	 * @return 생성된 객체 참조 주소 반환
	 */
	public Object getInstance(int num) {
		
		// if, for, while의
		// {} 내부 코드가 한 줄인 경우 {} 생략 가능
		if(num == 1) return new Child();
		
		if(num == 2) return new Parent();
		
		return new Object();
	}
	
	
	// 반환형의 다형성 확인
	public void test2() {
		
		// getInstance()의 반환형의 Object 
		
		// o1, o2는 업캐스팅 상태
		Object o1 = getInstance(1); // Child 객체 반환
		Object o2 = getInstance(2); // Parent 객체 반환
		Object o3 = getInstance(3); // Object 객체 반환
		
		// 매개변수의 다형성 + 반환형의 다형성
		printObject(o1);
		printObject(o2);
		printObject(o3);
		
		
	}
	
	
	
	
	
	/* [바인딩(Binding)]
	 * - 메서드 호출부와 실제 실행할 메서드 코드를 연결하는 것
	 * 
	 * [정적 바인딩]
	 * - 프로그램 실행 전
	 *  컴파일 단계에서 메서드와 메서드 호출부를 연결
	 * 
	 * [동적 바인딩]
	 * - 프로그램 실행 중(Runtime)
	 *  정적 바인딩된 메서드를
	 *  실제 객체 타입을 기준으로 연결
	 * 
	 * - 왜 사용?
	 *  1) 다운 캐스팅의 번거로움을 없앰
	 *  2) 재정의된 메서드(조금 더 효율적 또는 알맞는 기능) 수행
	 * 
	 * * 상속, 오버라이딩, 업캐스팅(+메모리 구조)
	 */
	
	// 바인딩 확인
	public void test3() {
		
		Parent p1 = new Parent("김", 10); // 부모 = 부모
		Child c1  = new Child("최", 20, "캐스퍼"); // 자식 = 자식
		
		Parent p2 = new Child("박", 30, "포터"); // 부모 = 자식(업캐스팅)
		
		
		// 정적 바인딩 : 프로그램 실행 X, 컴파일 단계에서 연결
		
		// (정적)section01.dto.Parent.toString()
		// (동적)section01.dto.Parent.toString()
		System.out.println("p1.toString() : " + p1.toString());
		
		// (정적)section01.dto.Child.toString()
		// (동적)section01.dto.Child.toString()
		System.out.println("c1.toString() : " + c1.toString());
		
		// (정적)section01.dto.Parent.toString()
		// (동적)section01.dto.Child.toString()  <- 바인딩이 변경됨
		System.out.println("p2.toString() : " + p2.toString());
	}
	
	
	
	/* [객체 배열의 다형성]
	 * - 부모 타입의 참조 변수를 묶음으로 다루어서
	 *  배열 각 요소에 업캐스팅 적용
	 * 
	 * * 객체 배열 : 객체 참조 변수의 묶음 
	 */
	
	// 객체 배열의 다형성 확인
	public void test4() {
		
		// Object 객체 참조 변수 5칸 짜리 배열 생성해서
		// Object[] 참조 변수 arr에 배열 주소 대입
		Object[] arr = new Object[5];
		
		
		for(int i=0 ; i < arr.length ; i++) {
			arr[i] =  getInstance(i % 3 + 1);
			// i     : 0 1 2 3 4
			// i%3+1 : 1 2 3 1 2

			// 0,3번 : Child
			// 1,4번 : Parent
			// 2     : Object
		}
		
		System.out.println("---------------------------------");
		
		
		// 객체 배열의 다형성 + 동적 바인딩
		
		// * 동적 바인딩
		// - 실행 중 메서드 호출부 연결이 실제 참조하는 객체의
		//   오버라이딩된 메서드로 연결
		//   (오버라이딩된 메서드가 우선권을 갖는다)
		
		for(Object obj : arr) { // 향상된 for문
			// 실제 참조 중인 객체의 toString()이 호출됨 
			System.out.println(obj.toString());
		}
		
		System.out.println("--------------------------------");
		System.out.println("[동적 바인딩이 없었더라면...]");
		
		for(Object obj : arr) { // 향상된 for문
			
			// 참조 객체 타입 검사 후 다운 캐스팅
			if(obj instanceof Child) {
				System.out.println( ((Child)obj).toString() );
			}
			
			else if(obj instanceof Parent) {
				System.out.println( ((Parent)obj).toString() );
			}
			
			else {
				System.out.println( obj.toString() );
			}
			
		}
		
		
		/* debug 모드
		 * - 이클립스 등 IDE에서 제공하는 기능
		 * - 코드 수행 중 지정된 지점(breakpoint)에서 
		 *   실행을 멈추고
		 *   해당 시점에 존재하는 변수/필드 값을 확인하는 모드
		 */
	}
	
	
	// 다운 캐스팅 시 주의 사항
	// - 강제 형변환이 적용되는 참조 변수가
	//   형변환 하려는 타입의 객체를 참조하고 있는지 확인 필요
	//  -> instanceof 사용
	public void test5() {
		
		// 업 캐스팅
		Parent p = new Child("김", 200, "소나타");
		test6(p);
	}
	
	// 전달 받은 객체를 String 타입으로 다운 캐스팅(강제 형변환)
	public void test6(Object obj) {
		
		/* ClassCastException 발생 
		 * - 참조 변수의 강제 형변환(다운 캐스팅) 시
		 *   참조하는 객체가 
		 *   변환하려는 타입이 아니거나 상속 관계도 아니면
		 *   형변환 불가(ClassCastException) 발생
		 * */
		
		// 참조하는 객체가 String 타입인 경우에만 형변환
		if(obj instanceof String) {
			String p = (String)obj; 
			System.out.println(p);
			
		}else {
			// String이 아니면 객체를 만들 때 사용한 클래스명 출력
			System.out.println(obj.getClass().getName());
		}
		
	}
	
	
	
	

}
