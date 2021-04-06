package boj;

import java.util.Scanner;

public class Boj1328 {
    static long[][][] dp;
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, l, r;
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        dp = new long[n + 1][n + 1][n + 1];
        dp[1][1][1] = 1;
        for (int k = 2; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j][k] = (dp[i - 1][j][k - 1] + dp[i][j - 1][k - 1] + (k - 2) * dp[i][j][k - 1])%MOD;
                }
            }
        }
        System.out.println(dp[l][r][n]);
    }
}
