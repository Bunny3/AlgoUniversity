import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class greedyBuilding {

  public static int findNumbeOfBuilding(int index, int H, int buildings[], int dp[][]) {

    if(index==0)
    {
      if(H%buildings[index] == 0) {
        return H/buildings[index];
  
      } else
          return 1000000009;
    }

    if(dp[index][H] != -1) return dp[index][H];
    //notake
    int noTake = findNumbeOfBuilding(index-1,H,buildings,dp);

    int take = Integer.MAX_VALUE;

    if(H>=buildings[index]) {
      take = 1 + findNumbeOfBuilding(index,H-buildings[index],buildings,dp);
    }

    return dp[index][H]= Math.min(take,noTake);
  }
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int T;
    T = Integer.parseInt(p.readLine());
    while(T>0) {
      int nH[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      int n = nH[0];
      int H = nH[1];

      int buildings[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      if(H == 0) {
        System.out.println(-1);
        continue;
      }
      int dp[][] = new int[n+1][H+1];
      for(int i=0;i<n+1;i++)
        Arrays.fill(dp[i],-1);
      int ans = findNumbeOfBuilding(n-1,H,buildings,dp);
      if(ans == 1000000009) 
        System.out.println(-1);
      else
        System.out.println(ans);
      T--;
    }
  }
}
 