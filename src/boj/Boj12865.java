package boj;

import java.util.Scanner;

public class Boj12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        // 무게
        int[] w = new int[n+1];
        // 가치
        int[] v = new int[n+1];

        for(int i=1;i<=n;i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = dp[i-1][j];
                if(w[i]<=j){
                    dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i],dp[i-1][j]);
                }
            }
        }
//        for(int i=1;i<=n;i++){
//            for(int j=0;j<=k;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][k]);
    }
}
