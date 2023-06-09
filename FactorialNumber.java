import java.util.*;
public class FactorialNumber {

  public static long factorial(int number) {
    long f = number;
    while(--number > 0) {
      f = f*number;
    }
     return f==0 ? 1 : f;
  }
  public static void main(String args[]) {
    int T;
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    int  number;
    while(T-- > 0) {
      number = sc.nextInt();
      System.out.println(factorial(number));
    }
  }
}
