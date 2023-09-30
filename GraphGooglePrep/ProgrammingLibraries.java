import java.util.*;

import Contest.Contest5.Graph;

import java.io.*;
class Graph {
  int vertices;
  ArrayList<ArrayList<Integer>> adjList;
  public Graph(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<vertices;i++) {
      adjList.add(new ArrayList<Integer>());
    }
  }

  public void addEdge(int u,int v) {
    adjList.get(u).add(v);
  }

  public void printGraph() {
    for(int i=0;i<vertices;i++) {
      System.out.print("Nodes for "+i+"---> ");
      for(int node:adjList.get(i)) {
        System.out.print(node+" ");
      }
      System.out.println();
    }
  }
}
public class ProgrammingLibraries {

  public static void findDependencies(Graph graph, int N) {
    Queue<Integer> queue = new LinkedList<Integer>();
    int inDegree[] = new int[N];
    Arrays.fill(inDegree,0);
    for(int i=0;i<N;i++) {
      for(int node: graph.adjList.get(i)) {
        inDegree[node]++;
      }
    }

    // for(int i=0;i<N;i++) {
    //   System.out.print(inDegree[i] + " ");
    // }
    // System.out.println();

    for(int i=0;i<N;i++) {
      if(inDegree[i] == 0){
        queue.add(i);
      }
    }
    ArrayList<Integer> orderLibraries = new ArrayList<Integer>();
    while(!queue.isEmpty()) {
      int node = queue.poll();
      orderLibraries.add(node);
      for(int i:graph.adjList.get(node)) {
        inDegree[i]--;
        if(inDegree[i] == 0) {
          queue.add(i);
        }
      }
    }

    for(int i=0;i<orderLibraries.size();i++){
      System.out.print(orderLibraries.get(i)+" ");
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int inputArray[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
    int N = inputArray[0];
    int M = inputArray[1];
    Graph graph = new Graph(N);
    for(int i=0;i<M;i++) {
      int edge[] = Arrays.stream(input.readLine().trim().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
      graph.addEdge(edge[0], edge[1]);
    }

    // graph.printGraph();
    Stack<Integer> st = new Stack<Integer>();
    findDependencies(graph, N);
  }
}
