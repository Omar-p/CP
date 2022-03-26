package dp.cses;

import java.util.Scanner;

public class TwoSetsII {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int sum = n * (n + 1) / 2;
    if (sum % 2 != 0) {
      System.out.println(0);
      return;
    }

    sum /= 2;
    int[][] dp = new int[n+1][sum+1];
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      dp[i][0] = 1;
      for(int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i-1][j];
        if (j >= i) dp[i][j] += dp[i-1][j - i];
        dp[i][j] %= 1_000_000_007;
      }
    }
    System.out.println(dp[n][sum] / 2);
  }
}