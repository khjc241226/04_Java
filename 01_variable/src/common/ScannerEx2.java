package common;

import java.util.Scanner; // Scanner 클래스 가져오기

public class ScannerEx2 {

	public static void main(String[] args) {
		
		// Scanner 객체 생성
		Scanner sc = new Scanner(System.in); 
		// 키보드 입력을 읽어오는 Scanner 객체를 생성해 sc변수에 저장
		
		
		System.out.println("[자기 소개 문장 생성 프로그램]");
		
		System.out.print("이름 입력 : ");
		String name = sc.next(); 
		// sc.next();
		// - 입력 버퍼에서 다음 문자열(단어) 읽어오기
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("키 입력(cm) : ");
		double height = sc.nextDouble();
		// sc.nextDouble();
		// - 입력 버퍼에서 다음 실수를 읽어오기
		
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
				
		// Scanner에서 char 자료형을 읽어오는 방법 제공 X
		// -> 문자열을 읽어와 0번째 인덱스 문자 하나만 얻어오기
		
		// String.charAt(index) : String에서 index번째 문자 하나 반환
				
		System.out.println("------------------------------");
		System.out.println("[자기 소개 문장]");
		
		System.out.printf("제 이름은 %s이고 나이는 %d세, 키는 %.1fcm인 %c성 입니다"
											, name, age, height, gender);        
		
	}
	
	
	
}
