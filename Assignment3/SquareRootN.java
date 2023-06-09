
import java.util.*;
import java.io.*;
public class SquareRootN {
  
  public static void main(String args[]) throws IOException {
    double N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Double.parseDouble(br.readLine());
    double L = 0, R = Math.max(N,1);
    int steps = 150;
    double mid;
    while(steps > 0) {
      mid = L + (R-L)/2;
      if(mid*mid <= N) 
        L = mid;
      else
        R = mid;
        steps--;
    }
    System.out.println(L);
  }
}
