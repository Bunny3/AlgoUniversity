import java.util.*;
import java.io.*;

class Pair {
  int x,y;
  public Pair(int x,int y) {
    this.x = x;
    this.y = y;
  }
}

class PairComparator implements Comparator<Pair> {
  public int compare(Pair a, Pair b) {
    return b.y-a.y;
  }
}
public class RecrutingSoldier {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    int inputArray[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    HashMap<Integer,Integer> mp = new HashMap<>();
    for(int i=0;i<N;i++) {
      if(mp.containsKey(inputArray[i]) == true) {
        mp.put(inputArray[i],mp.get(inputArray[i])+1);
      } else {
        mp.put(inputArray[i],1);
      }
    }
    // PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new PairComparator());
    // for(Map.Entry<Integer,Integer> e:mp.entrySet()) {
    //   pq.add(new Pair(e.getKey(),e.getValue()));
    // }
    int min_tie = 0;
    // while(!pq.isEmpty()) {
    //   Pair first = pq.poll();
    //   if(pq.isEmpty() == true) {
    //     min_tie = first.y/2;
    //     break;
    //   }
    //   Pair second = pq.poll();
    //   if(first.y > second.y) {
    //     pq.add(new Pair(first.x,(first.y-second.y)));
    //   }
    // }
    int total = 0;
    int max_ = Integer.MIN_VALUE;
    for(int i:mp.values()) {
      total+=i;
      max_ = max_<i?i:max_;
    }
    if(max_<=(total-max_)) min_tie =0;
    else {
      min_tie = (2*max_-total)/2;
    }
    System.out.println(min_tie);
  }
}
