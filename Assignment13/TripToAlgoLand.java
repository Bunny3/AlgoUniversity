import java.util.*;
import java.io.*;
public class TripToAlgoLand {
  public static void main(String args[]) throws IOException {
    BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
    String VE[] = p.readLine().trim().split(" ");
    int V = Integer.parseInt(VE[0]);
    int E = Integer.parseInt(VE[1]);
    ArrayList<ArrayList<String>> adj = new ArrayList<ArrayList<String>>();
    for(int i=0;i<V;i++) {
      adj.add(new ArrayList<String>());
    }
    int visited[] = new int[V];
    for(int i=0;i<E;i++) {
      String UVN[] = p.readLine().trim().split(" ");
      String u = UVN[0];
      String v = UVN[1];
      String n = UVN[2];
      
    }
  }  
}
