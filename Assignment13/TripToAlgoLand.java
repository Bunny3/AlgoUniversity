import java.util.*;
import java.io.*;

class Pair {
  int start;
  int distance;
  String path;

  Pair(int s, int d, String p) {
    start = s;
    distance = d;
    path = p;
  }
}
public class TripToAlgoLand {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String VE[] = p.readLine().trim().split(" ");
    int V = Integer.parseInt(VE[0]);
    int E = Integer.parseInt(VE[1]);
    HashMap<String, Integer> cityValue = new HashMap<>();
    int count = 0;
    ArrayList<HashMap<Integer,String>> adjList = new ArrayList<>();
    for(int i=0;i<V;i++) {
      adjList.add(new HashMap<>());
    }
      int a=0, b=0;
    for(int i=0;i<E;i++) {
      String uvn[] = p.readLine().trim().split(" ");
      if(cityValue.containsKey(uvn[0])) {
        a = cityValue.get(uvn[0]);
      } else {
        a = count++;
        cityValue.put(uvn[0],a);
      }

      if(cityValue.containsKey(uvn[1])) {
        b = cityValue.get(uvn[1]);
      } else {
        b = count++;
        cityValue.put(uvn[1],b);
      }
      adjList.get(a).put(b,uvn[2]);
    }

    String sd[] = p.readLine().trim().split(" ");
    int src =cityValue.get(sd[0]);
    int des = cityValue.get(sd[1]);

    Queue<Pair> q = new LinkedList<Pair>();
    q.add(new Pair(src,0,""));
    int visited[] = new int[V+1];
    Arrays.fill(visited,-1);
    while(!q.isEmpty()) {
      Pair node = q.poll();
      if(node.start == des){
        System.out.println(node.distance);
        System.out.println(node.path);
        return;
      }
      for(Map.Entry<Integer,String> e:adjList.get(node.start).entrySet()) {
        int key = e.getKey();
        if(visited[key] == -1) {
          visited[key] = 0;
          q.add(new Pair(key, node.distance +1,node.path == ""? e.getValue() : node.path + "\n"+e.getValue()));
        }
      }
    }

    System.out.println("Impossible");
  }  
}
