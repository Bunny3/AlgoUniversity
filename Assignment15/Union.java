import java.util.*;
import java.io.*;

public class Union {
  
  public static void main(String  args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String nm[] = p.readLine().trim().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    String Narr[] = p.readLine().trim().split(" ");
    String Marr[] = p.readLine().trim().split(" ");
    long arr1[] = new long[n];
    long arr2[] = new long[m];
    arr1 = Arrays.stream(Narr).mapToLong(s->Long.parseLong(s)).toArray();
    arr2 = Arrays.stream(Marr).mapToLong(s->Long.parseLong(s)).toArray();
    SortedMap<Long,Long> mp = new TreeMap<Long,Long>();
    for(int i=0;i<arr1.length;i++) {
      // if(mp.containsKey(arr1[i]) == true){
      //   mp.put(arr1[i],mp.get(arr1[i])+1);
      // } else {
        mp.put(arr1[i],1L);
      // }
    }

        for(int i=0;i<arr2.length;i++) {
      // if(mp.containsKey(arr2[i]) == true){
      //   mp.put(arr2[i],mp.get(arr2[i])+1);
      // } else {
        mp.put(arr2[i],1L);
      // }
    }

    
    Set<Map.Entry<Long,Long>> e = mp.entrySet();
    Iterator<Map.Entry<Long,Long>> it = e.iterator();
    while(it.hasNext()) {
      Map.Entry<Long,Long> entry = it.next();
      System.out.print(entry.getKey()+" ");
    }

  }
}
