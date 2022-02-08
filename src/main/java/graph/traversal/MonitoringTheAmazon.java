package graph.traversal;

import java.io.*;
import java.util.*;

public class MonitoringTheAmazon {
  static class Main {
    static int[][] adj;
    static Set<Integer> visited;
    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
      StringTokenizer tokenizer;

      int n;
      while ((n = Integer.parseInt(reader.readLine())) != 0) {
        Map<Integer, int[]> pts = new HashMap<>();
        int[][] xy = new int[n][3];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
          xy[i][0] = Integer.parseInt(tokenizer.nextToken());
          xy[i][1] = Integer.parseInt(tokenizer.nextToken());
          xy[i][2] = i;
          pts.put(i, new int[]{xy[i][0], xy[i][1]});
        }

        // sort the points according to the description in the problem
        Arrays.sort(xy, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a-> a[1]));
        adj = new int[n][2];

        // determine the closest two station for each one.
        for (int i = 0; i< n; i++){
          int[] curr = pts.get(i);
          adj[i][0] = -1;
          adj[i][1] = -1;
          int dist1 = 0, dist2 = 0;
          for (int j = 0; j < n; j++) {
            if (xy[j][2] != i) {
              int dist = square(xy[j][0] - curr[0]) + square(xy[j][1] - curr[1]);
              if (adj[i][0] == -1 || dist1 > dist) {
                adj[i][1] = adj[i][0];
                dist2 = dist1;

                dist1 = dist;
                adj[i][0] = j;
              } else if (adj[i][1] == -1 || dist2 > dist) {
                adj[i][1] = j;
                dist2 = dist;
              }
            }
          }
        }

        // apply bfs from order-dispatch station.
        visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited.add(0);
        while (!q.isEmpty()) {
          int curr = q.poll();
          for (int v : adj[curr]) {
            if (!visited.contains(v)) {
              visited.add(v);
              q.add(v);
            }
          }
        }
        if (visited.size() == n) {
          writer.println("All stations are reachable.");
        } else {
          writer.println("There are stations that are unreachable.");
        }
      }

      writer.close();
    }
    private static int square(int n) {
      return n*n;
    }
  }
}
