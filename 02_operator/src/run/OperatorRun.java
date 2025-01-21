package run;

// 다른 패키지의 클래스를 가져오기 위해선 import 구문 작성
import ex.OperatorEx; // OperatorEx 가져오기

/**
 * 연산자 예제 실행용 클래스
 */
public class OperatorRun {

	// main method : 자바 실행 구문(메서드)
	public static void main(String[] args) {
		
		// 가져온 OperatorEx 클래스를 객체로 생성
		OperatorEx ex = new OperatorEx();
		
		// OperatorEx 객체가 가지고있는 test1() 메서드를 호출
		
		// ex.test1(); // 실행하고 싶지 않으면 삭제 또는 주석처리
		// ex.test2();
		
//		ex.method1();
//		ex.method2();
		ex.method3();
	}
	
	
}
