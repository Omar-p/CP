package graph.traversal;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DominoEffect {
  static class Main {

    static ArrayList<Integer>[] adjs;
    static ArrayList<Integer>[] costs;
    static boolean[] visited;
    static PriorityQueue<int[]> pq;
    static int[] dist;
    static int[] p;

    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

      String line;
      int sysCount = 1;
      while (!(line = reader.readLine()).equals("0 0")) {
        StringTokenizer tokenizer = new StringTokenizer(line);
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        adjs = new ArrayList[n+1];
        costs = new ArrayList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];
        p = new int[n+1];
        pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i <= n; i++) {
          adjs[i] = new ArrayList<>();
          costs[i] = new ArrayList<>();
          dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        pq.add(new int[]{1, 0});
        for (int i = 0; i < m; i++) {
          tokenizer = new StringTokenizer(reader.readLine());
          int u = Integer.parseInt(tokenizer.nextToken());
          int v = Integer.parseInt(tokenizer.nextToken());
          int c = Integer.parseInt(tokenizer.nextToken());

          adjs[u].add(v);
          adjs[v].add(u);
          costs[v].add(c);
          costs[u].add(c);
        }

        while (!pq.isEmpty()) {
          int[] curr = pq.poll();
          visited[curr[0]] = true;
          for (int j = 0; j < adjs[curr[0]].size(); j++) {
            int currNeighbour = adjs[curr[0]].get(j);
            int newDist = curr[1] + costs[curr[0]].get(j);
            if (dist[currNeighbour] > newDist) {
              p[currNeighbour] = curr[0];
              dist[currNeighbour] = newDist;
            }
            if (!visited[currNeighbour]) {
              pq.add(new int[]{currNeighbour, dist[currNeighbour]});
            }
          }
        }
        System.out.printf("s");

      }
    }
  }
}
