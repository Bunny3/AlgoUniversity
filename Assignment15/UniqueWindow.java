import java.util.*;
import java.io.*;
public class UniqueWindow {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nk[] = p.readLine().trim().split(" ");
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);
    int arr[] = Arrays.stream(p.readLine().trim().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
    // for(int i=0;i<n;i++)
    // System.out.println(arr[i]);
    HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
    for(int i=0,c=0;i<n+1;i++) {
      if(c==k) {
        System.out.print(mp.size()+" ");
        if(mp.get(arr[i-k]) == 1)
          mp.remove(arr[i-k]);
        else
          mp.put(arr[i-k],mp.get(arr[i-k])-1);
        c--;
      }
      if(i==n)
      break;
      if(c<k) {
        if(mp.containsKey(arr[i])) 
          mp.put(arr[i], mp.get(arr[i])+1);
        else 
          mp.put(arr[i], 1);
        c++;
      }
    }
  }
}
