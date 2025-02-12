package section02;

public class Main2 {
	public static void main(String[] args) {
		
		// 인스턴스 내부 클래스 생성 방법
//		OuterClass2 outer = new OuterClass2();
//		OuterClass2.StaticInnerClass inner = outer.new StaticInnerClass();
		
		/* 정적 내부 클래스 생성 방법 
		 * - 외부 인스턴스 생성 없이 바로 내부 클래스 이용 가능
		 * */
		OuterClass2.StaticInnerClass inner 
			= new OuterClass2.StaticInnerClass();
		
		inner.display();
		
		// 참조 변수를 이용한 static 호출 권장 X
		// inner.staticDisplay();
		OuterClass2.StaticInnerClass.staticDisplay(); // 클래스명으로 호출 
		
		
		
	}
}
