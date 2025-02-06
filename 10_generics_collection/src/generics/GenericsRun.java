package generics;

import java.util.List;

public class GenericsRun {
	public static void main(String[] args) {
		
		/* Box의 제네릭 타입을 String으로 지정 */
		Box<String> box1 = new Box<String>();
		
		box1.setValue("String만 전달 가능");
		System.out.println( box1.getValue()  );
		
		
		/* Box의 제네릭 타입을 Integer로 지정 */
		Box<Integer> box2 = new Box<Integer>();
		box2.setValue(1234); // int -> Integer (Auto Boxing)
		System.out.println(box2.getValue());
		
		
		System.out.println("-----------------------------");
		
		System.out.println("[제네릭스를 이용한 구체적인 타입제한]");
		
		TestBox<Parent> t1 = new TestBox<Parent>();
		t1.setObj(new Parent());
		System.out.println(t1.getObj().getClass());
		
		// Parent를 상속 받은 Child로 타입 제한 가능
		TestBox<Child> t2 = new TestBox<Child>();
		t2.setObj(new Child());
		System.out.println(t2.getObj().getClass());
		
		// String은 Parent 상속 관계가 아니기 때문에 오류 발생!!
//		TestBox<String> t3 = new TestBox<String>();
		
		
	}
	
	/* 와일드카드 <?>
	 * - 제네릭 클래스의 타입 처리를 유연하게 대처해주는 문법
	 * 
	 * <?> : ?에 어떤 타입이든 가능
	 * 
	 * <? extends T> : ?는 T 또는 T 하위 타입
	 * 
	 * <? super T>   : ?는 T 또는 T 상위 타입
	 */
	public void test1(List<? extends Parent> list) {}
	
}
