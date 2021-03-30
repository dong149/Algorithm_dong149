package boj;

import java.util.Scanner;

public class Boj11051 {

    static final int MOD = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        long[][] dp = new long[n+1][k+1];
        long res = solve(dp,n,k);
        System.out.println(res);
    }


    public static long solve(long[][] dp,int n,int k){
        if(n==k||k==0)
            return 1;
        if(dp[n][k]>0)
            return dp[n][k];
        dp[n][k] = (solve(dp,n-1,k-1)%MOD+solve(dp,n-1,k)%MOD)%MOD;
        return dp[n][k];
    }



}
