package boj;

import java.util.Scanner;

public class Boj17404 {
    static final int INF = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];
        int ans=INF;
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // 0-> 빨간색을 0번에 칠한 경우
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==j){
                    dp[0][j] = arr[0][j];
                }else{
                    dp[0][j] = INF;
                }
            }

            for(int j=1;j<n;j++){
                dp[j][0] = Math.min(dp[j-1][1],dp[j-1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j-1][0],dp[j-1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j-1][0],dp[j-1][1]) + arr[j][2];
            }

            for(int j=0;j<3;j++){
                if(i!=j){
                    if(dp[n-1][j]<ans){
                        ans = dp[n-1][j];
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
