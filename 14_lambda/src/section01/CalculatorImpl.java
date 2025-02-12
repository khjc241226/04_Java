package section01;

/* 일반적인 인터페이스 사용 방법 -> 구현체 만들기 */
public class CalculatorImpl implements Calculator{

	@Override
	public int sumTwoNumber(int a, int b) {
		return a + b;
	}
}



