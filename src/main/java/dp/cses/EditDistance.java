package dp.cses;

import java.io.*;
import java.util.Arrays;

public class EditDistance {
  static int[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
    String word1 = reader.readLine();
    String word2 = reader.readLine();
    dp = new int[word1.length()+1][word2.length()+1];
    for (int[] row : dp) Arrays.fill(row, -1);
    writer.println(solve(word1, word2, 0, 0));
    writer.close();
  }

  private static int solve(String s1, String s2, int i, int j) {
    if (dp[i][j] != -1) {
      return dp[i][j];
    } else if (s1.length() == i && s2.length() == j) {
      return 0;
    } else if (s1.length() == i) {
      return s2.length() - j;
    } else if (s2.length() == j) {
      return s1.length() - i;
    } else {
      if (s1.charAt(i) == s2.charAt(j)) {
        return solve(s1, s2, i+1, j+1);
      } else {

        dp[i][j] = 1 + Math.min(solve(s1, s2, i+1, j+1),
            Math.min(solve(s1, s2, i+1, j),
                solve(s1, s2, i, j+1)));
        return dp[i][j];
      }
    }
  }
}
