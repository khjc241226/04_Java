package section04.run;

import section04.service.UserDefineExceptionService;

public class UserDefineExceptionRun {
	public static void main(String[] args) {
		
		UserDefineExceptionService service
			= new UserDefineExceptionService();
		
		service.test1();
		
	}
}
