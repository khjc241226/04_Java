package section02.run;

import section02.service.ByteService;

public class ByteRun {
	public static void main(String[] args) {
		
		ByteService service = new ByteService();
		
		service.fileByteOutput(); // 파일 출력
	}
}
