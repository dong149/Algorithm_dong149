package boj;

import java.util.Scanner;

public class Boj1915 {
    static int n, m;
    static int[][] a;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        dp = new int[n][m];
        int res = 0;
        sc.nextLine();
//        for(int i=0;i<n;i++){
//            String temp = sc.nextLine();
//            System.out.println(temp);
//        }
//
        for (int i = 0; i < n; i++) {
            char[] temp = sc.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                a[i][j] = temp[j]-'0';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res = Math.max(solve(i,j),res);
            }
        }
        System.out.println(res*res);
    }


    public static int solve(int x,int y) {
        if(x<0||y<0)
            return Integer.MAX_VALUE;
        if(x==0||y==0){
            if(a[x][y]==1)
                return 1;
            else
                return 0;
        }
//        System.out.print("x:"+x);
//        System.out.println(" y:"+y);
        if(a[x][y]==0) return 0;
        else{
            if(dp[x][y]>0)
                return dp[x][y];
        }

        dp[x][y] = Math.min(solve(x-1,y),Math.min(solve(x-1,y-1),solve(x,y-1)))+1;
        return dp[x][y];
    }


}
