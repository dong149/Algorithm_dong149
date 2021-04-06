package boj;

import java.util.Scanner;

public class Boj11049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n + 1][2];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int j = 1; j <= n; j++) {
            for (int i = j; i >= 1; i--) {
                if (i == j)
                    continue;
                int temp = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    temp = Math.min(dp[i][k] + dp[k + 1][j] + a[i][0] * a[k][1] * a[j][1], temp);
                }
                dp[i][j] = temp;
            }
        }

        System.out.println(dp[1][n]);


    }
}


