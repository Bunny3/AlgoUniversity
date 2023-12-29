import java.util.*;
import java.io.*;

public class LadiesAndGentleMan {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    long mod = 1000000007;
    int  N = Integer.parseInt(input.readLine());
    int dp[][] = new int[N+1][2];
    dp[0][0] = 1;
    dp[1][0] = 0;
    for(int i=1;i<N;i++) {
      dp[i][0] += dp[i-1][0];
      dp[i][1] += dp[i-1][1];
      dp[i][0] %= mod;
      dp[i][1] %= mod;
      int par = i%2;
      dp[i][par] += dp[i-1][1-par];
      dp[i][par] %= mod;
      dp[i][par] += 1;
      dp[i][par] %= mod;
    }
    System.out.println((dp[N-1][0]+dp[N-1][1])%mod);
  }
}
