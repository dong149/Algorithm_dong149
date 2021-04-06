package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2098 {
    static int[][] a;
    static int[][] dp;
    static final int INF = 16 * 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        int res = tsp(0, 1, n);
        System.out.println(res);


    }

    // cur 에서의 방문한 곳들이 visit대로인 상태에서, 모두 돌아 나에게까지로 오는 최단거리를 return 한다.
    public static int tsp(int cur, int visit, int n) {
        if (visit == (1 << n) - 1) {
            if (a[cur][0] == 0)
                return INF;
            else
                return a[cur][0];
        }
        if (dp[cur][visit] != INF)
            return dp[cur][visit];
        for (int next = 0; next < n; next++) {
            //
            if ((visit & (1 << next)) == 0 && a[cur][next] != 0) {
                dp[cur][visit] = Math.min(dp[cur][visit], tsp(next, visit | 1 << next, n) + a[cur][next]);
            }
        }
        return dp[cur][visit];


    }
}
