import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class JoinSticks {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    long inputArray[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray();
    PriorityQueue<Long> pq = Arrays.stream(inputArray).boxed().collect(Collectors.toCollection(PriorityQueue::new));
    long cost = 0;
    while(pq.size()>1) {
      long x = pq.poll();
      long y = pq.poll();
      cost += x+y;
      pq.add(x+y);
    }
    System.out.println(cost);
  }
}
