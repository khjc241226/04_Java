package common;

public class PrintEx {
	
	public static void main(String[] args) {
		
		/* System.out == 지정된 출력용 화면(이클립스 콘솔)
		 * 
		 * 1) System.out.print(출력내용);
		 * - 출력 내용을 콘솔에 출력
		 * - 출력 완료 후 줄이 바뀌지 않음!!!
		 * 
		 * 2) System.out.println(출력내용);
		 * - 출력 완료 후 줄이 바뀜!
		 *   (ln == line) 
		 * 
		 * 
		 * 3) System.out.printf("문자열 템플릿(패턴)", 패턴에 대입될 값/변수...);
		 * 
		 * - 정해진 형식(템플릿)에 맞는 문자열을 출력하는 구문
		 * 
		 * - 문자열 템플릿 중간에 "%"로 시작하는 패턴을 입력하여
		 *   원하는 변수/값을 대입할 수 있다
		 *   
		 * [패턴 종류]
		 * 
		 * - %d (Decimal, 10진 정수) : 정수(byte, short, int, long)
		 * 
		 * - %c (Character, 문자)    : 문자(char)
		 * 
		 * - %s (String, 문자열)     : 문자열(String)
		 * 
		 * - %b (boolean, 논리형)    : 논리형(boolean)
		 * 
		 * - %f (float, 실수)        : 실수형(float, double)
		 * 
		 * 
		 * - 양의 정수 : 정수 크기만큼 칸 확보 + 오른쪽 정렬
		 * ex) %4d, 3 대입 -> ㅁㅁㅁ3  (ㅁ은 빈칸을 표시)
		 * 
		 * - 음의 정수 : 정수 크기만큼 칸 확보 + 왼쪽 정렬
		 * ex) %-4d, 3 대입 -> 3ㅁㅁㅁ
		 * 
		 * 
		 * - 소수점 : 소수점 아래 몇째 자리까지 표시할지 지정
		 *           (지정된 자리 아래에서 반올림 처리)
		 * 
		 * ex) %.1f, 3.15 대입 -> 3.2
		 */
		
		
		// print() 확인
		System.out.print("이름 : "); // 줄바꿈(개행) X
		System.out.print("홍길동"); // 줄바꿈(개행) X
		System.out.print(", 나이 : 20세"); // 줄바꿈(개행) X
		// 출력 결과 ->  이름 : 홍길동, 나이 : 20세
		
		// println() 확인
		System.out.println(); // 출력 내용 없이 줄만 바꿈
		System.out.println(); // 출력 내용 없이 줄만 바꿈
		System.out.println(); // 출력 내용 없이 줄만 바꿈
		System.out.println("-------------------------------");
		System.out.println("[printf() 확인하기]");
		
		
		String name = "신짱구";    // 참조형(값 저장X, 값의 위치(주소) 저장)
		int age = 5;               // 정수 기본형, 4byte
		double height = 80.5;      // 실수 기본형, 8byte
		char gender = '남';        // 문자형, 2byte
		boolean javaStudy = false; // 논리형, 1byte
		
		// 신짱구는 5세 남아로 키는 80.5cm 이며, 자바 공부 여부:false
		
		// println() 버전
		System.out.println(name + "는 " + age +"세 " 
										 + gender + "아로 "
										 + "키는 " + height + "cm 이며, "
										 + "자바 공부 여부:" + javaStudy);
		
		// printf() 버전
		System.out.printf("%s는 %d세 %c아로 키는 %.1fcm 이며, 자바 공부 여부:%b"
											,name, age, gender, height, javaStudy);
		
		
		
		
	}
}
