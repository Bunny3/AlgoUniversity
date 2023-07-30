import java.util.*;
import java.io.*;
public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NK[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NK[0]);
    int K = Integer.parseInt(NK[1]);
    int arr[][] = new int[1001][1001];
    // Arrays.fill(arr,0);
    for(int[] row:arr)
      Arrays.fill(row,0);
    for(int i=0;i<N;i++) {
      int x1,y1,x2,y2;
      String x1y1x2y2[] = p.readLine().split(" ");
      x1 = Integer.parseInt(x1y1x2y2[0]);
      y1 = Integer.parseInt(x1y1x2y2[1]);
      x2 = Integer.parseInt(x1y1x2y2[2]);
      y2 = Integer.parseInt(x1y1x2y2[3]);
        for(int j=y1; j<y2; j++){
            arr[j][x1]+=1;
            arr[j][x2]-=1;
        }
    }
    int ans =0;
    for(int i=0;i<1001;i++) {
        if(arr[i][0]==K){
            ans++;
        }
      for(int j=1;j<1001;j++) {
            arr[i][j]+=arr[i][j-1];
            if(arr[i][j]==K){
                ans++;
            }
      }
    }
    System.out.println(ans);
  }
}
