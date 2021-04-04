package boj;

import java.util.Scanner;

public class Boj10942 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<=j;i++){
                if(i==j){
                    dp[i][j] = true;
                }else{
                    // 1 1
                    if(i+1==j&&arr[i]==arr[j]){
                        dp[i][j] = true;
                    }
                    else if(dp[i+1][j-1]&&arr[i]==arr[j])
                        dp[i][j] = true;
                }
            }
        }

        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            if(dp[a-1][b-1]){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }

        System.out.print(sb);
    }



}
