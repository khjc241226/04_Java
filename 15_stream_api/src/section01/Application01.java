package section01;

import java.util.Arrays;

public class Application01 {
	public static void main(String[] args) {
		
		/* [Stream API]
		 * - 컬렉션의 요소들을 람다식을 이용해 요소를 순서대로 처리하는
		 *   방법을 제공하는 API
		 */
		
		
		/* 스트림 사용 예시 */
		int[] arr = {10, 20, 30, 40, 50};
		
		// 1) 일반 for문
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] % 20 != 0) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println(); // 줄바꿈
		
		// 2) 향상된 for문(forEach) -> Iterable 구현체만 가능
		for(int num : arr) {
			if(num % 20 != 0) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
		
		
		// 3) Stream API 이용
		// -> 배열, 컬렉션의 요소를 복제해서 보관하고 있는
		//    통 같이 생긴 객체를 생성해서
		//    순서대로 하나씩 꺼내서 사용
		Arrays.stream(arr)   // IntStream으로 변환
			.filter(num -> num % 20 != 0) 
			// 조건에 맞는 값만 필터링해서 새로운 IntStream 생성
			
			.forEach(a -> System.out.print(a + " ")); 
			// IntStream에 저장된 요소를 하나씩 꺼내서 출력
	}
	
}
