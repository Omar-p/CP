package traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Vertex {


  static class Main {
    static ArrayList<Integer>[] adjs;
    static boolean[] visited;
    private  static void dfs(int u) {

      for (int v : adjs[u]) {
        if (!visited[v]) {
          visited[v] = true;
          dfs(v);
        }
      }
    }

    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));


      String n;
      while (!(n = reader.readLine()).equals("0")) {
        int nodes = Integer.parseInt(n);
        adjs = new ArrayList[nodes+1];

        for (int i = 0; i <= nodes; i++)
          adjs[i] = new ArrayList<>();
        StringTokenizer tokenizer;
        String q;
        while (!(q = reader.readLine()).equals("0")) {
          tokenizer = new StringTokenizer(q);
          int u = Integer.parseInt(tokenizer.nextToken());
          int v;
          while ((v = Integer.parseInt(tokenizer.nextToken())) != 0) {
            adjs[u].add(v);
          }
        }
        tokenizer = new StringTokenizer(reader.readLine());
        int queriesNumber = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < queriesNumber; i++) {
          int from = Integer.parseInt(tokenizer.nextToken());
          visited = new boolean[nodes+1];
          dfs(from);

          int unreachable = 0;
          StringBuilder res = new StringBuilder();
          for (int j = 1; j <= nodes; j++) {
            if (!visited[j]) {
              res.append(j + " ");
              unreachable++;
            }
          }
          res.insert(0, unreachable + " ");
          res.deleteCharAt(res.length() - 1);
          writer.println(res);
        }
      }
      writer.close();
    }
  }
}
