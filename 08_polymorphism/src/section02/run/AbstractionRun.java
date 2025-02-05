package section02.run;

import section02.dto.Animal;
import section02.dto.Cat;
import section02.dto.Snake;

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
		printAnimal(new Cat("포유류", "털없음"));
		printAnimal(new Snake("파충류"));
		
		
		
		
		
	} // main end
	
	
	// static : 프로그램 실행 시 해석되어
	//          static 메모리 영역에 생성되는 키워드
	//  -> 객체 생성 없이 클래스명.메서드명 호출 가능
	
	//  + 같은 클래스라도
	//    static 메서드 내에서 다른 메서드를 호출하려면
	//    1) 현재 클래스를 이용해 객체 생성
	//    2) 다른 메서드는 static으로 지정
	public static void printAnimal(Animal animal) {
		
		// 매개 변수 Animal(추상 클래스)
		// - 부모 타입의 참조 변수로 사용(다형성 - 업 캐스팅)
		
		// - Animal을 상속 받은 클래스는 
		//   반드시 상속 받아 재정의한 eat(), move(), sleep() 존재
		//   -> 자식에게 공통적인 규약 설정(오버라이딩 강제화)
		
		// - Animal이 물려준 추상 메서드를 호출(동적 바인딩)
		
		System.out.println("------------------------");
		System.out.println(animal.getClass().getName()); // 클래스명
		animal.eat();
		animal.move();
		animal.sleep();
		System.out.println(animal); // 컴파일러가 toString() 추가
		System.out.println("------------------------");
		
	}
	
	
	
	
	
	
	
}
