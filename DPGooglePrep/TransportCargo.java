import java.io.*;
import java.util.*;
public class TransportCargo {
  public static int solve(int N, int weight[],int volume[], int V1,int V2) {
    if(N<0) {

    } 
    //left
    int left =0;
    int right =0;
    // if(V>=volume[N-1]) {
    left = solve(N-1,weight,volume,V1-volume[N-1],V1)+weight[N-1];
    right = solve(N-1,weight,volume,V1,V2-volume[N-1]);
    // }
    
    
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NV[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NV[0];
    int V = NV[1];
    int weight[] =new int[N];
    int volume[] =new int[N];
    for(int i=0;i<N;i++) {
      int wv[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
      weight[i] = wv[0];
      volume[i] = wv[1];
    }

    int ans = solve(N,weight,volume,V,V);
  }
}
