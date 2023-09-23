import java.util.*;
import java.io.*;

public class P8TreasureRoomv2 {
  
  public static class Pair {
    int number, index;
  }

  public static class compareClass implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      return a.number - b.number;
    }

    //+ swap
    //- swap
  }
  public static void main(String args[])throws IOException {
    int N,target;
    ArrayList<Integer> ans = new ArrayList<>();
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NT[] = p.readLine().trim().split(" ");
    N = Integer.parseInt(NT[0]);
    target = Integer.parseInt(NT[1]);
    String arrInp[] = p.readLine().trim().split(" ");
    Pair[] arr = new Pair[N];
    for(int i=0;i<N;i++) {
      Pair pair = new Pair();
      pair.index = i+1;
      pair.number = Integer.parseInt(arrInp[i]);
      arr[i] = pair;
    }
    Arrays.sort(arr,new compareClass());

    for(int i=0;i<=N-3;i++){
      int sum = target-arr[i].number;
      int j = i+1,k=N-1;
      while(j<k) {
        int n2 = arr[j].number;
        int n3 = arr[k].number;
        if(sum == (n2+n3)){
          System.out.println(arr[i].index + " " + arr[j].index +" "+ arr[k].index);
          System.exit(1);
        } else if((n2+n3)>sum)
        {
          k--;
        } else if((n2+n3)<sum){
          j++;
        }
      }
    }
    //Three Sum
    System.out.println(-1);
  }
}
