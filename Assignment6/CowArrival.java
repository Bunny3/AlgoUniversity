import java.util.*;
import java.io.*;

public class CowArrival {
  public static void main(String args[]) throws IOException {

    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(p.readLine());
    long arr[][] = new long[n][2];

    for(int i=0;i<n;i++) {
      String temp[] = p.readLine().trim().split(" ");
      arr[i][0] = Integer.parseInt(temp[0]);
      arr[i][1] = Integer.parseInt(temp[1]);
    }
    Arrays.sort(arr, new Comparator<long[]>(){
      public int compare(final long[] a, final long[] b) {
        return (int)(a[0]-b[0]);
      }});

    long maxEndTime = arr[0][0]+arr[0][1];
    long endTime = maxEndTime;
    for(int i=1;i<n;i++) {
      if(arr[i][0]>endTime) {
        maxEndTime = arr[i][0]+arr[i][1];
        endTime = arr[i][0]+arr[i][1];
      } else {
        endTime = endTime+arr[i][1];
        maxEndTime = Math.max(endTime,maxEndTime);
      }
    }
    System.out.println(maxEndTime);
  }
}
