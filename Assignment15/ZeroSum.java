import java.util.*;
import java.io.*;

public class ZeroSum {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(p.readLine());
    long arr[] = Arrays.stream(p.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
    long prefixArray[] = new long[n];
    HashMap<Long,Integer> mp= new HashMap<Long,Integer>();
    prefixArray[0] = arr[0];
    for(int i=1;i<n;i++) {
      prefixArray[i] = arr[i]+prefixArray[i-1];
    }
    boolean flag = false;
    for(int i=0;i<prefixArray.length;i++) {
      if(mp.containsKey(prefixArray[i]))
      {
        flag = true;
        break;
      }
      mp.put(prefixArray[i], 1);
    }
    if(flag == true) {
      System.out.println("YES");
     } else {
       System.out.println("NO");
     }

  }
}
