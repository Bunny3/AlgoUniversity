import java.util.*;
import java.io.*;


public class RangeQueries {
  public static int binarySearch(int arr[], int target) {
    int L = -1;
    int R = arr.length;
    while(L+1<R) {
      int mid = L + (R-L)/2;
      if(arr[mid] <= target) {
        L = mid;
      } else {
        R = mid;
      }
    }
    if(L == -1) {
      return 0;
    } else {
      return L+1;
    }
  } 
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N,Q;
    String nq[] = br.readLine().trim().split(" ");
    N = Integer.parseInt(nq[0]);
    Q = Integer.parseInt(nq[1]);

    String strsarr[] = br.readLine().trim().split(" ");
    int arr[] = new int[N];

    for(int i=0;i<N;i++) { 
      arr[i] = Integer.parseInt(strsarr[i]);
    }
    Arrays.sort(arr);
    // for(int i=0;i<N;i++) {
    //   System.out.print(arr[i] + " ");
    // }
    for(int i=0;i<Q;i++) {
      String query[] = br.readLine().trim().split(" ");
      int begin = Integer.parseInt(query[0]);
      int end = Integer.parseInt(query[1]);
      int beginCount = binarySearch(arr, begin-1);
      // System.out.println(beginCount);
      int endCount = binarySearch(arr, end);
      // System.out.println(endCount);
      System.out.print((endCount - beginCount)+" ");
    }
  
  }
}
