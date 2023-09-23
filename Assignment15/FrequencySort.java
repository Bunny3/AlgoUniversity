import java.util.*;
import java.io.*;

class Pair {
  long a;
  int b;
  Pair(long a, int b) {
    this.a = a;
    this.b = b;
  }
};

class PairComparator implements Comparator<Pair> {
  public int compare(Pair x,Pair y) {
    if(x.b == y.b)
      return (int)(x.a-y.a);
    return y.b-x.b; // 1 ,(2,3)
  }
}
public class FrequencySort {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(p.readLine());
    long arr[] = Arrays.stream(p.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
    HashMap<Long,Integer> mp = new HashMap<Long,Integer>();
    for(int i=0;i<arr.length;i++) {
      if(mp.containsKey(arr[i])) {
        mp.put(arr[i],mp.get(arr[i])+1);
      } else {
        mp.put(arr[i],1);
      }
    }
    ArrayList<Pair> tups = new ArrayList<Pair>();
    for(Map.Entry<Long,Integer> e: mp.entrySet()) {
      tups.add(new Pair(e.getKey(), e.getValue()));
    }

    Collections.sort(tups,new PairComparator());

    for(int i=0;i<tups.size();i++) {
      Pair temp = tups.get(i);
      long x = temp.a;
      int f = temp.b;
      for(int j=0;j<f;j++) {
        System.out.print(x + " ");
      }
    }
  }
}
