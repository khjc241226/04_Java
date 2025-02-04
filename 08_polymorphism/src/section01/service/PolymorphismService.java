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
	
	
	

}
