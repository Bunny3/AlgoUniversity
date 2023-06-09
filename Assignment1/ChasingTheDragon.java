import java.util.*;
import java.io.*;
public class ChasingTheDragon {
  public static void main(String args[]) throws IOException{
    InputStreamReader p = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(p);
    int N = Integer.parseInt(br.readLine());
    String Narry[] = br.readLine().trim().split(" ");
    int inp[] = new int[N];

    for(int i=0;i<N;i++) {
      inp[i] = Integer.parseInt(Narry[i]);
    }

    //prefix Sum
    long cost[] = new long[N];
    cost[0] = inp[0];
    for(int i=1;i<N;i++) {
      cost[i] = cost[i-1]+inp[i];
    }

    int K;
    K = Integer.parseInt(br.readLine());
    int curr = 0;
    while(K > 0) {
      String td[] = br.readLine().trim().split(" ");
      int t = Integer.parseInt(td[0]);
      long d = Long.parseLong(td[1]);
      long cost_data;
      int position =(int)((curr+t*d)%N + N) %N;
      if(curr<position) {
          cost_data = cost[position] - cost[curr];
          cost_data = Math.min(cost_data,cost[N-1]-cost_data);
      } else {
          cost_data = cost[curr] - cost[position];
          cost_data = Math.min(cost_data,cost[N-1]-cost_data);
      }
      curr = position;
      System.out.println(cost_data);
      K--;
    }

  }
}
