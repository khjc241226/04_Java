package section04.run;

import section04.service.CharService;

public class CharRun {
	public static void main(String[] args) {
		CharService service = new CharService();
		
//		service.fileOutput1();
//		service.fileOutput2();
//		service.fileInput();
		service.keyboardInput();
	}
}
