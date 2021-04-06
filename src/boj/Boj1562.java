package boj;

import java.util.Scanner;

public class Boj1562 {
    static final long MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][][] dp = new long[n + 1][10][1 << 10];

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int visit = k | (1 << j);
                    dp[i][j][visit] = (dp[i][j][visit] + ((j < 9 ? dp[i - 1][j + 1][k] : 0) + (j > 0 ? dp[i - 1][j - 1][k] : 0)) % MOD) % MOD;
                }

            }
        }

        long res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[n][i][(1 << 10) - 1]) % MOD;
        }
        System.out.println(res);


    }
}
