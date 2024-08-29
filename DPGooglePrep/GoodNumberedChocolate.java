import java.io.*;
import java.util.*;
public class GoodNumberedChocolate {

  public static int solve(int i, int target,int dp[][],int happyArray[]) {
    if(i>=target) return 0;
    if(dp[i][target]!=-1) return dp[i][target];
    int consider = happyArray[i]+solve(i, target-(i+1), dp, happyArray);

    int notconsider = solve(i+1, target, dp, happyArray);
    return dp[i][target] = Math.max(consider, notconsider);
  }
  public static void main(String args[]) throws IOException {
    int T,N;
    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(inp.readLine());
    while(T-- > 0) {
      N = Integer.parseInt(inp.readLine());
      int happyArray[] = Arrays.stream(inp.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int dp[][] = new int[N+1][N+1];
      for(int i=0;i<N;i++) {
        Arrays.fill(dp[i],-1);
      }
      System.out.println(solve(0,N,dp,happyArray));
    }
  }
}
