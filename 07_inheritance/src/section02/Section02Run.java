package section02;

public class Section02Run {
	public static void main(String[] args) {
		
		// 학생 객체 생성 1 -> 기본 생성자
		Student s1 = new Student();
		
		// 학생 객체 생성 2 -> 매개 변수 있는 생성자
		Student s2 = new Student("홍길동", 17, "종로 고등학교");
		System.out.println(s2.toString());
		
	}
}
