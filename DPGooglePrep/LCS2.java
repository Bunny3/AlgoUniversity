import java.io.*;
import java.util.*;
public class LCS2 {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String s1 = p.readLine();
    String s2 = p.readLine();
    int m = s1.length();
    int n = s2.length();
    int dp[][] = new int[m+1][n+1];
    for(int i=0;i<m+1;i++) Arrays.fill(dp[i],0);

    for(int i=0;i<m+1;i++) {
      for(int j=0;j<n+1;j++) {
        if(i==0||j==0) {
          dp[i][j] = 0;
        }
        else if(s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1]+1;
        } else {
          dp[i][j] = (int)Math.max(dp[i-1][j],dp[i][j-1]);
        }
      }
    }
    // System.out.println(dp[m][n]);
    // StringBuilder ans =new StringBuilder();
    int index = dp[m][n];
    char[] lcs = new char[index + 1];
    lcs[index] = '\u0000';
    int i = m, j= n;
    while(i>0 && j>0) {
      if(s1.charAt(i-1)==s2.charAt(j-1)) {
        // ans.append(s1.charAt(i-1));
        lcs[index - 1] = s1.charAt(i - 1);
        i--;
        j--;
        index--;
      } else if(dp[i-1][j]>dp[i][j-1]){
        i--;
      } else 
      {
        j--;
      }
    }
    // ans.reverse();
    // System.err.println(ans);
    for (int k = 0; k < dp[m][n]; k++)
      System.out.print(lcs[k]);
  }
}
