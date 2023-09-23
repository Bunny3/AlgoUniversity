import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
public class LinearProbing {
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int NM[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
    int numberArray[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
    int N = NM[0];
    int M = NM[1];
    int hash[] = new int[M];
    Arrays.fill(hash,-1);
    HashMap<Integer,Integer> mp = new HashMap<>();
    for(int i=0;i<N;i++) {
      if(mp.size()<M && mp.containsKey(numberArray[i]) == false) {
        int index = numberArray[i]%M;
        int next=1;
        while(hash[index]!=-1) {  
          index = (numberArray[i]+next)%M;
          next++;
        }
        // if(index>=M)
        //   continue;
        hash[index] = numberArray[i];
        mp.put(numberArray[i],1);
        if(mp.size() == M)
          break;
      }
    } 
    for(int i=0;i<M;i++){
      System.out.print(hash[i]+" ");
    }
  }
}
