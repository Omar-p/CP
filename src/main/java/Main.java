import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt(), m = scanner.nextInt();
    scanner.nextLine();
    String s = scanner.nextLine();
    String[] nums = s.split(" ");
    int c = Math.abs(Integer.parseInt(nums[n]));
    int sum = Arrays.stream(nums).map(Integer::parseInt).reduce(0, (a,b)->a+b);
    System.out.println((sum == 0 || c % m == 0) ? 1 : -1);
  }
}
//    );
//    int[] primes = new int[n+1];
//    Arrays.fill(primes, 1);
//    primes[0] = 0;
//    primes[1] = 0;
//    for (int i = 0; i <= n; i++) {
//      if (primes[i] == 1) {
//        for (int j = 2; j * i <= n; j++) {
//          primes[j*i] = 0;
//        }
//      }
//    }
//    int sum = 0;
//    for (int i = 2; i <= n; i++) {
//      if (primes[i] == 0) {
//        for (int j = 2; ; j++) {
//          if (primes[j] == 1 && i%j == 0) {
//            sum += j;
//            break;
//          }
//        }
//      }
//    }
//    System.out.println(sum);
//  }
//}
