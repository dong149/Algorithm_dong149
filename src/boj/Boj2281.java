package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2281 {
    static int n,m;
    static int[] a;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 가로의 길이
        m = sc.nextInt();
        a = new int[1010];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        dp = new int[1010][1010];
        for(int i=0;i<1010;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(1,a[0]+1));
    }
    public static int dfs(int index,int length){
        if (index >= n)
            return 0;

        if (dp[index][length] != -1) return dp[index][length];

        dp[index][length] = -1;
        dp[index][length] = (m - length + 1) * (m - length + 1) + dfs(index + 1, a[index] + 1);

        if (length + a[index] <= m)
            dp[index][length] = Math.min(dp[index][length], dfs(index + 1, length + a[index] + 1));

        return dp[index][length];
    }
}
