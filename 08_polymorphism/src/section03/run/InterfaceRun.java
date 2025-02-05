package section03.run;

import section03.dto.BDHCalculator;
import section03.dto.BDHCalculator2;
import section03.dto.Calculator;

public class InterfaceRun {
	
	public static void main(String[] args) {
		
		// 인터페이스를 부모 타입 참조 변수로 하여 
		// Calculator 구현체 생성하기
		// (업 캐스팅 + 동적 바인딩)
		
//		Calculator calc = new BDHCalculator();
		
		
		/* 같은 Calculator 인터페이스를 상속 받은 다른 객체 생성
		 * -> Calculator가 제공하는 같은 이름의 메서드가 존재
		 * -> 다른 코드 수정 없이 객체 생성 부분만 수정해도
		 *    새 객체의 기능을 모두 호출 가능
		 *    -> 유지 보수성 향상!!
		 */
		Calculator calc = new BDHCalculator2();
		
		
		System.out.println( calc.plus(1234, 5678) );
		System.out.println( calc.minus(1000000000, 999999999) );
		System.out.println( calc.multi(33333, 44444) );
		System.out.println( calc.div(1111, 33) );
		System.out.println( calc.mod(1111, 33) );
		System.out.println( calc.pow(2, 3) );
		System.out.println( calc.areaOfCircle(10.5) );
		
	}
	
}
