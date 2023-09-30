import java.io.*;
import java.util.*;

public class OriginalKadane {
  public static int GetMaxSumSubarray(int[] A) { 
  int prevBest = 0, ans = A[0]; 
  for (int i = 0; i < A.length; i++) 
  { prevBest = Math.max(prevBest + A[i], A[i]); //Extending best window ending at (i-1) or creating new window 
    ans = Math.max(ans, prevBest); 
  } 
  return ans; 
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

