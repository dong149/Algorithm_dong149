package boj;

import java.util.Scanner;

public class Boj1890 {
    static int n;
    static int[][] a;
    static long[][] dp;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        dp = new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }

        dp[0][0]= 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]>0)
                    continue;
                check(i,j);
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(dp[n-1][n-1]);
    }
    public static void check(int x,int y){
        long sum=0;
        for(int i=1;i<n;i++){
            if(y-i>=0&&a[x][y-i]==i){
                sum+=dp[x][y-i];
            }
        }
        for(int i=1;i<n;i++){
            if(x-i>=0&&a[x-i][y]==i){
                sum+=dp[x-i][y];
            }
        }

        dp[x][y] = sum;
    }
}
