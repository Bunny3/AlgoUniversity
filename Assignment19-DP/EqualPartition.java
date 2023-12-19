import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class EqualPartition {
  public static boolean ifPossible(int inpArr[], int i, int S,int dp[][]) {
    if( S == 0 )
      return true;
    if(S<0)
      return false;
    if( i == inpArr.length-1){
      return (S==inpArr[i]);
    }
    if(dp[i][S]!=-1) {
      // System.out.println("i  ->"+i+"s+  ->"+S+"dp[i][S] ->"+dp[i][S]);

      return (dp[i][S]==1);
    }
    boolean flag =ifPossible(inpArr, i+1, S,dp) || ifPossible(inpArr, i+1, S-inpArr[i],dp);
    dp[i][S] = flag==true ? 1 : 0;
    return flag;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T =Integer.parseInt(input.readLine());
    while(T>0) {
      T--;
      int n = Integer.parseInt(input.readLine());
      int inpArr[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int sum =0;
      for(int i=0;i<n;i++) {
        sum+=inpArr[i];
      }
      
      if(sum%2!=0)
        System.out.println("NO");
      else {
        int dp[][] = new int[inpArr.length+1][(sum/2)+1];
        for(int i=0;i<inpArr.length+1;i++) {
          Arrays.fill(dp[i], -1);
        }
        System.out.println(ifPossible(inpArr,0,sum/2,dp)?"YES":"NO");
      }
    }
  }
}
