package service;

import java.util.Random;

import dto.StudentDTO;

/* Service 
 * - 프로그램의 실질적인 기능(비즈니스 로직)을 
 *   제공하는 클래스
 */
public class StudentService {

	// StudentDTO 객체 배열 선언
	private StudentDTO[] students = new StudentDTO[5];
	
	// new StudentDTO[5] 
	// - StudentDTO 참조형 변수 5칸짜리 배열 생성
	// - 인덱스 : 0 ~ 4
	// - 각 인덱스 요소의 초기값 : null (참조 객체 없음)
	
	
	/* 기본 생성자 */
	public StudentService() {
		System.out.println("[초기 학생 정보가 추가됨...]\n");
		
		students[0] = new StudentDTO("20250001", "짱구", '남');
		students[1] = new StudentDTO("20250002", "유리", '여');
		students[2] = new StudentDTO("20250003", "훈이", '남');
		
		
		// 자바 제공 난수 발생 객체
		Random random = new Random(); 
		
		for(StudentDTO std : students) {
			
			if(std == null) {
				continue;
			}
			
			// random.nextInt(101) : 0 이상 101 미만의 정수형 난수 생성
			std.setHtml( random.nextInt(101) );
			std.setCss( random.nextInt(101) );
			std.setJs( random.nextInt(101) );
			std.setJava( random.nextInt(101) );
			
		}
		
	}
	
	
	
	
	
	/**
	 * students 객체 배열을 반환하는 메서드
	 * (students에 저장된 주소가 복사되서 반환됨 == 얕은 복사) 
	 * @return students
	 */
	public StudentDTO[] getStudents() {
		return students;
	}
	
	
	
	
	
}
