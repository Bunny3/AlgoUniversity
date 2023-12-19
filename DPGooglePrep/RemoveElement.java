import java.util.*;
import java.io.*;
public class RemoveElement {
  public static int computation(int k,int i, int j,int arr[]) {
    int left = 1, right=1;
    if(k>i) {
      left = arr[k-1];
    }
    if(k<j) {
      right = arr[k+1];
    }
    return left*arr[k]*right;
  }
  public static int solve(int i,int j,int arr[]) {
    if (i > j) {
      return 0;
  }
    // if(i==j) {
    //   return arr[i];
    // }
    System.out.println(" i "+i+" j "+j);
    int ans = Integer.MIN_VALUE;
    for(int k=i;k<=j;k++) {
      int temp = solve(i,k-1,arr) + solve(k+1, j, arr) + arr[i - 1] * arr[k] * arr[j + 1];
      ans = Math.max(ans,temp);
    }
    System.out.println(ans+" i "+i+" j "+j);
    return ans;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    int arr[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int[] extendedA = new int[N + 2];
    extendedA[0] = 1;
    extendedA[N + 1] = 1;
    System.arraycopy(arr, 0, extendedA, 1, N);
    System.out.println(solve(1, N, extendedA));
  }
}
