package section02;

import section01.Child3;

public class Section02Run {
	public static void main(String[] args) {
		
		// 학생 객체 생성 1 -> 기본 생성자
		Student s1 = new Student();
		
		// 학생 객체 생성 2 -> 매개 변수 있는 생성자
		Student s2 = new Student("홍길동", 17, "종로 고등학교");
		System.out.println(s2.toString());
		
		// Object 상속 확인
//		s2.equals(s2)
		
		System.out.println("-------------------------");
		
		/* 오버라이딩 테스트 */
		Person p3 = new Person("짱구", 5);
		System.out.println(p3 /* .toString() */ ); 
		System.out.println(p3.introduce("데빌구"));
		
		
		System.out.println("-------------------------");
		
		Student s3 = new Student("철수", 8, "떡잎초등학교");
		System.out.println(s3);
		System.out.println(s3.introduce("모범생"));
		
		
		
		/* [참고]
		 * print 관련 메서드 또는 문자열 + 연결 시
		 * 참조 변수명만 작성하면 자동으로 toString() 호출된다!
		 * (컴파일러가 자동으로 .toString() 추가)
		 */
		
		
	}
}
