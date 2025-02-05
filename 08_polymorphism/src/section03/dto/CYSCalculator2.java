package section03.dto;


/** Calculator 인터페이스 구현체
 * - 모든 인터페이스 구현체는 같은 형태를 띄고 있다
 */
public class CYSCalculator2 implements Calculator{

   @Override
   public int plus(int a, int b) {
      return checkNum(a + b);
   }

   @Override
   public int minus(int a, int b) {
      
      return checkNum(a - b);
   }

   @Override
   public int multi(int a, int b) {
      
      return checkNum(a * b);
   }

   @Override
   public double div(int a, int b) {
      double result = (double)a / b;
      
      if(result > MAX_NUM) return MAX_NUM;
      if(result < MIN_NUM) return MIN_NUM;
      
      return result;
   }

   @Override
   public int mod(int a, int b) {
      
      return checkNum(a % b);
   }

   @Override
   public int pow(int a, int x) {
      
      // for문
      int result = 1;
      
      for(int i=0; i<x ; i++) {
         result *= a;
      }
      
      return result;
   }

   @Override
   public double areaOfCircle(double r) {
      double result = r * r * PI;
      
      if(result > MAX_NUM) return MAX_NUM;
      if(result < MIN_NUM) return MIN_NUM;
      
      return result;
   }
   
}
