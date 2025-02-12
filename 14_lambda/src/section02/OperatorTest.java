package section02;

import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorTest {
	public static void main(String[] args) {
		
		/* Operator 계열
		 * - 매개 변수와 반환 값의 타입이 같은 함수형 인터페이스
		 * - applyXXX() 메서드 제공
		 */
		
		// Unary : 단일 요소로 된(어네어리)
		/* UnaryOperator<T> : T를 전달 받아 T를 반환 */
		UnaryOperator<String> addString
			= str -> "[" + str + "] 님 반갑습니다";
			
		System.out.println(addString.apply("맹구"));
		
		
		// IntBinaryOperator : int 매개 변수 2개를 전달 받아 int 반환
		IntBinaryOperator squre = (a, x) -> {
			int result = 1;
			
			// a를 x번 거듭 제곱
			for(int i = 0 ; i < x ; i++) {
				result *= a;
			}
			return result;
		};
		
		System.out.println("2^10 == " + squre.applyAsInt(2, 10)); // 1024
		System.out.println("2^16 == " + squre.applyAsInt(2, 16)); // 65536
		
		
	}
}
