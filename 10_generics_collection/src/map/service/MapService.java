package map.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapService {
	/* [Map]
	 * - 특정 키워드(Key)를 입력하면
	 *   해당되는 상세한 값(Value)를 얻어오거나 세팅하는 객체
	 *   
	 * - Key : Value 한 쌍으로 데이터를 저장
	 *  -> 한 쌍을 묶어서 "Entry"라고 부름
	 *  
	 * - Key (키워드 역할 == 변수명) 
	 *  1) 중복 X (중복된 Key 입력 시 Value가 덮어쓰기 됨)
	 *    -> Key 객체가 반드시 equals(), hashCode() 오버라이딩 되야함
	 * 
	 *  2) 순서 유지 X(단, LinkedHashMap 제외)
	 *  
	 *  --> Key의 특징은 Set과 유사함!!!
	 *    --> Map.keySet() / Map.EntrySet() 제공
	 * 		
	 * 
	 * - Value (키워드에 해당하는 값 == 변수에 저장된 값)
	 *  -> Key를 이용해 모든 Value가 구분됨 
	 *    == Value 끼리는 중복 허용
	 */
	
	public void test1() {
		//     K  ,   V (Key와 Value의 타입을 모두 제한)
		Map<String, String> map = new HashMap<String, String>();
		
		/* V put(K k, V v) : Map에 K:V 한 쌍을 추가
		 * - 추가 성공 시 Value 반환
		 *  -> 중복되는 Key가 없으면 null 반환
		 *  -> 중복되는 key가 있어 덮어쓰기하면 이전 Value 반환
		 *  */
		
		System.out.println(map.put("아침", "달걀 후라이")); // null
		System.out.println(map.put("점심", "제육볶음"));    // null
		System.out.println(map.put("저녁", "삼겹살"));      // null
		System.out.println(map.put("저녁", "라면"));        // 삼겹살
		System.out.println(map); // map 전체 확인

		
		System.out.println("-------------------------------");
		
		/* V get(K k) : Key 해당하는 Value 반환, 없음 null */
		System.out.println("아침 : " + map.get("아침"));
		System.out.println("점심 : " + map.get("점심"));
		System.out.println("저녁 : " + map.get("저녁"));
		System.out.println("야식 : " + map.get("야식")); // null
		
		/* int size() : 저장된 K:V 쌍의 개수 */
		System.out.println("저장된 데이터 수 : " + map.size());
		
		
		/* V remove(K k) : K가 일치하는 K:V 제거, 제거된 V 반환  
		 * - 일치하는 K 없으면 null 반환
		 * */
		System.out.println("--------------------------------");
		System.out.println(map.remove("아침") + " 제거");
		System.out.println(map.remove("야식") + " 제거");
		
		/* void clear() : 모든 데이터 제거 */
		/* boolean isEmpty() : Map에 저장된 데이터 없음 true*/
		map.clear();
		if(map.isEmpty()) {
			System.out.println("모두 삭제됨");
			System.out.println(map);
		}
	}
	
	/* Map에 저장된 모든 요소 순차 접근하기 
	 * 
	 * - Set<K> Map.keySet() : Key만 묶어서 Set 형태로 반환
	 * */
	public void test2() {
		
		// K == Stirng
		// V == Object -> Object를 상속 받은 모든 객체 가능
		//      단, 업캐스팅 상태이기 때문에
		//      상속 받은 자식의 기능을 사용하고 싶으면
		//      다운 캐스팅 또는 동적 바인딩 이용
		Map<String, Object> student = new HashMap<String, Object>();
		
		student.put("name", "홍길동"); // String
		student.put("grade", 3);       // Integer(Auto Boxing)
		student.put("gender", '남');   // Character(Auto Boxing)
		student.put("avg", 80.4);      // Double(Auto Boxing)
		
		// student의 avg 변경
		student.put("avg", 90.4);      // 덮어쓰기(세팅하기)
		
		// student의 avg 얻어오기
		double score = (Double)student.get("avg"); // 얻어오기
		
		/* Map은 유사 DTO의 역할 수행 가능!! */
		
		// ----------------------------------------------
		
		// 1) Set<K> Map.keySet() : K만 모아둔 Set 반환
		Set<String> keys = student.keySet();
		
		// 반복자(Iterator) 이용
		Iterator<String> it = keys.iterator();
	
		while(it.hasNext()) { // 다음 접근할 값이 있다면 반복
			String k = it.next(); 
			System.out.printf("Key : %s , Value : %s\n",
												k, student.get(k));
		}
		
		System.out.println("---------------------------");
		
		/* Map.Entry<K,V> 
		 * - Map의 내부 정적 인터페이스
		 * - 구현체는 K, V를 한 쌍으로 묶어서 관리
		 * 
		 * 
		 * Map.Entry<K,V> Map.entrySet()
		 * - K:V를 모아둔 집합(Set)을 반환하는 메서드
		 */
		
		Set<Map.Entry<String, Object>> set = student.entrySet();
		
		// K Map.Entry.getKey()   : Entry의 K 반환
		// V Map.Entry.getValue() : Entry의 V 반환
		
		// 향상된 for문
		for(Map.Entry<String, Object> entry : set) {
			
			System.out.printf("%s : %s\n",
					entry.getKey(), entry.getValue());
		}
		
	}
	
	
	
	
}
