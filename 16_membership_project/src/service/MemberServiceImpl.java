package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};


    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl() 
    		throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
    }

    
    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    @Override
    public boolean addMember(String name, String phone) throws IOException {

    	// 1) 회원 목록을 얻어와 휴대폰 번호 중복 검사
  		List<Member> memberList = dao.getMemberList();  
  		
  		/* 향상된 for문 사용 */
//  		for(Member member : memberList) {
//  			// 휴대폰 번호가 같은 경우 == 중복인 경우
//  			if( phone.equals(member.getPhone()) ) {
//  				return false;
//  			}
//  		}
  		
  		/* 스트림 사용 */
  		// memberList에서 같은 번호를 가진 회원을 필터링해서 개수 카운트
  		// -> 같은 번호가 없다면 count는 0이 되어야함
  		long count = memberList.stream()
  				.filter(member -> member.getPhone().equals(phone))
  				.count();
  		
  		if(count > 0) return false;
  		
  		
  		
  		// 2) 중복이 아닌 경우
  		//    입력 받은 정보를 이용해 Member 객체를 생성하고
  		//    DAO에 전달하여 파일에 저장
  		Member member = new Member(name, phone, 0, Member.COMMON);
  		
  		// DAO 메서드 호출 후 결과 반환 받기
  		return dao.addMember(member);
    }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {
    	
    	// dao에서 반환 받은 memberList를 그대로 view로 리턴
      return dao.getMemberList();
    }


    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {
    	// DAO를 이용해서 회원 전체 목록 조회
  		List<Member> memberList = dao.getMemberList();
  		
  		// memberList에 저장된 요소(회원) 중 
  		// 이름이 같은 회원을 찾아서 
  		// 검색 결과를 저장할 별도 List에 추가
  	
  		/* 향상된 for문 */
//  		List<Member> searchList = new ArrayList<Member>();
//  		for(Member member : memberList) {
//  			if(member.getName().equals(searchName)) {
//  				searchList.add(member);
//  			}
//  		}
  		
  		/* 스트림 */
  		List<Member> searchList = 
  				memberList.stream()
  				.filter(member -> member.getName().equals(searchName))
  				.collect(Collectors.toList()); // 스트림 -> List 변경
  		
  		return searchList; // 검색 결과 반환
    }


    // 금액 누적
    @Override
    public String updateAmount(Member target, int acc) throws IOException {

    	// 이전 금액 백업 -> 출력할 문자열 만들 때 사용
  		int before = target.getAmount();
  		
  		// 대상 회원의 금액 누적하기
  		target.setAmount(before + acc);  
  		
  		// 등급 판별
//  		  일반   : 0 ~ 100,000 미만
//  		  골드   : 100,000 이상 ~ 1,000,000 미만
//  		  다이아 : 1,000,000 이상
  		
  		
  		int grade = 0; // 판별된 등급 저장할 변수
  		
  		int currentAmount = target.getAmount();
  		if(currentAmount < 100000)  	 grade = Member.COMMON;
  		else if(currentAmount < 1000000) grade = Member.GOLD;
  		else 							 grade = Member.DIAMOND;
  			
  		// 신짱구 회원님의 누적 금액
  		// 2000 -> 100000
  		// * 골드 * 등급으로 변경 되셨습니다
  		StringBuilder sb = new StringBuilder();
  		sb.append(target.getName());
  		sb.append(" 회원님의 누적 금액\n");
  		sb.append(before + " -> " + currentAmount);
  		
  		// 이전 회원의 등급과
  		// 새로 판별된 등급이 다른 경우
  		if(target.getGrade() != grade) {
  			String str 
  				= String.format("\n* %s * 등급으로 변경 되셨습니다", gradeArr[grade]);
  			sb.append(str);
  			
  			// 회원의 등급을 판별된 등급(grade)으로 변경
  			target.setGrade(grade);
  		}
  		
  		// 변경된 데이터를 저장하는 DAO 메서드 호출
  		dao.saveFile();
  		
  		return sb.toString(); // 결과 문자열 반환
      //ex)
      // 2000 -> 100000
      // * 골드 * 등급으로 변경 되셨습니다
    }


    //회원 정보(전화번호) 수정
    @Override
    public String updateMember(Member target, String phone) throws IOException {
    	// 이전 번호 저장
  		String before = target.getPhone();
  		
  		// 대상의 전화번호를 입력 받은 새 번호로 변경
  		target.setPhone(phone);
  		
  		// 출력 문자열 만들기
  		StringBuilder sb = new StringBuilder();
  		
  		//홍길동님의 전화번호가 변경 되었습니다
  	    //01012341234 -> 01044445555
  		sb.append(target.getName());
  		sb.append("님의 전화번호가 변경 되었습니다\n");
  		sb.append(before + " -> " + phone);
  		
  		dao.saveFile();
  		
  		return sb.toString(); // 결과 문자열 반환
        
        // ex)
        // 홍길동님의 전화번호가 변경 되었습니다
        // 01012341234 -> 01044445555
    }


    // 회원 탈퇴
    @Override
    public String deleteMember(Member target) throws IOException {
    	// 회원 목록 얻어오기
  		List<Member> memberList = dao.getMemberList();
  		
  		// 회원 목록에서 target 제거(remove)하기
  		
  		// boolean List.remove(Object obj)
  		// -> List에 저장된 요소 중 obj와 같은 요소 제거
  		// * 조건 : 요소 객체가 
  		//          equals() 오버라이딩 되어 있어야함
  		boolean result = memberList.remove(target);
  		
  		if(result) dao.saveFile(); // 탈퇴 데이터 저장
  		
  		return target.getName() + " 회원이 탈퇴 처리 되었습니다"; // // 결과 문자열 반환
      // ex)
      // "홍길동 회원이 탈퇴 처리 되었습니다"
    }

}