package boj;

import java.util.Scanner;

public class Boj9251 {


    public static void main(String[] args) {
        char[] a;
        char[] b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine().toCharArray();
        b = sc.nextLine().toCharArray();

        int[][] dp = new int[a.length+1][b.length+1];

        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=b.length;j++){
                if(a[i-1]==b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[a.length][b.length]);

    }
}

