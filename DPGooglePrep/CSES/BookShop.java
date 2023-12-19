import java.io.*;
import java.util.*;
public class BookShop {

  public static int maxPages(int h[],int s[],int n, int x,int indx) {
    if(indx == n) {
      return Integer.MIN_VALUE;
    }
    if(x == 0)
      return 0;
    int notTake = maxPages(h,s,n,x,indx+1);
    int take = 0;
    if(h[indx]<=x) {
      take = maxPages(h,s,n,x-h[indx],indx+1)+s[indx];
    }
    return Math.max(notTake, take);
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int nx[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int n = nx[0];
    int x = nx[1];
    int h[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int sar[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();

    // int ans = maxPages(h,sar,n,x,0);
    int dp[][] = new int[n+1][x+1];

    for(int i=1;i<=n;i++) {
      for(int j=0;j<=x;j++){
        int notTake = dp[i-1][j];
        int take = 0;
        if(h[i-1]<=j) {
          take = dp[i-1][j-h[i-1]]+sar[i-1];
        }
        dp[i][j]=(Math.max(notTake, take));
      }
    }
    System.out.println(dp[n][x]);
  }
}
