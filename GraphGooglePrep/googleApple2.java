import java.io.*;
import java.util.*;
import java.lang.*;

public class googleApple2 {
    static ArrayList<ArrayList<Pair>> graph1;
    static ArrayList<ArrayList<Pair>> graph2;
    static ArrayList<ArrayList<Pair>> graph3;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph1 = new ArrayList<>();
        graph2 = new ArrayList<>();
        graph3 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
            graph3.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph1.get(a).add(new Pair(b, c));
            graph2.get(a).add(new Pair(b, d));
        }

        int[] google = dijkstra(graph1);
        int[] apple = dijkstra(graph2);

        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < graph1.get(i).size();j++){
                int cry = 0;
                int to = graph1.get(i).get(j).node;
                int wg = graph1.get(i).get(j).distance;
                int wa = graph2.get(i).get(j).distance;
                if(google[to] != wg+google[i]){
                    cry++;
                }
                if(apple[to] != wa+apple[i]){
                    cry++;
                }
                graph3.get(i).add(new Pair(to,cry));
            }
        }
        int[] finalAns = dijkstra(graph3);
        for(int i=0;i<google.length;i++) {
          System.out.print(google[i]+ " ");
        }
        System.out.println();
        for(int i=0;i<apple.length;i++) {
          System.out.print(apple[i]+ " ");
        }
        System.out.println();
        for(int i=0;i<finalAns.length;i++) {
          System.out.print(finalAns[i]+ " ");
        }
        System.out.println();
        bw.write(String.valueOf(finalAns[0]));
        bw.flush();
    }

    static int[] dijkstra(ArrayList<ArrayList<Pair>> graph) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(n - 1, 0));
        dis[n-1] = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.peek();
            pq.remove();
            int node = curr.node;
            for (Pair k : graph.get(node)) {
                int to = k.node;
                int len = k.distance;

                if (dis[node] + len < dis[to]) {
                    pq.remove(new Pair(to, dis[to]));
                    dis[to] = dis[node] + len;
                    pq.add(new Pair(to, dis[to]));
                }
            }
        }
        return dis;
    }


    static class Pair implements Comparable<Pair> {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
    