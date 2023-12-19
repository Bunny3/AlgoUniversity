import java.io.*;
import java.util.*;

public class TilingCorridor {
  static int MOD = 1000000007;
  public  static int findTiles(int N,int dp[]) {
    if(N==1 || N == 2) {
      return N;
    }
    if(dp[N]!=-1)
      return dp[N];

    int ans = (int)(findTiles(N-1,dp)%MOD + findTiles(N-2,dp)%MOD)%MOD;
    return dp[N]=ans;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N =Integer.parseInt(input.readLine());
    int dp[] = new int[N+1];
    Arrays.fill(dp,-1);
    int ans = findTiles(N,dp);
    System.out.println(ans);
  }
}