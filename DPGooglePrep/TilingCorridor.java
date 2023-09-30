import java.util.*;
import java.io.*;

public class TilingCorridor {

  static int mod = 1000000007;
  public static int findTilingFloor(int N, int dp[]) {
    if(dp[N]!=-1){
      return dp[N];
    }
    if(N<=2)
      return dp[N] = N;
    return dp[N]=(findTilingFloor(N-1, dp)%mod+findTilingFloor(N-2, dp)%mod)%mod;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());

    int dp[] = new int[N+1];

    Arrays.fill(dp,-1);
    int ans = findTilingFloor(N,dp);
    System.out.println(ans);
    for(int i=0;i<N+1;i++){
      System.out.print(dp[i]+" ");
    }
  }
}
