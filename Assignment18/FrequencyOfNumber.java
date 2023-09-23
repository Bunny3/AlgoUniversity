import java.io.*;
import java.util.*;
public class FrequencyOfNumber {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    int N = NM[0];
    int k = NM[1];
    int inputArray[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    HashMap<Integer,Integer> mp = new HashMap<>();
    for(int i=0;i<N;i++) {
      if(mp.containsKey(inputArray[i]) == true) {
        mp.put(inputArray[i],mp.get(inputArray[i])+1);
      } else {
        mp.put(inputArray[i],1);
      }
    }
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(5,new frequencyComparator());
    for(Map.Entry<Integer,Integer> e:mp.entrySet()) {
      pq.add(new Pair(e.getValue(), e.getKey()));
    }
    while(k>0) {
      System.out.print(pq.poll().number+" ");
      k--;
    }

  }
}

class Pair{
  int freq, number;
  public Pair(int freq,int number) {
    this.freq = freq;
    this.number = number;
  }
};

class frequencyComparator implements Comparator<Pair> {

  public int compare(Pair a, Pair b) {
    if(a.freq == b.freq) {
      return a.number-b.number;
    }
    return b.freq - a.freq;
  }
};
