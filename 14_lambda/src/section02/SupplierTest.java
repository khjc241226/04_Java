package section02;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		
		/* Supplier 계열
		 * - 매개 변수 없이 값을 제공하는 함수형 인터페이스
		 * - getXXX() 메서드 제공 (반환형 O)
		 */
		
		// Supplier<T> : 매개 변수 없이 T를 반환
		Supplier<String> nameSupplier = () -> { return "홍길동"; };
		System.out.println("이름 출력 : " + nameSupplier.get());
		
		
		// IntSupplier : 정수(int)를 반환
		IntSupplier lottoNumber = () -> {
			Random random = new Random();
			return random.nextInt(45) + 1;
		};
		
		System.out.println("첫 번째 번호 : " + lottoNumber.getAsInt());
		System.out.println("두 번째 번호 : " + lottoNumber.getAsInt());
		System.out.println("세 번째 번호 : " + lottoNumber.getAsInt());
		
		
		
	}
}
