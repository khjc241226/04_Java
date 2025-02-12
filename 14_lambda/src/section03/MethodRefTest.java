package section03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodRefTest {
	// Reference : 참조
	
	public static void main(String[] args) {
		
		/* [메서드 참조]
		 * - 이미 존재하는 메서드를 람다식으로 표현할 때 사용하는
		 *   축약된 표시
		 *   
		 *   -> 새로운 람다식을 작성하는 것이 아니라
		 *      이미 구현된 같은 기능의 메서드를 참조하자!
		 */
		
		
		// 문자열의 길이 반환
		String str = "Hello World";
		
		// 방법 1) 람다식 작성
		Function<String, Integer> strLength = (s) -> s.length();
		System.out.printf("%s의 길이 : %d\n", 
											str, strLength.apply(str));
		
		// 방법 2) 메서드 참조 방식
		Function<String, Integer> strLength2 = String::length;
		// -> String을 매개 변수로 전달하면
		//    String.length() 메서드를 참조해서 실행 후
		//    Integer 값을 반환
		
		System.out.printf("%s의 길이 : %d\n", 
											str, strLength2.apply(str));
		
		
		System.out.println("------------------------------");
		
		List<String> nameList = new ArrayList<String>();
		
		nameList.add("짱구");
		nameList.add("유리");
		nameList.add("훈이");
		nameList.add("맹구");
		nameList.add("철수");
		
//		Consumer<String> printName 
//			= (name) -> System.out.println(name);
//		nameList.forEach(printName);
		
		// 모든 요소를 반복하면서 출력
		nameList.forEach(name -> System.out.println(name));
			
		System.out.println("----------------------------------");
		
		// 메서드 참조
		// -> nameList에서 하나씩 꺼낸 값을 
		//  System.out.println()에 전달하여 실행
		
		// 이미 완성되어있는 메서드 (모양을) 참조
		nameList.forEach(System.out::println);
		
		
		System.out.println("---------------------------");
		
		// 절대 값 반환 람다식 작성
		Function<Integer, Integer> abs1
			= (num) -> {
				if(num < 0) return num * -1; // 양수로 변환
				return num;
			};
			
		// 이미 똑같은 메서드가 존재하면
		// 또 작성하지 말고 참조하자!! -> 메서드 참조
		Function<Integer, Integer> abs2 = Math::abs;
		
		System.out.println(abs1.apply(-100)); // 100
		System.out.println(abs2.apply(-100)); // 100
		
		
		System.out.println("---------------------------");
		
		// 람다 작성  
		Consumer<String[]> cons = (arr) -> {
			
			for(String element : arr) {
				System.out.println(element);
			}
		};
		
		
		// 내가 만든 메서드 참조
		Consumer<String[]> myCons 
			= MethodRefTest::printArray;
		
		
		String[] fruits = {"딸기", "사과", "바나나"};
		
		cons.accept(fruits);
		System.out.println("********");
		myCons.accept(fruits);
		
		
	}
	
												// {"딸기", "사과", "바나나"}
	public static void printArray(String[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}
	
	
	
}
