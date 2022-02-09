package dp.cses;

import java.io.*;
import java.util.StringTokenizer;

public class RemovingDigits {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    final int n = Integer.parseInt(tokenizer.nextToken());

    final int[] minimumSubToReach0 = new int[n+1];
    for (int i = 1; i <= 9 && i <= n; i++) minimumSubToReach0[i] = 1;
    for (int i = 10; i <= n; i++) {
      minimumSubToReach0[i] = Integer.MAX_VALUE - 1;
      int[] digits = digits(i);
      for (int j = 0; j < digits.length; j++) {
        minimumSubToReach0[i] = Math.min(minimumSubToReach0[i], 1 + minimumSubToReach0[i - digits[j]]);
      }
    }
    writer.println(minimumSubToReach0[n]);
    writer.close();
  }

  private static int[] digits(int n) {
    String num = Integer.toString(n);
    int[] digits = new int[num.length()];
    for (int i = 0; i < num.length(); i++) {
      digits[i] = n % 10;
      n /= 10;
    }
    return digits;
  }
}
