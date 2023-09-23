import java.util.*;
import java.io.*;
public class Consecutiveness {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    long inpArr[] = Arrays.stream(input.readLine().trim().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();

    HashSet<Long> set = new HashSet<Long>();
    for(int i=0;i<n;i++) {
      set.add(inpArr[i]);
    }
    int ans = 0;
    for(int i=0;i<n;i++) {
      if(set.contains(inpArr[i])) {
        long j = inpArr[i];
        int count = 0;
        while(set.contains(j))
        {
          j++;
          count++;
        }
        ans = (ans>=count) ? ans : count;
      }
    }

    System.out.println(ans);

  }
}
