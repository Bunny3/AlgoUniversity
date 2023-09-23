import java.util.*;
import java.io.*;
public class FindNumber {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0;i<N;i++) {
      int query[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
      if(query[0] == 1) {
        pq.add(query[1]);
      } else {
        System.out.println(pq.poll());
      }
    }
  }
}
