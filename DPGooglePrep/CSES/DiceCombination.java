import java.io.*;
import java.util.*;
public class DiceCombination {
  public static int findNumberOfCombinations(int n,int dp[]) {
    if(n == 0) return 1;
    if(n<0) return 0;
    if(dp[n]!=-1)
      return dp[n];
    int ans = 0;
    for(int i=1;i<=6;i++) {
      ans = (ans%1000000007+findNumberOfCombinations(n-i,dp)%1000000007)%1000000007;
    }

    return dp[n]=ans;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    int dp[] = new int[n+1];
    Arrays.fill(dp,0);
    // int ans = findNumberOfCombinations(n,dp);
    dp[0] = 1;
    int ans =0;
    for(int i=1;i<=n;i++) {

      for(int j=1;j<=6;j++) {
        if(i-j>=0) {
          dp[i] = (dp[i]%1000000007+dp[i-j]%1000000007)%1000000007;
        }
      }
    }

    

    System.out.println(dp[n]%1000000007);
  }
}
