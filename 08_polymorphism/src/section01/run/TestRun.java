package section01.run;

import section01.dto.Child;
import section01.dto.Parent;

/**
 * 다형성 확인 + 기초
 */
public class TestRun {
	public static void main(String[] args) {
		
		// 부모 참조 변수 = 부모 객체
		// -> 양쪽 다 Parent 타입 == 컴퓨터 값 처리 원칙 잘 지켜짐! 
		Parent p1 = new Parent(); 
		
		
		// p1이 호출 가능한 메서드 
		// - Parent의 메서드 + Object 한테 상속 받은 메서드
		System.out.println("p1.getLastName() : " + p1.getLastName());
		System.out.println("p1.hashCode() : " + p1.hashCode());
		
		System.out.println("---------------------------------------");
		
		// 자식 참조 변수 = 자식 객체
		Child c1 = new Child("신", 500, "붕붕이");
		
		// c1이 호출 가능한 메서드
		// - Child + Object, Parent에게 상속 받은 메서드
		System.out.println("c1.getCar() : "      + c1.getCar());
		System.out.println("c1.getLastName() : " + c1.getLastName());
		System.out.println("c1.hashCode() : "    + c1.hashCode());
		
		/* * 다형성(Polymorphism)
		 * - 하나의 객체가 다양한 객체 형태로 변하는 성질
		 *
		 *
		 * * 다형성 - 업 캐스팅(Up Casting)
		 * - 자식 객체의 형태를 부모 객체 형태로 변환
		 * 
		 * - '부모' 참조 변수 = new '자식' 객체;
		 * 	 -> 자식 객체가 부모 객체 형태로 변한 것 처럼 보임
		 * 
		 * 
		 * * 다형성 - 다운 캐스팅(Down Casting)
		 * - 업 캐스팅 상태에서 (부모 참조 변수 = 자식 객체)
		 *   참조 변수의 자료형을 자식 타입으로 강제 형변환 하는 것
		 */
		
		
		
		// 업캐스팅 확인
		// 부모 참조 변수 = 자식 객체 (오류 발생 X)
		// -> 값 처리 원칙 무시한거 아닌가? 아니다!!!
		//  -> 왜? 자식 객체 내 부모 객체 부분만 참조하기 때문에!!
		Parent p2 = new Child("김", 9999, "아반떼");
		
		
		// p2가 호출 가능한 메서드 
		// - Parent, Object 메서드만 호출 가능
		// - Child 객체 이지만 Parent로 변경되어 
		//   Child 메서드 인식 불가
		System.out.println("p2.getLastName() : " + p2.getLastName());
		System.out.println("p2.hashCode() : " + p2.hashCode());
//		 System.out.println(p2.getCar()); // 오류 발생
		
		
		System.out.println("------------------------------------");
		
		// 다운 캐스팅 확인
		// -> 참조 변수를 자식 자료형으로 강제 형변환
		System.out.println( ((Child)p2).getCar() ); 
		
		// 얕은 복사(주소만 복사)를 이용한 다운 캐스팅
		Child c2 = (Child)p2;
		
		System.out.println("c2.getCar() : " + c2.getCar());
		
		
	}
}
