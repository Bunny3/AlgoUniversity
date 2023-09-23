import java.util.*;
import java.io.*;
import java.nio.Buffer;
public class Consecutiveness {
  public static void main(String args[]) throws IOException {
    BufferedReader p =new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(p.readLine());
    // long arr[] = Arrays.stream(p.readLine().trim().split(" ")).mapToLong(s->Integer.parseInt(s)).toArray();
    // System.out.println("Debugging N= "+n);
    for(int k=0;k<n;k++) {
      int num = Integer.parseInt(p.readLine());
      // System.out.println("Debugging num value "+num);
      int count = 0;
      while(num!=0) {
        num = (num & (num<<1));
        count++;
      }
      System.out.println(count);
    }
  }
}
