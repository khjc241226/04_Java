package condition.service;

import java.util.Scanner;

/**
 * 기능(예제, 연습문제) 제공용 클래스
 */
public class ConditionService {

	// 필드(field) == 멤버 변수 == 인스턴스 변수
	//-  해당 클래스(객체) 내에서 언제, 어디서든지 사용 가능한 변수
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 1 ~ 10 사이 난수(정수)가
	 * 짝수인지 홀수인지 검사
	 */
	public void method1() {
		
		// Math.random() : 0.0 이상 1.0 미만 난수 발생
		int randomNumber = (int)(Math.random() * 10 + 1);

		// 2로 나눴을 때 나머지가 0인지 아닌지 결과를 저장
		// == 0이면 짝수(true), 1이면 홀수(false)
		boolean result = randomNumber % 2 == 0;
		
		System.out.println("randomNumber : " + randomNumber);
		
		// 조건식 : 결과가 true 또는 false가 되는 식
		if(result) { // true인 경우
			System.out.println("짝수 입니다.");
		} else { // false인 경우
			System.out.println("홀수 입니다");
		}
		
	}
	
	
	/**
	 * 나이를 입력 받아 "어린이", "청소년", "성인" 구분
	 * <pre>
	 * 13세 이하 "어린이"
	 * 13세 초과 19세 이하 "청소년"
	 * 19세 초과 "성인"
	 * </pre>
	 */
	public void method2() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		// if - else if - else 이용
		String result;
		
		if(age > 19) {
			result = "성인";
			
		} else if(age > 13) {
			result = "청소년";
			
		} else {
			result = "어린이";
		}
		
		System.out.println(result);
	}
	
	
	/** 나이를 입력 받아 구분하기
	 * <pre>
	 * 13세 이하 "어린이"
	 * 13세 초과 19세 이하 중
	 *  - 14~16세 : 청소년(중)
	 *  - 17~19세 : 청소년(고)
	 * 19세 초과 "성인" 
	 * 0 미만 100 이상 "잘못 입력하셨습니다"
	 * <pre>
	 */
	public void method3() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if(age < 0 || age >= 100) {
			System.out.println("잘못 입력하셨습니다");
			return; // 메서드(함수)를 종료하고 호출한 곳으로 돌아감
		}
		
		String result;
		
		if(age > 19) {
			result = "성인";
		} else if(age > 13) {
			result = "청소년" + (age <= 16 ? "(중)" : "(고)") ;
		} else {
			result = "어린이";
		}
		
		System.out.println(result);
	}
	
	
	// ---------------------------------------------------
	/* switch - case - default */
	
	/**
	 * ConditionService에 작성된 메서드를 골라서 실행하는 메서드
	 */
	public void displayMenu() {
		
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. 성적판별기");
		System.out.print("메뉴 번호 입력 >> ");
		int input = sc.nextInt();
		
		// (중요) 같은 클래스 내 필드, 메서드는 이름만 부르면 호출 가능!
		switch(input) {
		case 1 : method1(); break;
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		default : System.out.println("없는 메뉴 번호 입니다");
		}
	}
	
	/** [성적 판별기]
	 * <pre>
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 성적 부여
	 * 
	 * - 중간고사 (40%), 기말고사(50%), 과제(10%)
	 * 
	 * - 입력 시 각각 100점 만점으로 입력 받음
	 * 
	 * - 합산된 점수에 따라 성적 부여
	 * 
	 * 95점 이상 : A+
	 * 90점 이상 : A
	 * 85점 이상 : B+
	 * 80점 이상 : B
	 * 75점 이상 : C+
	 * 70점 이상 : C
	 * 65점 이상 : D+
	 * 60점 이상 : D
	 * 나머지    : F
	 * 
	 * 
	 * [실행 화면]
	 * 이름 : 홍길동
	 * 중간고사 점수(40%) : 100
	 * 기말고사 점수(50%) : 80
	 * 과제 점수(10%) : 50
	 * 
	 * 홍길동의 최종 점수 : 85.0점
	 * 성적 : B+
	 *</pre>
	 */
	public void method4() {
		
		System.out.print("이름 : ");
		String name = sc.next(); // 입력 버퍼에서 다음 문자열(단어) 얻어오기
		
		System.out.print("중간고사 점수(40%) : ");
		int midTerm = sc.nextInt();
		
		System.out.print("기말고사 점수(50%) : ");
		int finalTerm = sc.nextInt();
		
		System.out.print("과제 점수(10%) : ");
		int report = sc.nextInt();
		
		// 점수 합계 
		double sum = (midTerm * 0.4) + (finalTerm * 0.5) + (report * 0.1);
		
		String result; // 성적 저장용 변수
		
		// Java 지역변수는 초기화 안되면 사용 불가!
		//System.out.println(result);  // 오류 발생
		
		
		// (int)sum/10 
		// - sum을 먼저 int로 강제 형변환 후 10으로 나눔
		// -> 십의 자리 숫자만 남기는 식
		switch((int)sum/10) { //  switch문 () 내에는 정수/문자열 작성 가능
		
			// 하나의 case에 여러 경우를 , 기호를 이용해서 작성 가능
			// (Java만 가능!!! JS 안됨)
			case 9, 10  : result = "A"; break;
			case 8  : result = "B"; break;
			case 7  : result = "C"; break;
			case 6  : result = "D"; break;
			default : result = "F";
		}
		
		
		// [일의 자리 생각]
		// 합계가 100점 또는
		// 60점대 이상 이면서 나머지 5 이상인 경우(65~, 75~, 85~, 95~)
		if(sum == 100 || (sum >= 60.0 && sum % 10 >= 5) ) {
			result += "+";
		}
		
		// 결과 출력
		System.out.printf("\n%s의 최종점수 : %.1f점\n", name, sum);
		System.out.println("성적 : " + result);
	}
	
	
}



