package section02.run;

import section02.dto.Animal;
import section02.dto.Cat;

public class AbstractionRun {
	public static void main(String[] args) {
		
		/* 확인 1. 추상 클래스는 객체(instance) 생성 불가 */
		
		// Cannot instantiate the type Animal
		// -> Animal 타입은 인스턴스화 할 수 없다
		//   왜? 추상 클래스라서
//		Animal a = new Animal();
		
		
		/* 확인 2. 추상 클래스를 상속 받은 객체 생성 */
		Cat cat = new Cat("포유류", "단모");
		cat.eat();
		cat.sleep();
		cat.move();
		
		
		/* 확인 3. 추상 클래스를 참조형 변수로 사용하기 */
		
		// 다형성 - 업 캐스팅 적용
		Animal a2 = new Cat("포유류", "장모");
		
		// Animal의 eat() 메서드는 추상 메서드로
		// 원래는 호출이 불가능해야 하지만
		// 참조하는 객체가 eat()를 구현한 자식 타입이므로
		// 컴파일 시(정적 바인딩) 오류가 발생하지 않는다!
		
		// 그리고 실제 실행 시 Car의 eat() 실행됨 (동적 바인딩)
		System.out.println("----------------------------");
		a2.eat();
		a2.move();
		a2.sleep();
		
		
		System.out.println("--------------------------------");
		
		
		/* 확인 4. 추상 클래스 활용법 */
		
		
		
		
		
		
	}
}
