package traversal;

import java.io.*;
import java.util.ArrayList;

public class TheseusAndMinotaur {
  static class Main {

    static ArrayList<Integer>[] adjs;
    static boolean[] visited;
    static StringBuilder res;
    static int k;
    static final int ALPHA_COUNT = 26;

    public static void dfs(int s, int steps, int p) {
      if (steps % k == 0) {
        visited[s] = true;
      }

      boolean pass = false;
      for (int i : adjs[s]) {
        if (i != p && !visited[i]) {
          dfs(i, steps+1, s);
          pass = true;
          break;
        }
      }

      if (!pass) {
        res.append("/" + (char)('A' + s));
      } else if (steps % k == 0) {
        res.insert(0,(char)('A' + s) + " ");
      }
    }

    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

      String line;
      while (!(line = reader.readLine()).equals("#")) {
        res = new StringBuilder();
        adjs = new ArrayList[ALPHA_COUNT];
        visited = new boolean[ALPHA_COUNT];
        String[] input = line.split("(\\. )");
        String nodes = input[0];
        String[] start = input[1].split(" ");
        char minotaur = start[0].charAt(0);
        char theseus = start[1].charAt(0);
        k = Integer.parseInt(start[2]);

        for (int i = 0; i < ALPHA_COUNT; i++) {
          adjs[i] = new ArrayList<>();
        }
        String[] node = nodes.split(";");
        for (String n : node) {

          for (int j = 2; j < n.length(); j++) {
            adjs[n.charAt(0) - 'A'].add(n.charAt(j) - 'A');
          }
        }
        dfs(minotaur - 'A', 1, theseus - 'A');
        writer.println(res);
        writer.flush();
      }
      writer.close();
    }

  }


}
