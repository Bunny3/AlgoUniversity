import java.util.*;
import java.io.*;
public class MaxAND {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    long arr[] = Arrays.stream(p.readLine().trim().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray();

    
    int res = 0;

    for(int i=31;i>=0;i--) {
      int cval = res | (1<<i);
      int count=0;
      for(int j=0;j<N;j++) {
        if((arr[j] & cval) == cval) {
          count++;
        }
      }
      if(count>=2) {
        res = res | (1<<i);
      }
    }
    System.out.println(res);
  }
}
