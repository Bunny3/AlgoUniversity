import java.util.*;
import java.io.*;

public class Corona {

  public static int predicate(long mid, int N,long arr[][], int M) {
      long maxNoOfPeople = (long)((arr[0][1]-arr[0][0])/mid) +1;
      long lasti = arr[0][0]+(maxNoOfPeople-1)/mid;
      for(int i=1;i<M;i++) {
        long si = (long)Math.max(lasti+mid, arr[i][0]);
        if(arr[i][1]>=si) {
          long ppl = ((arr[i][1]-si)/mid) + 1;
          lasti = si + ((ppl-1)*mid);
          maxNoOfPeople +=ppl;
        }
      }
    if(maxNoOfPeople >=N)
      return 0;
    else
      return 1;
  }

  public static void main(String args[]) throws IOException {
    int N,M;
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nm[] = p.readLine().trim().split(" ");
    N = Integer.parseInt(nm[0]);
    M = Integer.parseInt(nm[1]);
    long arr[][] = new long[M][2];

    for(int i=0;i<M;i++) {
      String LR[] = p.readLine().trim().split(" ");
      arr[i][0] = Long.parseLong(LR[0]);
      arr[i][1] = Long.parseLong(LR[1]);
    }
     Arrays.sort(arr,((a,b)->(int)(a[0]-b[0])));
    long l = 0, r=(long)1e18;
    while(l+1 < r) {
      long mid = l + ((r-l)/2);
      if(predicate(mid,N,arr,M) == 0) 
        l = mid;
      else
        r = mid;
    }
    System.out.println(l);
  }
}