package section04.exception;

/* 사용자 정의 예외를 만드는 방법!!
 * - 기존에 존재하는 Exception 관련 클래스 중 
 *   하나를 상속 받으면 된다!
 *   (내부 코드는 원하는대로 작성)
 */

/**
 * 결과가 음수인 경우 발생하는 예외
 */
public class NegativeQuantityException extends Exception{

	// 기본 생성자
	public NegativeQuantityException() {
		super("음수 결과 발생"); // 부모 생성자
		// -> 사용자 정의 예외 객체 생성 시 보여질 기본 메시지
	}
	
	public NegativeQuantityException(String message) {
		super(message); // 전달 받은 메시지를 예외 메시지로 지정
	}
	
}





