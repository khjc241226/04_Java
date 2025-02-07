package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

/**
 * 도서 관리 프로그램 입/출력 담당 클래스(UI)
 */
public class BookView {
	
	private Scanner sc = new Scanner(System.in);
	private BookService service = new BookService();
	
	/**
	 * 프로그램 메인 메뉴
	 */
	public void displayMenu() {
		int input = 0; // 메뉴 번호를 저장할 변수
		
		do{
			System.out.println("\n***** 도서 관리 프로그램 *****\n");
			System.out.println("1. 전체 조회");
			System.out.println("2. index 번호로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 가격 수정하기");
			System.out.println("5. 책 제거하기");
			System.out.println("0. 종료");
			System.out.println();// 줄 바꿈
			
			System.out.print("메뉴 번호 입력 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거(오류 방지)
			System.out.println("---------------------------");

			switch(input) {
			case 1: selectAll(); break;
			
			case 2: selectIndex(); break;
			
			case 3: break;
			case 4: break;
			case 5: break;
			case 0: System.out.println("*** 프로그램이 종료됩니다 ***"); break;
			default: System.out.println("@@@ 메뉴 번호 잘못 입력 @@@");
			}
			
		}while(input != 0);
		
	}

	/**
	 * 전체 조회
	 * - BookService의 필드 bookList를 얻어와
	 *  일반 for문을 이용하여 모든 요소 정보 출력
	 *  
	 *  단, bookList에 저장된 정보가 없으면 
	 *   "저장된 책이 존재하지 않습니다" 출력
	 */
	private void selectAll() {
		System.out.println("\n### 전체 조회 ###\n");
		
		List<BookDTO> list = service.getBookList();
		
		// 전달 받은 list에 데이터가 있는지 확인
		
		// int size() : 저장된 객체의 개수 반환
		// boolean isEmpty() : 저장된 객체가 없으면 true 반환
		
//		if( list.size() == 0 ) {
		if( list.isEmpty() ) {
			System.out.println("저장된 책이 존재하지 않습니다");
			return;
		}
		
		// 모든 요소 정보 출력
		for(int i=0 ; i<list.size(); i++) {
			System.out.println(i + ") " + list.get(i));
		}
	}
	

	/**
	 * 조회하려는 책의 index 번호를 입력 받아 책 정보 출력
	 * 
	 * - BookService로 부터 index 번째 BookDTO 반환 받기
	 * 
	 * - 단, index 번호가 bookList의 범위를 초과하면 
	 *  "해당 인덱스에 책이 존재하지 않습니다" 출력
	 */
	private void selectIndex() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
