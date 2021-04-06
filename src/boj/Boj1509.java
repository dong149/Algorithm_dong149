package boj;

import java.util.Scanner;

public class Boj1509 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        boolean[][] check = new boolean[str.length + 1][str.length + 1];
        for (int j = 1; j <= str.length; j++) {
            for (int i = 1; i <= j; i++) {
                if (str[i - 1] == str[j - 1]) {
                    if (i == j) {
                        check[i][j] = true;
                    } else if (j - i == 1) {
                        check[i][j] = true;

                    } else if (j - i > 1 && check[i + 1][j - 1]) {
                        check[i][j] = true;
                    }
                }

            }
        }
        int[] dp = new int[str.length + 1];
        for (int j = 1; j <= str.length; j++) {
            int temp = 0;
            dp[j] = dp[j-1]+1;
            for (int i = 1; i <= j; i++) {
                if (check[i][j]) {
                    temp = i;
                    dp[j] = Math.min(dp[temp - 1] + 1,dp[j]);
//                    break;
                }
            }
        }


        System.out.println(dp[str.length]);
    }
}


