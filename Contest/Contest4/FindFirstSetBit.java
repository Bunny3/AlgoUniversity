import java.util.*;
import java.io.*;

public class FindFirstSetBit {
  public static int getFirstset(int n) {
    return (int)((Math.log10(n & -n))/Math.log10(2));
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());
    while(T>0) {
      int n = Integer.parseInt(input.readLine());
      int ans = getFirstset(n);
      if(ans == Integer.MIN_VALUE) {
        ans = -1;
      }
      System.out.println(ans);
      T--;
    }
  }
}
