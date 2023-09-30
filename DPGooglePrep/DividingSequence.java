import java.util.*;
import java.io.*;

public class DividingSequence {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    int a[] = new int[N];
    for(int i=0;i<N;i++) {
      a[i] = Integer.parseInt(p.readLine());
    }

    int dp[] = new int[N];
    int ans = 0;
    Arrays.fill(dp,1);
    for(int i=1;i<N;i++) {
      for(int j=0;j<i;j++) {
        if(a[i]%a[j] == 0) {
          dp[i] = Math.max(dp[i],dp[j]+1);
        }
      }
      ans = Math.max(ans,dp[i]);
    }
    
    // for(int  i=0;i<N;i++) {
    //   System.out.print(dp[i]+ " ");
    // }
    // System.out.println();
    System.out.println(ans);

    //print numbers
    // int last= -1;
    // for(int i=N-1;i>=0;i--) {
    //   if(dp[i]==ans && last == -1) {
    //     System.out.print(a[i]+" ");
    //     last = a[i];
    //     ans--;
    //   } else if(dp[i] == ans && last%a[i]==0){
    //     System.out.print(a[i]+" ");
    //     ans--;
    //     last=a[i];
    //   }
    // }
  }
}
