package section02;

import java.time.LocalDate;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjLongConsumer;

public class ConsumerTest {
	public static void main(String[] args) {
		
		/* Consumer 계열
		 * - 매개 변수를 받아서 소비하는 함수형 인터페이스
		 * - 반환 값 없음(매개 변수가 소비됨)
		 * 
		 * - accept() 메서드 제공 (반환 값 없음)
 		 */
		
		// Consumer<T> : 매개 변수 T를 전달 받아 소비
		Consumer<String> printString 
			= (message) 
				-> {System.out.println("전달 받은 message : " + message); };
		printString.accept("쉬는 시간입니다");
		
		
		// BiConsumer<T, U> : 매개 변수 T, U를 소비
		BiConsumer<String, Integer> printNameAge
			=	(name, age) -> System.out.println(name + " / " + age); 
			
		printNameAge.accept("짱구", 5);
		
		
		// ObjLongConsumer<T> : T와 long을 전달 받아 소비
		ObjLongConsumer<LocalDate> objLongConsumer
			= (date, days) 
			-> System.out.printf("%s의 %d일 후의 날짜는 %s\n",
													date, days, date.plusDays(days));
		
		objLongConsumer.accept(LocalDate.now(), 5);
		
		
		/* LocalDate
		 * - 자바에서 날짜(시간)을 저장하는 객체
		 * - 예전에는 Date, Calendar 등을 이용했지만
		 *   다 deprecated 되어 최근에는 LocalDate를 사용함
		 *   
		 * LocalDate.now() : 현재 시간을 저장한 LocalDate 객체 반환
		 * 
		 * LocalDate.plusDays(long l) : 저장된 시간에서 l일 후 날짜 반환
		 */
		
		
		
	}
}
