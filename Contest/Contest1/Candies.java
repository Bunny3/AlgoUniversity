import java.io.*;
import java.util.*;
public class Candies {

  public static int predicate(long mid, long arr[], int M) {
    int noChild = 0;
    long sum=0;
    
    for(int i=0;i<arr.length;i++) {
      sum+=arr[i];
      if(sum>mid) {
        noChild++;
        sum=arr[i];
      }
    }
    if(sum>0)
      noChild+=(int)Math.ceil(sum/mid);
    if(noChild>=M)
      return 0;
    else
      return 1;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N,M;
    String NM[] = p.readLine().trim().split(" ");
    N = Integer.parseInt(NM[0]);
    M =Integer.parseInt(NM[1]);

    String narr[] = p.readLine().trim().split(" ");
    long arr[] = new long[N];
    long sum=0;
    
    for(int i=0;i<N;i++) {
      arr[i] = Long.parseLong(narr[i]);
      sum+=arr[i];
    }
    // Arrays.sort(arr);
    long l=-1, r= sum+5;
    while(l+1<r) {
      long mid = l + (r-l)/2;
      if(predicate(mid,arr,M) == 0 )
        l=mid;
      else
        r=mid;
    }
    if(N<M)
    System.out.println(-1);
    else if(r==0)
    System.out.println(-1);
    else 
    System.out.println(r);
    
    
  }
}
