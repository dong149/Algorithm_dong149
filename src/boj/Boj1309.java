package boj;

import java.util.Scanner;

public class Boj1309 {
    static final int MOD = 9901;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int res = mem(dp,n);
        System.out.println(res);

    }

    public static int mem(int[] dp,int n){
        if(n==1)
            return 3;
        if(n==2)
            return 7;
        if(dp[n]>0)
            return dp[n];
        dp[n] = ((mem(dp,n-1)%MOD)*2+(mem(dp,n-2)%MOD))%MOD;
        return dp[n];
    }
}
