package dp.cses;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimizingCoins {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    final int m = Integer.parseInt(tokenizer.nextToken());
    final int n = Integer.parseInt(tokenizer.nextToken());

    final long[] minimumNumOfCoins = new long[n+1];
    for (int i = 1; i <= n; i++) minimumNumOfCoins[i] = Long.MAX_VALUE;

    final int[] coinsValue = Arrays.stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();




    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < m; j++) {
        if (i - coinsValue[j] >= 0 && minimumNumOfCoins[i - coinsValue[j]] != Long.MAX_VALUE) {
          minimumNumOfCoins[i] = Math.min(minimumNumOfCoins[i], minimumNumOfCoins[i - coinsValue[j]] + 1);
        }
      }
    }

    writer.println(minimumNumOfCoins[n] == Long.MAX_VALUE ? -1 : minimumNumOfCoins[n]);
    writer.close();
  }
}
