import java.io.*;
import java.util.*;
public class MimicString {
  
  public static int findMinimumOperation(String x,int i,String y, int j,int dp[][]) {
    if(i == 0 && j==0) {
      return 0;
    }
    if(i == 0 && j!=0)
      return j;
    if(j == 0 && i!=0)
      return i;
    if(dp[i][j]!=-1)
      return dp[i][j];
    int numberOfOperation = 0;
    if(x.charAt(i-1)==y.charAt(j-1)) {
      numberOfOperation = findMinimumOperation(x,i-1,y,j-1,dp);
    } else {
      numberOfOperation = 1+Math.min(findMinimumOperation(x,i-1,y,j,dp),
                          Math.min(findMinimumOperation(x,i,y,j-1,dp), findMinimumOperation(x,i-1,y,j-1,dp)));
    }
    return dp[i][j]=numberOfOperation;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());
    while(T>0) {
      int NS[]=Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int N = NS[0];
      int S = NS[1];
      String string1 = input.readLine();
      String string2 = input.readLine();
      int dp[][] = new int[N+1][S+1];
      for(int i=0;i<=N;i++){
        Arrays.fill(dp[i],-1);
      }
      System.out.println(findMinimumOperation(string1,N,string2,S,dp));
      T--;
    }
  }
}
