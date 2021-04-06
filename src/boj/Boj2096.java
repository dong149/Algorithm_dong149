package boj;

import java.util.Scanner;

public class Boj2096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+1][4];
        int[][] dp = new int[n+1][4];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<4;j++){
                a[i][j] = sc.nextInt();
            }
        }

        //max
        for(int i=1;i<n+1;i++){
            for(int j=1;j<4;j++){
                if(j==1)
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j+1])+a[i][j];
                else if(j==2)
                    dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i-1][j+1],dp[i-1][j-1]))+a[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+a[i][j];
            }
        }
        int max = Math.max(dp[n][1],Math.max(dp[n][2],dp[n][3]));
        System.out.print(max+" ");
        dp = new int[n+1][4];
        //min
        for(int i=1;i<n+1;i++){
            for(int j=1;j<4;j++){
                if(j==1)
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])+a[i][j];
                else if(j==2)
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j+1],dp[i-1][j-1]))+a[i][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+a[i][j];
            }
        }
        int min = Math.min(dp[n][1],Math.min(dp[n][2],dp[n][3]));
        System.out.print(min);
        System.out.println();
    }
}
