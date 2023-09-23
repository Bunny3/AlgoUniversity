import java.util.*;
import java.io.*;
public class SainArrangement {
  public static void bfs(long templePositions[],int N,int M) {
    HashMap<Long,Integer> mp = new HashMap<Long,Integer>();
    Queue<Long> q = new LinkedList<Long>();
    for(int i=0;i<templePositions.length;i++) {
      q.add(templePositions[i]);
      mp.put(templePositions[i],0);
    }
    ArrayList<Long> saints = new ArrayList<Long>();
    long min_sum = 0;
    while(saints.size()<=M) {
        long position = q.poll();
        if(mp.containsKey(position-1) == false) {
          mp.put(position-1,mp.get(position)+1);
          q.add(position-1);
          saints.add(position-1);
          // min_sum = min_sum + mp.get(position-1);
          // System.out.println("position"+(position-1)+" "+min_sum);
        }
        if(saints.size() == M) break;
        if(mp.containsKey(position+1) == false) {
          mp.put(position+1,mp.get(position)+1);
          q.add(position+1);
          saints.add(position+1);
          // min_sum = min_sum + mp.get(position+1);
          // System.out.println("position"+(position+1)+" "+min_sum);
        }
    }
    for(int i=0;i<M;i++) {
      min_sum = min_sum + mp.get(saints.get(i));
    }
    System.out.println(min_sum);
    for(int i=0;i<M;i++) {
      System.out.print(saints.get(i)+" ");
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
    int inputArray[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = inputArray[0];
    int M = inputArray[1];
    long templePositions[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
    bfs(templePositions,N,M);
  }
}
