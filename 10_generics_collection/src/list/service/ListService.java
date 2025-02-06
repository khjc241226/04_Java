package list.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListService {

	/* [Collection Framework]
	 * - Java에서 제공하는 자료구조 모음
	 * - java.util 패키지에 존재
	 * 
	 * [Collection Framework 특징]
	 * 1. 크기 제한 X
	 * 2. 추가, 수정, 삭제, 정렬 등의 기능 제공
	 * 3. 객체만 저장 가능!
	 *  - 기본 자료형은 Wrapper Class를 이용해서 저장
	 *  - 기본적으로 타입 제한은 없지만
	 *    개발의 편의성을 위해 한 가지 타입으로 제한
	 *    -> 제네릭스 이용
	 */
	
	/* [List(목록)]
	 * - 데이터를 순차적으로 나열한 자료구조(배열 비슷)
	 * 
	 * [List 특징]
	 * - 각 데이터를 index를 이용해 구분!!
	 *  == 순서가 있음
	 * 
	 * - index로 데이터 구분되기 때문에 중복 값 저장 가능
	 */
	
	public void test1() {
		
		/* List는 인터페이스!! -> 직접 객체 생성 불가
		 * --> 상속 받아 구현한 자식 클래스를 이용
		 * 
		 * [ArrayList]
		 * - 배열 처럼 생긴 List
		*/
		
		/* 제네릭을 이용한 타입 제한 X */
		ArrayList list = new ArrayList();
		
		
		/* boolean add(E e) : 리스트 객체에 요소E 추가 후 true 반환 */
		list.add(new Object());
		list.add("hello world");
		list.add(12345);
		
		
		/* E get(int index) : 리스트에서 index번째 요소E 반환 */
		list.get(0); // Object 타입 반환
		
		Object obj = list.get(1);
		if(obj instanceof String) { // 타입 검증
			System.out.println( ((String)obj).length() ); // 다운 캐스팅
		}
		
		/* ***불편하게 타입 검증, 다운 캐스팅을 하는 이유***
		 * - 여러 타입을 저장할 수 있다는 컬렉션의 특징이
		 *   오히려 독이됨
		 *  -> 제네릭스를 이용해 타입을 제한!
		 *    -> 한 타입만 있을 테니까 검증, 다운캐스팅 X
		 * */
	}
	
	
	/* 제네릭스를 적용하여 타입 제한 O
	 */
	public void test2() {
		
		ArrayList<String> menuList = new ArrayList<String>();
		
		// add() 확인
		//menuList.add(123); // 오류 발생(타입 불일치)
		
		menuList.add("김치찌개");
		menuList.add("족발");
		menuList.add("보쌈");
		menuList.add("치킨");
		menuList.add("피자");
		menuList.add("마라탕");
		menuList.add("떡볶이");
		
		
		/* int size() : 저장된 객체의 개수 반환 */
		for(int i=0 ; i < menuList.size() ; i++) {
			String menu = menuList.get(i); // i 번째 인덱스 값 얻어오기
			// -> 타입 검증X, 다운캐스팅 X
			System.out.println(menu);
		}
		
		System.out.println("--------------------------");
		
		// 향상된 for문 가능
		for(String menu : menuList) {
			System.out.println(menu);
		}
		
		
		System.out.println("------------------------------");
		
		/* void add(int index, E e) : index 번째에 e 추가(중간 삽입) */
		menuList.add(1, "갈비탕");
		
		/* String toString() : 리스트에 저장된 값을 하나의 문자열로 반환*/
		System.out.println(menuList.toString());
		
		
		/* E set(int index, E e)
		 * - index 번째 요소에 전달 받은 e를 세팅(수정)
		 * - 결과로 이전에 존재하던 요소(E)를 반환
		 * */
		
		String before = menuList.set(2, "불족발");
		System.out.println("-------------------------------");
		System.out.println(before + "이/가 수정 되었습니다");
		System.out.println(menuList);
		
		/* boolean contains(E e)
		 * - 같은 객체가 있는지 확인 (있으면 true, 없으면 false)
		 * - 비교하려는 객체가 equals()를 오버라이딩 해야함
		 *  */
		System.out.println("보쌈   : " + menuList.contains("보쌈"));
		System.out.println("막국수 : " + menuList.contains("막국수"));
		
		/* int indexOf(E e)
		 * - 같은 객체가 있는 index 번호를 반환
		 * - 없으면 -1 반환
		 * */
		System.out.println("치킨 인덱스   : " + menuList.indexOf("치킨"));
		System.out.println("햄버거 인덱스 : " + menuList.indexOf("햄버거"));
		
		/* E remove(int index)
		 * - index 번째 요소 삭제
		 * - 삭제된 요소(E) 반환됨
		 * - 중간 요소가 삭제되면 알아서 빈 공간을 채움(앞으로 당기기)
		 * */
		System.out.println("-------------------------------");
		System.out.println(menuList.remove(1) + " 제거");
		System.out.println(menuList);
	}
	
	/* 컬렉션 객체의 참조 변수는 
	 * 부모 타입(List 인터페이스)으로 설정하면 좋은 이유
	 * 
	 * -> 프로그래밍 과정에서 미처 생각하지 못한
	 *   비효율적인 요소를 쉽게 개선하기 위해서
	 *   
	 * 1. ArrayList
	 *  - 배열 처럼 요소가 붙어있음
	 *  - 장점 : 검색 속도가 빠름
	 *  - 단점 : 중간에 추가, 수정, 삭제가 비효율적
	 * 
	 * 2. LinkedList
	 *  - 요소를 서로 참조하는 형식으로 연결되어있음
	 *  - 장점 : 중간에 추가, 수정, 삭제가 효율적
	 *  - 단점 : 검색 속도가 느림
	 */
	public void test3() {
		
		// 부모 타입 참조 변수 List
//		List<Integer> list = new ArrayList<Integer>();
		
		// 중간 추가/수정/삭제가 빠른 LinkedList로 교체
		List<Integer> list = new LinkedList<Integer>(); 
		
		
		
		Random random = new Random(); // 난수 생성 객체
		
		// long System.currentTimeMillis()
		// - 1970년 1월 1일 09:00:00.000 (대한민국 기준)
		// 위 시간을 기준으로 현재 얼마만큼 시간이 지났는지
		// ms(1/1000 초) 단위로 계산해서 반환
		
		long start = System.currentTimeMillis();
		
//		try {
//			Thread.sleep(1000); // 현재 스레드를 1000ms 동안 멈춤
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		list.add(random.nextInt(Integer.MAX_VALUE)); // 0번
		list.add(random.nextInt(Integer.MAX_VALUE)); // 1번
		
		for(int i=0 ; i<200000 ; i++) { // 10만 바퀴
			// 1번 인덱스에 난수 삽입(중간 삽입)
			list.add(1, random.nextInt(Integer.MAX_VALUE));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("걸린 시간 : " + (end - start) + "ms" );
		
		
	}
	
	
	
}




