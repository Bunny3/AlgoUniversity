import java.util.*;
import java.io.*;
public class DomAndParts {
  public static int predicate(long mid, int N,long arr[], int P) {
    long noOfPair = 0;
    int freq[] = new int[N];
    Arrays.fill(freq,0);
    for(int i=1;i<N;i++) {
      if((arr[i]-arr[i-1])<=mid) {
        freq[i] = 1;
        freq[i-1] =1;
      }
    }

    // for(int i=0;i<N;i++) {
    //   System.out.print(freq[i] + " ");
    // }
    // System.out.println();
    int count = 0;
    for(int i=0;i<N;i++) {

      if(freq[i]==1) {
        count++;
      } else {
        noOfPair+= count/2;
        count = 0;
      }
    }
    if(count>0)
      noOfPair+= count/2;
      // System.out.println(noOfPair);
    if(noOfPair>=P)
      return 1;
    else 
      return 0;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int T=Integer.parseInt(p.readLine());
    for(int i=0;i<T;i++) {
      String NP[] = p.readLine().trim().split(" ");
      int N = Integer.parseInt(NP[0]);
      int P = Integer.parseInt(NP[1]);
      String inpArray[] = p.readLine().trim().split(" ");
      long arr[] = new long[N];
      for(int j=0;j<N;j++) {
        arr[j] = Long.parseLong(inpArray[j]);
      }
      Arrays.sort(arr);
      long l=-1,r=(long)1e9;

      while(l+1<r) {
        long mid = l + (r-l)/2;
        if(predicate(mid,N,arr,P)==0) 
          l=mid;
        else
          r=mid;
      }
      System.out.println(r);
    }
  }
}
