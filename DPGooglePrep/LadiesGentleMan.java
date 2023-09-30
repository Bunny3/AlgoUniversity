import java.io.*;
import java.util.*;
public class LadiesGentleMan {
 static int MOD = 1000000007;
  static int  solve(int N, int dp[]) {
    if(dp[N]!=-1) {
      return dp[N];
    }
    if(N==1) {
      return dp[N]=1;
    } 
    if(N==2) {
      return dp[N]=3;
    }

    //nopick
    int nopick = 0;
    if(N>2)
    {
      nopick = solve(N-2,dp)+1;
    }
    //pick
    int pick =0;
    if(N>1) {
      pick = solve(N-1,dp)+1;
    }

    return dp[N]=(pick%MOD+nopick%MOD)%MOD;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    int dp[] = new int[N+1];
    Arrays.fill(dp,-1);
    System.out.println(solve(N,dp));
  }
}
