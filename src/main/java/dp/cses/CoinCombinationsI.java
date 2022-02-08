package dp.cses;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinCombinationsI {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    final int m = Integer.parseInt(tokenizer.nextToken());
    final int n = Integer.parseInt(tokenizer.nextToken());

    final long[] waysToReachTo = new long[n+1];


    final int[] coinsValue = Arrays.stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    final int MOD = 1_000_000_007;;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < m; j++) {
        final int rest = i - coinsValue[j];
        if (rest == 0) {
          ++waysToReachTo[i];
          waysToReachTo[i] %= MOD;
        } else if (rest > 0) {
          waysToReachTo[i] += waysToReachTo[rest];
          waysToReachTo[i] %= MOD;
        }
      }
    }

    writer.println(waysToReachTo[n]);
    writer.close();
  }
}
