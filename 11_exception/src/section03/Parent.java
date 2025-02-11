package section03;

import java.io.IOException;

public class Parent {

	public void method1() throws IOException{
		throw new IOException(); // 예외 강제 발생
	}
	
	public void method2() throws IOException{
		throw new IOException(); // 예외 강제 발생
	}
	
	public void method3() throws IOException{
		throw new IOException(); // 예외 강제 발생
	}
}
