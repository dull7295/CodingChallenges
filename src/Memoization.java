import java.util.Arrays;

/**
 * Created by dullam on 3/1/18.
 */
public class Memoization {
    static int[] dp;
    private static int fib(int n) {
        if(n == 0 || n == 1) {
            dp[n] = n;
            return dp[n];
        }
        if(dp[n] != -1)  {
            return dp[n];
        } else {
            dp[n] = fib(n-1) + fib(n-2);
            return dp[n];
        }

    }
    public static void main(String[] args) {
        int n = 10;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(" " + fib(n));
        for(int i: dp) {
            System.out.print(" " + i);
        }
    }
}
