package dp.cses;

import java.io.*;
import java.util.StringTokenizer;

public class GridPaths {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    final int n = Integer.parseInt(tokenizer.nextToken());
    String[] grid = new String[n];
    for (int i = 0; i < n; i++) {
      grid[i] = reader.readLine();
    }

    int[][] dp = new int[n][n];
    dp[0][0] = grid[0].charAt(0) == '.' ?  1 : 0;
    for (int i = 1; i < n; i++) {
      if (grid[i].charAt(0) == '.')
        dp[i][0] = dp[i-1][0];
      if (grid[0].charAt(i) == '.')
        dp[0][i] = dp[0][i-1];
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        if (grid[i].charAt(j) == '.') {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
          dp[i][j] %= 1_000_000_007;
        }

      }
    }
    writer.println(dp[n - 1][n - 1]);
    writer.close();

  }
}
