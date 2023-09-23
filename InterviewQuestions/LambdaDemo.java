@FunctionalInterface
interface A {
  int add(int i, int j);
}
public class LambdaDemo {
  public static void main(String args[]) {

    A obj = (i, j) -> i+j;
    int result = obj.add(5,4);
    System.out.println(result);
  }
}
