package view;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

// View : 사용자에게 보여지는 역할을 하는 클래스/객체
// - 보여줄 화면을 출력 / 필요한 데이터를 입력
public class MemberView {

	private MemberService service = null;
	private Scanner sc = null;

	/**
	 * 기본 생성자 - MemberView 객체 생성 시 필드 초기화 - MemberService 초기화 시 예외가 발생할 수 있으므로 try -
	 * catch 작성
	 */
	public MemberView() {

		try {
			// 객체 생성 중 발생한 예외를 View에 모아서 처리
			service = new MemberServiceImpl();

			// 키보드를 입력 받기 위한 스트림 생성
			sc = new Scanner(new InputStreamReader(System.in, "UTF-8"));

		} catch (Exception e) {

			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0); // 프로그램 종료
		}
	}

	// -------------------------------------------------------------------
	// [메인 메뉴]
	public void mainMenu() {

		int input = 0;
		do {

			try {
				// 메뉴 출력 후 입력된 번호를 반환 받기
				System.out.println("\n===== 회원 관리 프로그램 =====\n");

				System.out.println("1. 회원 가입(추가)");
				System.out.println("2. 회원 전체 조회");
				System.out.println("3. 이름 검색(동명이인 있으면 모두 조회)");
				System.out.println("4. 특정 회원 사용 금액 누적하기");
				System.out.println("5. 회원 정보 수정");
				System.out.println("6. 회원 탈퇴");
				System.out.println("0. 종료");

				System.out.print("메뉴 선택 >>> ");

				// 입력 받은 문자열을 int 형태로 변환
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼에 남은 문자열 제거
				System.out.println(); // 줄바꿈

				// 선택된 메뉴 번호에 따라 case 선택
				switch (input) {
				case 1: addMember(); break;
				case 2: selectAll(); break;
				case 3:	selectName(); break;
				case 4: updateAmount();	break;
				case 5:	updateMember();	break;
				case 6:	deleteMember();	break;
				case 0:	System.out.println("*** 프로그램 종료 ***");	break;
				default:	System.out.println("### 메뉴에 작성된 번호만 입력 해주세요 ###");
				}
				System.out.println("==========================================");

				
				/* 모든 메서드에서 던져진 예외를 모아서 처리*/
			} catch (NumberFormatException e) {
				System.out.println("\n### 숫자만 입력 해주세요 ###\n");
				input = -1; // 첫 반복에서 종료되지 않게 값 변경

			} catch (IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n");
				e.printStackTrace(); // 예외 추적

			} catch (Exception e) { // 나머지 예외 처리
				e.printStackTrace();
			}

		} while (input != 0);
	}


	// ---------------------------------------------------------------
	// [1. 회원 가입(추가)]
	
	private void addMember() throws IOException {
		System.out.println("\n----- 회원 가입(추가) -----\n");
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		// 정상 입력(11글자)이 될 때 까지 다시 입력 받기
		String phone = null;
		
		while(true) {
			System.out.print("휴대폰 번호(- 제외) : ");
			phone = sc.nextLine();

			if(phone.length() != 11) {
				System.out.println("*** 다시 입력 해주세요 ***\n");
				continue;
			}
			
			break;
		}
		
		
		// 회원 추가 서비스 호출 후 결과 반환 받기
		boolean result = service.addMember(name, phone);
		
		if(result) {
			System.out.println("\n*** 회원이 추가 되었습니다 ***\n");
			
		} else {
			System.out.println("\n### 중복되는 휴대폰 번호가 존재합니다 ###\n");
		}
		
	}
	
	
	
	
	// -------------------------------------------------------------
	// [2. 회원 전체 조회]
	
	private void selectAll() {
		System.out.println("\n----- 회원 전체 조회 -----\n");
		
		// 회원 목록을 조회해 반환하는 서비스 호출
		List<Member> memberList = service.getMemberList();
		
		// 조회된 회원 목록이 없을 경우
		// -> MemberDaoImpl 생성자 코드에 의해서
		//   memberList는 "절대로" null이 될 수 없다!!!!
		
		// -> 참조하는 List는 있지만 비어있는지 검사를 해야한다!
		if(memberList.isEmpty()) {
			System.out.println("\n### 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		
		String[] gradeArr = {"일반", "골드", "다이아"};
		
		
		System.out.println("-------------------------------------------");
		System.out.printf("%-5s %-7s %8s %4s \n",
				"[이름]", "[휴대폰 번호]", "[누적금액]", "[등급]");
		System.out.println("-------------------------------------------");
		
		
		/*  향상된 for문 */		
//		for(Member member : memberList) {
//			System.out.printf("%-6s %-12s %8d %5s \n",
//				member.getName(), member.getPhone(),
//				member.getAmount(),  gradeArr[member.getGrade()] );
//		}
		
		/* 스트림 */
		memberList.stream().forEach((member)->{
			System.out.printf("%-6s %-12s %8d %5s \n",
					member.getName(), member.getPhone(),
					member.getAmount(),  gradeArr[member.getGrade()]);
		});
	}
	
	
	
	// ------------------------------------------------------------------------
	// [이름으로 검색(동명이인)]
	
	private void selectName() throws IOException {
		System.out.println("\n----- 이름 검색(동명이인 있으면 모두 조회) -----\n");
		
		// 검색할 이름 입력 받기
		System.out.print("검색할 이름 입력 : ");
		String searchName = sc.nextLine();
		
		// 이름 검색 서비스 호출 후 결과 반환 받기
		List<Member> searchList = service.selectName(searchName);
		
		// 검색 결과가 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 검색 결과가 없습니다 ###\n");
			return;
		}
		
		// 검색 결과가 있을 경우
		/* 향상된 for문 */
//		for(Member member : searchList) {
//			System.out.println(member);
//		}
		
		/* 스트림 */
		searchList.stream().forEach(System.out::println);
		
	}
	
	
	//------------------------------------------------------------
	// [특정 회원 사용 금액 누적하기]
	
	private void updateAmount() throws IOException {
		System.out.println("\n----- 특정 회원 사용 금액 누적하기 -----\n");
		
		System.out.print("회원 이름 입력 : ");
		String targetName = sc.nextLine();
		
		// 이름이 일치하는 회원 모두 조회
		List<Member> searchList = service.selectName(targetName);
		
		// 이름이 일치하는 회원이 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 이름이 일치하는 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
	
		// 금액 증가 대상 회원만 참조할 Member 참조 변수 선언
		Member target = null;
		
		// 1) 동명이인이 있을 경우
		//    -> 이름/전화번호를 출력해서 한 명만 선택하게 함
		if(searchList.size() > 1) {
			System.out.println("\n*** 대상 회원을 선택 해주세요 ***\n");
			
			/* 동명이인 회원이 있을 경우 선택하는 메서드 호출 */
			int input = selectMemberNumber(searchList);
			
			// target에 회원 저장
			target = searchList.get(input);
		
		} else {
			// 2) 동명이인이 없을 경우
			target = searchList.get(0);
		}
		
		
		// 누적할 금액 입력
		System.out.print("누적할 금액 입력 : ");
		int acc = sc.nextInt();
		
		
		// 대상 회원, 누적할 금액을 서비스로 전달하여 결과 반환
		// - 금액 누적 
		// - 등급 조정
		// - 파일에 데이터 저장
		
		// - 서비스에서 반환 받을 문자열
		// ex) 신짱구 회원님의 누적 금액
		//     2000 -> 100000
		//     * 골드 * 등급으로 변경 되셨습니다
		
		String result = service.updateAmount(target, acc);
		
		System.out.println(result);
	}
	
	
	// -----------------------------------------------------------------
	// [회원 정보 수정]
	
	private void updateMember() throws IOException {
		System.out.println("\n----- 회원 정보 수정 -----\n");
		
		System.out.print("회원 이름 입력 : ");
		
		String targetName = sc.nextLine();
		
		// 이름이 일치하는 회원 모두 조회
		List<Member> searchList = service.selectName(targetName);
		
		// 이름이 일치하는 회원이 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 이름이 일치하는 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		// 수정 대상을 참조할 변수 선언
		Member target = null;
		
		if(searchList.size() > 1) { // 동명이인 있을 경우
			
			System.out.println("\n*** 대상 회원을 선택 해주세요 ***\n");
			
			/* 동명이인 회원이 있을 경우 선택하는 메서드 호출 */
			int input = selectMemberNumber(searchList);
			
			if(input < 0 || input >= searchList.size()) {
				System.out.println("\n### 없는 회원 번호 입니다. 다시 시도 해주세요 ###\n");
				return;
			}
			
			target = searchList.get(input);
		
		} else { // 동명이인 없을 경우
			target = searchList.get(0);
		}
		
		// 수정할 전화 번호 입력받기
		System.out.print("수정할 전화번호 입력 : ");
		String phone = sc.nextLine();
		
		
		// 정보수정 서비스 호출 후 결과 문자열 반환 받기
		String result = service.updateMember(target, phone);
		System.out.println(result);
	}
	
	
	// ------------------------------------------------------------
	// [회원 탈퇴]
	
	private void deleteMember() throws IOException {
		System.out.println("\n----- 회원 탈퇴 -----\n");
		
		System.out.print("회원 이름 입력 : ");
		
		String targetName = sc.nextLine();
		
		// 이름이 일치하는 회원 모두 조회
		List<Member> searchList = service.selectName(targetName);
		
		
		// 이름이 일치하는 회원이 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 이름이 일치하는 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		// 탈퇴 대상을 참조할 변수 선언
		Member target = null;
		
		if(searchList.size() > 1) { // 동명이인 있을 경우
			
			/* 동명이인 회원이 있을 경우 선택하는 메서드 호출 */
			int input = selectMemberNumber(searchList);
			
			if(input < 0 || input >= searchList.size()) {
				System.out.println("\n### 없는 회원 번호 입니다. 다시 시도 해주세요 ###\n");
				return;
			}
			
			target = searchList.get(input);
		
		} else { // 동명이인 없을 경우
			target = searchList.get(0);
		}
		
		// 정말 탈퇴를 할 것인지 확인
		System.out.print("정말 탈퇴 처리 하시겠습니까? (y/n) : ");
		
		// 입력 받은 문자열을 소문자로 만들어
		// 제일 앞 문자 하나만 반환 받기
		char check = sc.nextLine().toLowerCase().charAt(0);
		
		if(check == 'n') {
			System.out.print("\n### 탈퇴 취소 ###\n");
			return;
		}
		
		if(check != 'y') {
			System.out.println("\n### 잘못 입력 하셨습니다. 다시 시도 해주세요 ###\n");
			return;
		}
		
		// y 입력된 경우
		
		// 탈퇴 서비스 호출 후 결과 문자열 반환 받기
		String result = service.deleteMember(target);
		
		System.out.println(result);
	}
	
	
	
	/**
	 * 반복되는 동명이인 회원 선택을 별도 메서드로 추상화
	 * @param memberList
	 * @return 입력된 번호
	 */
	private int selectMemberNumber(List<Member> memberList) {
		
		// 일반 for문 
		/*for(int i = 0 ; i < memberList.size() ; i++) {
			System.out.printf("%d) %s (%s)\n",
					i+1, 
					memberList.get(i).getName(),
					memberList.get(i).getPhone());
		}*.
		
		/* 인덱스 번호를 지정할 숫자가 담긴 IntStream을 만들어서 반복 접근*/
		IntStream.range(0, memberList.size())
			.forEach(i -> {
				System.out.printf("%d) %s (%s)\n",
						i+1,  memberList.get(i).getName(), memberList.get(i).getPhone());
			});
		
		System.out.print("선택할 회원의 번호를 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		return input - 1; // 인덱스 번호 선택을 위해 -1
	}
	
	
}