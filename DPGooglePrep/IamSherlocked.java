import java.io.*;
import java.util.*;
 class Pair{
  int x,y;
  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
};
public class IamSherlocked {
public static int helper(ArrayList<Pair> aList, int m, int n,int idx,int dp[][][]) {
  if(idx<=0) {
    return 0;
  }
  if(dp[idx][m][n]!=-1)
    return dp[idx][m][n];
  if(m>=aList.get(idx-1).x && n>=aList.get(idx-1).y) {
    return dp[idx][m][n] = Math.max(helper(aList, m, n, idx-1, dp),1+helper(aList, m-1, n-1, idx-1, dp));
  }
  return dp[idx][m][n] = helper(aList, m, n, idx-1, dp);
}
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int cmn[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int c = cmn[0];
    int m = cmn[1];
    int n = cmn[2];

    ArrayList<Pair> aList = new ArrayList<Pair>();
    for(int i=0;i<c;i++) {
      String str = input.readLine();
      int ones =0;
      int zeroes =0;
      for(int j=0;j<str.length();j++) {
        if(str.charAt(j)=='1')
          ones++;
        else
          zeroes++;
      }
      aList.add(new Pair(zeroes, ones));
    }
    int dp[][][] = new int[201][101][101];
    for(int i=0;i<201;i++) {
      for(int j=0;j<101;j++) {
        Arrays.fill(dp[i][j],-1);
      }
    }
    int solveAns = helper(aList,m,n,c,dp);
    System.out.println(dp[c][m][n]+1);
    // System.out.println(solveAns);
  }
}
