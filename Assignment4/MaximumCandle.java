import java.util.*;
import java.io.*;

public class MaximumCandle {
  static int predicate(long m, int n) {
    if((m*(m+1))/2<=n) 
      return 0;
    else
      return 1;
  }
  public static void main(String args[]) throws IOException{
    int n;
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(p.readLine());

    long  l = 0, r = 2*(int)Math.pow(10,9);
    while(l+1<r) {
      long mid = l + (r-l)/2;

      if(predicate(mid, n) == 0 ) {
        l = mid;
      } else {
        r = mid;
      }
    }
    System.out.println(l);
  }
}
