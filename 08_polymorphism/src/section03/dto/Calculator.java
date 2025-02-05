package section03.dto;

/* [인터페이스(interface)]
 * 
 * - 뜻 : 접점
 * 
 * ex) UI(User Interface) : 화면
 *    -> 화면을 통해서 프로그램과 사용자가 접촉함
 *       (화면이 접점의 역할)
 * 
 * - 자바(객체 지향 프로그래밍)에서는
 *  객체 간의 접점을 만드는 용도로 사용
 * 
 * 
 * - 효과
 * 1) 클래스/객체 간의 접점을 만들 수 있다
 * 2) 극한의 추상화를 통해서 유연한 코딩이 가능하다
 * 3) 상속 받은 자식 클래스가 모두 같은 형태를 갖는다
 * 
 * [참고]
 * 대부분의 인터페이스를 상속받은 클래스는
 * 인터페이스에서 제공하는 메서드만 오버라이딩 하고
 * 별도의 필드/메서드를 작성하지 않는다
 * (약속, 규약)
 *  -> 왜? 언제든지 동일한 코드로 실행될 수 있게 하려고
 * 
 * 
 * - 인터페이스 작성법 ( []는 생략 가능 )
 * 
 * 1) 상수형 필드만 작성 가능
 *  -> [public static final] 자료형 변수명;
 *  
 * 2) 기본적으로 모든 메서드는 추상 메서드
 *  -> [public abstract] 반환형 메서드명();
 *  
 * 3) default 메서드 작성 가능 (오버라이딩 가능)
 *  -> default void 매서드명(){}
 *  
 *  
 * - 인터페이스 사용법
 *  1) 해당 인터페이스를 상속 받을 클래스에
 *     implements(구현하다) 키워드를 작성
 *     
 *    public class 클래스명 implements 인터페이스명{}
 *    
 *  2) 상속 받은 추상 메서드를 모두 오버라이딩
 *  
 *  3) 상속 받은 클래스를 객체로 만들어서 사용
 *  
 *	-> 사용 방법은 추상 클래스와 동일  
 *    1. 인터페이스는 객체 생성 불가
 *    2. 부모 타입 참조 변수로는 사용 가능
 */

/** Calculator 인터페이스
 * -> 객체 생성 용도 X, 클래스/객체 간의 접점 용도 O
 */
public interface Calculator {

	/* 필드는 public static final만 작성 가능!! */
	public static final int MAX_NUM = 1_000_000_000; // 10억
	
	// public static final 생략 가능 
	// -> 컴파일러가 자동 추가해준다!!
	int MIN_NUM = -1_000_000_000; // 10억
	
	double PI = 3.141592; // 원주율
	
	
	/* 기본적으로 추상 메서드만 작성 가능!
	 * -> 추상 메서드는 상속 받은 자식 클래스에서 
	 *   오버라이딩이 강제됨
	 *  */
	
	/**
	 * 두 수의 합을 반환
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	public abstract int plus(int a, int b);
	
	
	// public abstract 생략 가능
	/**
	 * 두 수의 차를 반환
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int minus(int a, int b);
	
	/**
	 * 두 수의 곱을 반환
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int multi(int a, int b);
	
	/**
	 * 두 수를 나눈 몫을 반환
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	double div(int a, int b);
	
	
	/**
	 * 두 수를 나눈 나머지를 반환
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int mod(int a, int b);
	
	
	/**
	 * a를 x만큼 거듭 제곱한 결과를 반환
	 * 단, 결과는 최대/최소 값을 넘을 수 없음
	 * @param a
	 * @param x
	 * @return 결과
	 */
	 int pow(int a, int x);
	
	 /**
	  * 원의 넓이를 반환
	  * 단, 결과는 최대/최소 값을 넘을 수 없음
	  * @param r
	  * @return 결과
	  */
	 double areaOfCircle(double r);
	 
	 
	 /* default 메서드 */
	 
	 /**
	  * 전달 받은 num이 최대/최소를 초과하는지 확인
	  * - 최대값 초과 시 MAX_NUM 반환
	  * - 최소값 미만 시 MIN_NUM 반환
	  * - 범위 내 숫자는 그냥 반환
	  * @param num
	  * @return 결과
	  */
	 default int checkNum(int num) {
		 if(num > MAX_NUM) return MAX_NUM;
		 if(num < MIN_NUM) return MIN_NUM;
		 return num;
	 }
}






