package ex;

public class VariableEx2 {
	
	// main method : 자바 실행 구문
	public static void main(String[] args) {
		
		/* ---- 컴퓨터 값 처리 원칙 ----
		 * 
		 * - 같은 자료형 끼리만 연산이 가능하고
		 *   연산 결과도 같은 자료형만 반환된다.
		 *   
		 * ---- 형변환(Type Casting) ----
		 * 
		 * - 값의 자료형을 변환하는 것
		 * 
		 * 
		 * ---- 자동 형변환(묵시적 형변환) ----
		 * 
		 * - 값의 범위가 다른 값들 끼리(다른 자료형들 끼리)
		 *   연산 시
		 *   "컴파일러(번역기)"가 자동으로
		 *   값의 범위가 [작은] 값을
		 *   [큰] 범위의 자료형으로 변환하는 것 
		 */
		
		System.out.println("[자동 형변환 예시 1]");
		
		int a1 = 12;
		double b1 = 1.3;

		// [a1 + b1]
		// 1) int + double 연산 -> 값 처리 원칙 위배
		
		// 2) 컴파일러가 자동 형변환 수행
		//    -> 값의 범위가 작은 int를 double로 변환
		
		// 3) double + double의 결과로 double 반환
		
		// [int result1 = double]
		// -> 자료형이 같지 않아 연산 불가
		// -> 변수 선언 자료형 int처럼 명시한 자료형은 
		//    자동 형변환의 대상 X
		//   --> 개발자가 직접 double로 변경해서 작성
		
//		int result1 = a1 + b1;
		double result1 = a1 + b1;
		System.out.println("result1 : " + result1); // 13.3
		
		
		
		// 문자형에 저장된 값은 정수가 맞는지 확인 + 자동 형변환
		System.out.println("---------------------");
		System.out.println("[자동 형변환 예시 2]");
		
		char ch2 = 'A'; // 'A'는 유니코드 65번
		int  num2 = 100;
		int result2 = ch2 + num2; // char + int -> int + int = int
		
		System.out.println("result2 : " + result2);
		
		
		
		// 같은 자료형 끼리 연산 시 자동 형변환 되는 경우
		// -> 값의 범위로 생각 X, 컴퓨터 값 처리 원칙 생각 O
		System.out.println("---------------------");
		System.out.println("[자동 형변환 예시 3]");
		
		int a3 = 3;
		int b3 = 2;
		
		// int / int = int (값 처리 원칙)
		int result3 = a3 / b3; // 1
		
		System.out.println("result3 : " + result3);
		// 왜 결과가 1.5가 아니라 1???
		// - 값 처리 원칙에 의해서
		//   int / int의 결과는 무조건 int가 되야되기 때문에
		//   컴파일러가 1.5(double)을 1(int)로 자동 형변환
		//  -> 값의 범위가 관계없는 자동 형변환 예외 경우
		
		
		
		// 자동 형변환이 되지 않는 경우
		// -> "강제 형변환" 이용
		System.out.println("---------------------");
		System.out.println("[자동 형변환 예시 4]");
		
		int a4 = 100;
		double b4 = 23.4;
		int result4 = (int)(a4 + b4); // a4 + b4 결과를 int 강제 형변환
		
		System.out.println("result4 : " + result4); // 123
		
		
	}
	
}
