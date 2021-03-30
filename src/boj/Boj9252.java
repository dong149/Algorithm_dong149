package boj;

import java.util.Scanner;

public class Boj9252 {


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

//        for(int i=0;i<a.length+1;i++){
//            for(int j=0;j<b.length+1;j++){
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
        int temp1 = dp[a.length][b.length];
        int temp2 = temp1-1;
        String res="";
        for(int i=a.length;i>=1;i--){
            for(int j=b.length;j>=1;j--){
                if(dp[i][j]==temp1&&dp[i][j-1]==temp2&&dp[i-1][j-1]==temp2&&dp[i-1][j]==temp2){
                    res = a[i-1]+res;
                    temp1--;
                    temp2--;
                    break;
                }
            }
        }
        System.out.println(dp[a.length][b.length]);
        System.out.println(res);

    }
}

