package section04;

/* 인터페이스 
 * - 상속 받은 클래스간의 접점을 만듦(비슷한 형태를 지니게 만듦)
 * - 상수형 필드(public static final)만 작성 가능
 * - 추상 메서드(public abstract) 또는 default 메서드만 작성 가능
 * */
public interface Animal {

	// 추상 메서드
	// - 메서드 정의 부분이 없는 미완성 메서드
	// - 상속 받은 자식이 무조건 재정의 해야함(오버라이딩 강제화)
	public abstract void move(); 
	
	// public abstract 생략 가능
	void eat();
}




