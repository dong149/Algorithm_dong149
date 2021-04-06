package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj5557 {
    static long res = 0;
    static long[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        dp = new long[n][21][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 21; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        res = dfs(a, 0, n, a[0], a[n - 1]);
        System.out.println(res);
    }

    public static long dfs(int[] a, int cnt, int n, int cur, int goal) {
//        System.out.println(cur);
        if (cur < 0 || cur > 20)
            return 0;

        if (cnt == n - 2) {
            if (cur == goal)
                return 1;
            else
                return 0;
        }

        if (dp[cnt][cur][0] < 0) {
            dp[cnt][cur][0] = dfs(a, cnt + 1, n, cur + a[cnt + 1], goal);
        }
        if (dp[cnt][cur][1] < 0) {
            dp[cnt][cur][1] = dfs(a, cnt + 1, n, cur - a[cnt + 1], goal);
        }
        long sum = 0;
        if (dp[cnt][cur][0] > 0) {
            sum += dp[cnt][cur][0];
        }
        if (dp[cnt][cur][1] > 0) {
            sum += dp[cnt][cur][1];
        }
        return sum;
    }
}
