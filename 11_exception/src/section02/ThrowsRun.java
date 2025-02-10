package section02;

import java.io.IOException;

public class ThrowsRun {
	public static void main(String[] args) {
		
		ThrowsTest tt = new ThrowsTest();
		
		try {
			//tt.method1(); // IOException이 전달되어옴
			
			//tt.test1(); // CheckedException 확인
			// -> IOException 전달됨
			
			tt.test2(); // UncheckedException 확인
			// -> ArithmeticException 전달됨
		} 
		catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
		}
		
//	catch(IOException e) {
//		System.out.println("** IOException 처리됨 **");
//	}
		
		catch (Exception e) {
			// Exception : IOException의 부모 타입 == 다형성 적용
			System.out.println("예외 처리됨");
		} finally {
			System.out.println("마지막에 무조건 수행");
		}
		
	}
}
