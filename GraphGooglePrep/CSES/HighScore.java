import java.io.*;
import java.util.*;

class Graph {
  class Edge {
    int src, dest, weight;
    Edge() {
      src = dest= weight;
    }
  };

    int V,E;
    Edge edge[];

    Graph(int v, int  e) {
      V = v;
      E = e;
      edge = new Edge[e];
      for(int i=0;i<e;i++) {
        edge[i] = new Edge();
      }
    }

    void BellmanFord(Graph graph, int src) {
      int V = graph.V;
      int E = graph.E;

      int dist[] = new int[V];
      for(int i=0;i<V;i++) {
        dist[i] = Integer.MAX_VALUE;
      }
      dist[src] = 0;
      for(int i=1;i<V;i++) {
        for(int j=0;j<E;j++) {
          int u = graph.edge[j].src;
          int v = graph.edge[j].dest;
          int weight = graph.edge[j].weight;
          if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight < dist[v]) {
            dist[v] = dist[u]+weight;
          }
        }
      }

        for(int j=0;j<E;j++) {
          int u = graph.edge[j].src;
          int v = graph.edge[j].dest;
          int weight = graph.edge[j].weight;
          if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight < dist[v]) {
            //dist[v] = dist[u]+weight;
            System.out.println(-1);
            return;
          }
        }
      printArr(dist, V);
    }

    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}
public class HighScore {
  public static void main(String args[]) throws IOException {

  }
}
