import java.io.*;
import java.util.*;

public class EqualZeroSum {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    int inputArray[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();;
    int sum = 0;
    int count =0;
    Map<Integer,Integer> mp = new HashMap<>();
    for(int i=0;i<n;i++) {
      if(inputArray[i] == 0) {
        inputArray[i] = -1;
      }
      sum = sum+inputArray[i];
      if(sum==0)
        count++;
      if(mp.containsKey(sum)) {
        count +=mp.get(sum);
      }
      if(!mp.containsKey(sum)) {
        mp.put(sum,1);
      }
      else {
        mp.put(sum,mp.get(sum)+1);
      }
    }
    System.out.println(count);
  }
}
