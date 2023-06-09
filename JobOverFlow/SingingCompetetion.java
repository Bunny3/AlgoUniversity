import java.util.*;
import java.io.*;
public class SingingCompetetion {

  public static int predicate(long mid, long arr[], long m) {
    long noOfGroup = 0;
    for(int i=0;i<arr.length;i++) {
      noOfGroup+= (long)Math.ceil(arr[i]/(double)mid);
    }
    if(noOfGroup > m)
      return 0;
    else
      return 1;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NMm[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NMm[0]);
    int M = Integer.parseInt(NMm[1]);
    long m = Long.parseLong(NMm[2]);
    long ans[] = new long[N];
    int c=0;
    
    while(N>0) {
      String inparr[] = p.readLine().trim().split(" ");
      long arr[] = new long[M];
      long max_ =0;
      for(int i=0;i<M;i++) {
        arr[i] = Long.parseLong(inparr[i]);
        max_ = (long)Math.max(max_,arr[i]);
      }
      long l=0, r=max_;
      while(l+1<r) {
        long mid = l + (r-l)/2;
        if(predicate(mid,arr,m) == 0)
          l=mid;
        else
          r=mid;
      }
      ans[c++]=r;
      N--;
    }
    for(int j=0;j<ans.length;j++) {
      System.out.print(ans[j]+" ");
    }
  }
}
