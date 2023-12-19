import java.util.*;
import java.io.*;
public class NotSoObvious {
  public static long findMinOps(long arrA[],long arrB[],int A, int B,long dp[][]) {
      if(A==0 || B==0) return 0;
      int a1=0, b1=0;
      if(dp[A][B]!=-1)
        return dp[A][B];
    if(arrA[A-1] == arrB[B-1]) {
        return dp[A][B] = 1+findMinOps(arrA, arrB, A-1, B-1,dp);
    } else {
        return dp[A][B] =Math.max(findMinOps(arrA, arrB, A, B-1,dp),findMinOps(arrA, arrB, A-1, B,dp));
    }

  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int AB[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int A = AB[0];
    int B = AB[1];

    long arrA[] = Arrays.stream(p.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
    long arrB[] = Arrays.stream(p.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
    long dp[][] = new long[A+1][B+1];
    for(int i=0;i<A+1;i++) {
      Arrays.fill(dp[i], -1);
    }
    long ans = (int)findMinOps(arrA,arrB,A,B,dp);
    System.out.println(B-ans);
  }
}
