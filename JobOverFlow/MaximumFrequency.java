import java.util.*;
import java.io.*;
public class MaximumFrequency {

  public static int predicate(int mid,int arr[],int X) {
    long windowSum=0;
    long totalSum = 0;
    for(int i=0;i<mid;i++) {
      windowSum+=arr[i];
    }
    totalSum = arr[mid-1]*mid;

    if(totalSum-windowSum<X)
      return 0;
    int j=0;
    for(int i=mid;i<arr.length;i++) {
      windowSum-=arr[j];
      windowSum+=arr[i];
      totalSum = arr[i]*mid;
      if(totalSum-windowSum<X) 
        return 0;
      j++;

    }
    return 1;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NX[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NX[0]);
    int X = Integer.parseInt(NX[1]);

    String Narr[] = p.readLine().trim().split(" ");
    int arr[] = new int[N];
    for(int i=0;i<N;i++) {
      arr[i] =Integer.parseInt(Narr[i]);
    }

    int l=-1,r=N;
    int ans=0;
    Arrays.sort(arr);
    while(l+1<r) {
      int mid = l + (r-l)/2;
      if(predicate(mid,arr,X) == 0)
      {
        // ans = mid;
        l = mid;
      } else {
        r = mid;
      }
    }
    System.out.println(r);
  }
}
