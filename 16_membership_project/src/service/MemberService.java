package service;

import java.io.IOException;
import java.util.List;

import dto.Member;

// Service : 기능(비즈니스 로직) 제공 클래스/객체
// - 프로그램의 핵심 기능 작성
public interface MemberService {

    // 인터페이스의 메서드
    // - public abstract method (중요)
    // - default method


    /**
     * 전달 받은 이름, 휴대폰 번호를 이용해서 회원 추가
     * 단, 목록에 있는 회원 중 같은 번호의 회원이 존재하면
     * false 반환 / 없으면 가입 후 true 반환
     * @param name
     * @param phone
     * @return true / false(중복된 번호)
     */
    public abstract boolean addMember(String name, String phone) throws IOException;


    /**
     * 전체 회원 목록 조회
     * @return memberList
     */
    public abstract List<Member> getMemberList();


    /**
     * searchName과 같은 이름을 지닌 회원 조회
     * - 동명이인이 존재하면 모두 조회
     * @param searchName
     * @return searchList (저장된 요소 0개 이상)
     */
    List<Member> selectName(String searchName);


    /**
     * 전달 받은 회원의 금액 누적하기
     * @param target
     * @param acc
     * @return 결과 문자열
     * @throws IOException
     */
    String updateAmount(Member target, int acc) throws IOException;


    /**
     * 회원 정보(전화번호) 수정
     * @param target
     * @param phone
     * @return 결과 문자열
     * @throws IOException
     */
    String updateMember(Member target, String phone)
            throws IOException;


    /**
     * 회원 탈퇴
     * @param target
     * @return 결과 문자열
     * @throws IOException
     */
    String deleteMember(Member target) throws IOException;



}