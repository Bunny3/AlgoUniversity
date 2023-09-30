import java.io.*;
import java.util.*;
public class Kadane01Hole {
  public static int GetMaxSumSubarray(int[] A) { 
    int n = A.length;
    int fw[] = new int[n];
    int bw[] = new int[n];
    // int curr_max = A[0],max_so_far = arr[0];

    fw[0] = A[0];
    bw[n-1] = A[n-1];
    int max_elem = A[0];
    for(int i=1;i<n;i++) {
      fw[i] = Math.max(fw[i-1]+A[i], A[i]);
      max_elem = Math.max(max_elem, A[i]);
    }
    int max_sum = A[n-1];
    for(int i=n-2;i>=0;i--) {
      bw[i] = Math.max(bw[i+1]+A[i], A[i]);
      max_sum = Math.max(max_sum,bw[i]);
    }

    // for(int i=0;i<n;i++) {
    //   System.out.print(fw[i]+" ");
    // }

    // System.out.println();

    // for(int i=0;i<n;i++) {
    //   System.out.print(bw[i]+" ");
    // }
    // System.out.println();
    int fans = max_sum;
    for(int i=1;i<n-1;i++) {
      fans = (int)Math.max(fans, Math.max(0,fw[i-1]+Math.max(0,bw[i+1])));
    }

    if(fans == 0) {
      return max_elem;
    }
    return fans;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    String Astring[] = p.readLine().trim().split(" ");
    int A[] = new int[N];
    for(int i=0;i<N;i++) {
      A[i] = Integer.parseInt(Astring[i]);
    }
    System.out.println(GetMaxSumSubarray(A));
  }
}
