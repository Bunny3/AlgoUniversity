import java.util.*;
import java.io.*;

public class Fibonacci {
  public static int Fibonacci(int N) {
    if(N==0)
    return 0;
    if(N==1 || N==2)
    return 1;
    return Fibonacci(N-1)+Fibonacci(N-2);
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    System.out.println(Fibonacci(N));
  }  
}
3
1 1 3
2 1 2
1 3 2