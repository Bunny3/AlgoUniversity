import java.io.*;
import java.util.*;
public class SnowFlake {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String NE[] = p.readLine().trim().split(" ");
    int N = Integer.parseInt(NE[0]);
    int E = Integer.parseInt(NE[1]);
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    for(int i=0;i<N+1;i++) {
      adj.add(new ArrayList<Integer>());
    }
    int nodes[] = new int[N+1];
    for(int i=0;i<E;i++) {
      String UV[] = p.readLine().trim().split(" ");
      int U = Integer.parseInt(UV[0]);
      int V = Integer.parseInt(UV[1]);
      adj.get(U).add(V);
      adj.get(V).add(U);
    }

    //     for(int i=1;i<N+1;i++) {
    //   System.out.print("Adjacency List " + i+ " ");
    //   for(int j=0;j<adj.get(i).size();j++) {
    //     System.out.print("->"+adj.get(i).get(j));
    //   }
    //   System.out.println();
    // }

    // for(int i=0;i<N+)
    HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
    
    int count =0;
    for(int i=1;i<N+1;i++){
      
      if(adj.get(i).size() == 0)
      {
        if(!mp.containsKey(1)){
          mp.put(1,1);
        } else {
          mp.put(1,mp.get(1)+1);
        }
      }
      else if(adj.get(i).size()>1){
        boolean flag = true;
        for(int j=0;j<adj.get(i).size();j++) {
          if(adj.get(adj.get(i).get(j)).size()!=1){
            flag = false;
            break;
          }
        }
        if(flag == true) {
          if(!mp.containsKey(adj.get(i).size())) {
            mp.put(adj.get(i).size(),1);
          } else {
            mp.put(adj.get(i).size(),mp.get(adj.get(i).size())+1);
          }
        }
      }
    }

    for(Map.Entry<Integer,Integer> m: mp.entrySet()) {
      if(m.getValue()==1) {
        count++;
      }
    }

    System.out.println(count);
  }
}
