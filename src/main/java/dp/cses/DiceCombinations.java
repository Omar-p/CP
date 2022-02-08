package dp.cses;

import java.io.*;
import java.util.StringTokenizer;

public class DiceCombinations {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    final int n = Integer.parseInt(tokenizer.nextToken());

    final long[] ways = new long[n+1];
    ways[0] = 1;

    final int[] diceValues = {1,2,3,4,5,6};
    final int LEN = diceValues.length;

    final long MOD = 1_000_000_007L;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < LEN; j++) {
        if (i - diceValues[j] >= 0) {
          ways[i] += ways[i - diceValues[j]];
          ways[i] %= MOD;
        }
      }
    }

    writer.println(ways[n]);
    writer.close();
  }
}
