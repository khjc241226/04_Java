package section01.run;

import section01.service.PolymorphismService;

public class PolymorphismRun {
	public static void main(String[] args) {
		
		PolymorphismService service = new PolymorphismService();
		
//		service.test1();
		
//		service.test2(); // Child, Parent, Object 순서로 출력
		
		service.test3();
		
	}
}
