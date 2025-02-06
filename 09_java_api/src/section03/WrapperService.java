package section03;

public class WrapperService {
	/* Wrapper class
	 * 
	 * - wrap : 감싸다, 포장하다
	 * 
	 * - 기본 자료형을 감싸서 객체 형태로 바꿀 수 있는 클래스
	 * 
	 * - 객체만 취급하는 상황에 대응하기 위하여
	 *   기본 자료형 -> 객체로 변경하는 방법 제공
	 *   
	 *   
	 *               --> Boxing
	 *  Unboxing    <--
	 *  
	 *  기본 자료형 <--> Wrapper Class
	 *  boolean     <--> Boolean
	 *  byte        <--> Byte
	 *  short       <--> Short
	 *  int         <--> Integer
	 *  long        <--> Long
	 *  float       <--> Float
	 *  double      <--> Double
	 *  char        <--> Character
	 * 
	 * 
	 * *** 중요 ***
	 * - Java에서는 Boxing, Unboxing을 자동으로
	 *   수행되도록 구현되어 있음  (jdk 11부터 강제)
	 *   
	 *   -> Auto Boxing, Auto Unboxing
	 * 
	 * - Wrapper Class도 객체이기 때문에
	 *   추가적인 필드, 메서드를 제공함
	 */
	
	public void printValue(Object obj) {
		// Wrapper Class(Integer) 전달 받았지만
		// Object로 업캐스팅 상태 -> 사용 시 다운 캐스팅 필요
		
		Integer wrap = (Integer)obj; // 다운 캐스팅
		int num = wrap.intValue(); // Integer -> int Unboxing
		System.out.println("값 출력 : " + num); 
	}
	
	public void test1() {
		/* int -> Integer Boxing */
		int num1 = 100;
		
		// deprecated : 사용되지 않음
		// -> 컴파일 오류는 나지 않지만
		//    버전이 올라가면 삭제될 수도 있으니 쓰지 말아라
		Integer wrap1 = new Integer(num1);
		
		// 기본 자료형 int -> Wrapper Class 객체 Integer로 변경 후
		// Object를 전달 받는(모든 객체를 전달 받는) 메서드
		// printValue의 전달 인자로 작성
		printValue(wrap1);
	}
	
	
	/* Auto Unboxing 적용*/
	public void printValue2(Object obj) {
		int num = (int)obj; // Object -> Integer -> int
		System.out.println("Auto Unboxing 후 값 출력 : " + num);
		
		Integer wrap = new Integer(300);
		int num2 = wrap; // (Integer -> int) Auto Unboxing
	}
	
	/* Auto Boxing 적용*/
	public void test2() {
		int num = 200;
		printValue2(num); // 자동으로 Integer로 포장됨!
	}
	
	/* Wrapper Class 제공 필드/기능
	 * - 대부분의 필드/기능이 static으로 작성되어 있음
	 * 
	 * * static 키워드
	 *  - 프로그램 실행 시 static 영역에
	 *    클래스명.필드명 / 클래스명.메서드명() 형태로 할당됨
	 *   -> 별도 객체 생성 없이 사용 가능!
	 * */
	public void test3() {
		
		// 정수형, 실수형 공통 필드
		System.out.println("int는 몇 바이트? " +  Integer.BYTES);
		System.out.println("int는 몇 비트? "   +  Integer.SIZE);
		System.out.println("int 최대 값 : " + Integer.MAX_VALUE);
		System.out.println("int 최소 값 : " + Integer.MIN_VALUE);
		
		System.out.println("-------------------------------------");
		
		System.out.println("double은 몇 바이트? " +  Double.BYTES);
		System.out.println("double은 몇 비트? "   +  Double.SIZE);
		System.out.println("double 최대 값 : " + Double.MAX_VALUE);
		System.out.println("double 최소 값 : " + Double.MIN_VALUE);
		
		
		System.out.println("-------------------------------------");
		
		// 실수형만 사용 가능한 필드
		System.out.println(Double.NaN); // 숫자 아님
		System.out.println(Double.POSITIVE_INFINITY); // + 무한
		System.out.println(Double.NEGATIVE_INFINITY); // - 무한
		
		
		System.out.println("----------------------------");
		
		System.out.println("[String -> 기본 자료형으로 변환]");
		
		/* parsing(파싱) : 구문 분석
		 *  -> 분석해서 알맞은 형태로 변환
		 * */
		
		byte b = Byte.parseByte("100"); 
		int  i = Integer.parseInt("123456789");
		long l = Long.parseLong("123456789012345");
		double d = Double.parseDouble("3.1415926538");
		boolean bool = Boolean.parseBoolean("true");
		
		// 단, char는 parsing 없음!!!
		System.out.println(b);
		System.out.println(i);
		System.out.println(l);
		System.out.println(d);
		System.out.println(bool);
		
		System.out.println("--------------------------------");
		
		System.out.println("[기본 자료형 -> String]");
		
		// 방법 1) 기본 자료형 + ""(String) = String
		int num1 = 500;
		//String s1 = num1; // 오류(왜? 자료형 불일치)
		String s1 = num1 + ""; // 권장 X (가끔은 괜찮음)
		
		// 방법 2) Wrapper Class의 valueOf() / toString() 이용
		
		// Integer.valueOf(int값)  ==  new Integer(int값)
		// -> int값에 필드에 세팅된 Integer 객체를 반환
		int num2 = 700;
		String s2 = Integer.valueOf(num2).toString();
		
		// - Integer.toString(int 값) 이용
		String s3 = Integer.toString(num2);
		
		System.out.println("s2 : " + s2);
		System.out.println(s2.getClass());
		
		System.out.println("s3 : " + s3);
		System.out.println(s3.getClass());
		
	}
	
	
	
	
	
}
