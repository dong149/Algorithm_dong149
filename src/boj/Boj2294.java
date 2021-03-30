package boj;

import java.util.Scanner;

public class Boj2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] w = new int[n+1];
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            w[i] = sc.nextInt();
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++) {
                int temp1=Integer.MAX_VALUE;
                int temp2=Integer.MAX_VALUE;
                int temp3=Integer.MAX_VALUE;
                if(j%w[i]==0)
                    temp1 = j/w[i];
                if(dp[i-1][j]!=0)
                    temp2 = dp[i-1][j];
                if(j-w[i]>0&&dp[i][j-w[i]]>0)
                    temp3 = dp[i][j-w[i]]+1;
                dp[i][j] = Math.min(temp1,Math.min(temp2,temp3));
                if(dp[i][j]==Integer.MAX_VALUE)
                    dp[i][j] =0;
            }
        }

        if(dp[n][k]==0){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[n][k]);


    }
}
