package section02.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteService {

	/* Stream(스트림)
	 * - 데이터가 이동하는 통로 역할의 객체
	 * - 데이터의 흐름은 기본적으로 단방향
	 */
	
	/* [Byte 기반 스트림]
	 * 
	 * - 1byte 단위로 데이터를 입/출력하는 스트림
	 * 
	 * - 최상위 클래스 : InputStream, OutputStream
	 * 
	 * - 입/출력 가능 데이터
	 *  문자열, 파일(이미지, 영상, 오디오, pdf 등 모든 파일)
	 *  
	 *  * 단, 2byte 범위 문자열이 깨질 수 있고
	 *   좁은 통로(1byte)를 이용하다보니 속도가 상대적으로 느림
	 * 
	 * **********************************************************
	 * Stream 객체는 Java 프로그램이 종료 되어도
	 * 외부 장치/파일/프로그램과의 연결이 유지되기 때문에
	 * 자동으로 사라지지 않는다!!!
	 *  -> 프로그램 종료 전 
	 *    Stream 객체의 메모리를 반환하는 close() 구문 필수!
	 * **********************************************************
	 */
	
	/** 
	 * 지정된 경로에
	 * 파일 생성 + 내용 출력(파일 기반 바이트 스트림 이용)
	 */
	public void fileByteOutput() {
		
		// fos 참조 변수를 try, finally에서 모두 사용할 수 있게 선언
		FileOutputStream fos = null;
		
		try {
			// 폴더 경로, 파일명 지정
			String folderPath = "io_test/byte"; // 프로젝트폴더/io_test/byte
			String fileName = "바이트기반테스트.txt";
			
			// 폴더가 없으면 생성
			File folder = new File(folderPath);
			
			if(folder.exists() == false) {
				folder.mkdirs(); // 폴더 생성
			}
			
			
			// 출력할 파일과 연결된 출력용 스트림 객체를 생성
			// -> 이 때, 해당 파일이 없으면 자동으로 생성된다!!
			fos = new FileOutputStream(folderPath + "/" + fileName);
												// io_test/byte/바이트기반테스트.txt
			

			// txt 파일에 출력할 내용 작성
			
			/* StringBuilder : String의 불변성 문제를 해결하기 위한 객체 */
			StringBuilder builder = new StringBuilder();
			
			builder.append("Hello World!!\n");
			builder.append("1234567890\n");
			builder.append("!@#$%^&*()_+\n");
			builder.append("와 완전 쉽죠???\n");
			builder.append("자바 너무 재밌어요!!!!\n");
			builder.append("대답해봐요! 재밌죠?\n");
			
			// StringBuilder에 저장된 내용을 String으로 변경
			String content = builder.toString();
			
			/* 연결된 외부 txt파일로 content 내용을 출력 */
			
			// 방법 1) 1byte씩 끊어서 출력
			
			for(int i=0 ; i<content.length() ; i++) {
				
				char ch = content.charAt(i); // i번째 문자 1개 반환
				
				// 바이트 기반 스트림 -> 1바이트 범위만 출력 가능
				// -> 0~255(바이트 범위) 사이 글자는 정상 출력
				//    이후 글자(한글 등)은 모두 깨져서 출력
				
				fos.write(ch); // IOException 발생 가능성 있음
				
			}
			
			System.out.println("출력 완료");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		finally {
			try {
				if(fos != null) { // NullPointerException 방지
					fos.close(); // IOException 발생 가능성 있음
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
}
