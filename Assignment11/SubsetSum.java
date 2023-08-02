import java.util.*;
import java.io.*;

public class SubsetSum {

  public static long total = 0;
  public static long ans = Integer.MAX_VALUE;
  public static void subset(long arr[], int indx,long firstGroupSum) {

    if(indx == arr.length) {
      // System.out.println(firstGroupSum); 
      long second_sum = total-firstGroupSum;
      ans = (long)Math.min(ans, (long)Math.abs(second_sum-firstGroupSum));
    }
    if(indx < arr.length) {
    subset(arr,indx+1,firstGroupSum+arr[indx]);
    subset(arr,indx+1,firstGroupSum);
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    String arr[] = p.readLine().trim().split(" ");

    long arrInp[] = new long[N];
    for(int i=0;i<N;i++) {
      arrInp[i] = Integer.parseInt(arr[i]);
      total+=arrInp[i];
    }
    subset(arrInp,0,0);
    System.out.println(ans);;
  }
}
