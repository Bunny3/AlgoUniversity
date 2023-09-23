import java.util.*;
import java.io.*;

class Graph_List {
  int vertices;
  ArrayList<ArrayList<Integer>> adjList;
  public Graph_List(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<vertices+1;i++) {
      adjList.add(new ArrayList<Integer>());
    }
  }

  public void addEdge(int i,int j) {
    adjList.get(i).add(j);
    adjList.get(j).add(i);
  }

  public void removeEdge(int i,int j) {
    int index =-1;
    for(int children:adjList.get(i)) {
      index++;
      if(children == j) {
        adjList.get(i).remove(index);
        break;
      }
    }
  }

  public boolean isEdge(int i,int j) {
    for(int children:adjList.get(i)) {
      if(children == j) 
      return true;
    }
    return false;
  }
  
  public void printGraph() {
    for(int i=1;i<vertices+1;i++) {
      System.out.print("vertex "+i+"is connected to :");
      for(int j=0;j<adjList.get(i).size();j++) {
        System.out.print(adjList.get(i).get(j));
      }
      System.out.println();
    }
  }
}

public class GraphTemplate {
  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = 5;
    Graph_List g;
    g = new Graph_List(N);
    g.addEdge(1, 2);
    g.addEdge(2,3);
    g.addEdge(3,4);
    g.addEdge(4,5);
    g.printGraph();
  }
}