package section01;

public class HashCodeRun {
	public static void main(String[] args) {
		
		/* int Object.hashCode();
		 * - 객체를 식별하는 값
		 * - 객체 메모리 주소를 이용해서 생성
		 * 
		 * hashCode() 오버라이딩
		 * - equals() 결과가 true인 경우
		 *   hashCode() 결과도 같도록 오버라이딩
		 *   (Java 공식 문서에 써져있음)
		 *   
		 * - equals() 오버라이딩 시
		 *   hashCode()도 오버라이딩 하기로 약속
		 *   -> 자바에서 약속 지킬 것을 예상하고 
		 *      hashCode() 사용 기능을 많이 제공
		 */
		
		Book book1 = new Book(2, "해리포터", "J.K.롤링", 8000);
		Book book2 = new Book(2, "해리포터", "J.K.롤링", 8000);
		
		
		
		// 오버라이딩 전  -> book1 : 664740647 / book2 : 321001045
		// 오버라이딩 후  -> book1 : 2049242871 / book2 : 2049242871
		System.out.println("book1.hashCode() : " + book1.hashCode());
		System.out.println("book2.hashCode() : " + book2.hashCode());
		
		System.out.println(book1.equals(book2)); // true
		
		
		
		
	}
}
