package boj;

import java.util.Scanner;

public class Boj1958 {
    static int[][][] dp;
    static char[] a;
    static char[] b;
    static char[] c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine().toCharArray();
        b = sc.nextLine().toCharArray();
        c = sc.nextLine().toCharArray();
        dp = new int[a.length+1][b.length+1][c.length+1];
        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=b.length;j++){
                for(int k=1;k<=c.length;k++){
                    if(a[i-1]==b[j-1]&&b[j-1]==c[k-1]){
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                    }else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
                    }
                }
            }
        }
        System.out.println(dp[a.length][b.length][c.length]);
    }
}
