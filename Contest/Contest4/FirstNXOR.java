import java.io.*;
import java.util.*;
public class FirstNXOR {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    for(int i=0;i<N;i++) {
      long n =Long.parseLong(input.readLine());
      long mod = n%4;
      if(mod == 0) {
        System.out.println(n);
      } else if(mod == 1) {
        System.out.println(1);
      } else if(mod == 2) {
        System.out.println(n+1);
      } else if(mod == 3) {
        System.out.println(0);
      }
    }
  }
}
