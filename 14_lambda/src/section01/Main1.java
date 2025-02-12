package section01;

public class Main1 {
	public static void main(String[] args) {
		
		/* Calculator 구현체를 만들어서 메서드 수행하기 */
		
		/* 1. 인터페이스를 상속 받은 클래스 이용 */
		Calculator calc1 = new CalculatorImpl(); // 구현체 객체 이용
		System.out.println("calc1.sumTwoNumber(3, 5) : " 
											 + calc1.sumTwoNumber(3, 5)); // 8
		
		/* 2. 익명 내부 클래스 이용 */
		Calculator calc2 = new Calculator() {
			@Override
			public int sumTwoNumber(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println("calc2.sumTwoNumber(10, 55) : " 
				 + calc2.sumTwoNumber(10, 55)); // 65
		
		
		/* 3. 람다식을 이용한 방법 */
		// () -> {}
		
		// Calculator 인터페이스 
		// == 함수형 인터페이스 -> 추상 메서드 1개만 존재!
		// -> 추상 메서드 int sumTwoNumber(int a, int b)를 오버라이딩
		
		Calculator calc3 = (a, b) -> { return a + b; };
		// -> 람다식은 컴파일 시 익명 내부 클래스로 변환된다!!
		
		System.out.println("calc3.sumTwoNumber(100, 899) : " 
				 + calc3.sumTwoNumber(100, 899)); // 100
		
		
		// {} 내부 코드가 한 줄 -> {}, return 생략 가능
		Calculator calc4 = (a, b) -> 2 * (a + b);
		
		System.out.println("calc4.sumTwoNumber(3, 4) : " 
				 + calc4.sumTwoNumber(3, 4)); // 14
		
		// a^2 + b^3 반환하는 람다식 작성
		Calculator calc5 = (a, b) -> (a*a) + (b*b*b);
//		Calculator calc5 
//			= (a, b) -> (int)Math.pow(a, 2) + (int)Math.pow(b, 3);
		
		System.out.println("calc5.sumTwoNumber(3, 2) : " 
				 + calc5.sumTwoNumber(3, 2)); // 17
		
	}
}
