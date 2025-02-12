package section01;

/* [함수형 인터페이스] 
 * - 람다식 사용을 위한 인터페이스
 * - 추상 메서드 1개만을 가지고 있음
 * 
 * [@FunctionalInterface]
 * - 함수형 인터페이스 작성법이 맞는지
 *   컴파일러에게 검증하라는 어노테이션(컴파일러용 주석)
 * */
@FunctionalInterface
public interface Calculator {

	/**두 수의 합을 반환하는 메서드
	 * @param a
	 * @param b
	 */
	public abstract int sumTwoNumber(int a, int b); 
	
//	void method(); // 오류 발생
}

/* (참고) 자바에서는 람다식을 구현하는데 왜 인터페이스를 사용했을까?
 * 
 *  - 자바는 클래스 또는 인터페이스 내부에만 
 *    메서드 선언이 가능하다!!
 *    
 *  - 인터페이스는 오로지 추상 메서드만 작성 가능하고
 *    오버라이딩 강제화된다!
 * 
 *  -> 위 조건을 만족하는 것이 "인터페이스" 밖에 없음
 *   
 *   + 인터페이스는 여러 추상 메서드 작성이 가능하기 때문에
 *     @FuntionalInterface를 이용해서 1개만 작성했는지 검사함
 * 
 * 
 * - Function : 독립적으로 존재할 수 있는 기능
 * - Method : 객체가 가지고 있는 (Function)기능 
 */









