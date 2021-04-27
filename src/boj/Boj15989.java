package boj;

import java.util.*;



/*
수를 1개 이상 사용해서 합을 나타내야 함.
합을 이루고 있는 수의 순서만 다른 것은 같은 것.
즉 조합.

n을 1,2,3의 합으로 나타내는 방법의 수를 구해라.

1 = dp[i-1]+1;
2 = dp[2][1] = dp[0][

5 = dp[5][1] = dp[4][1] + d[4][2]+ dp[4][3];

4 - 2 2 1,3 -> 2




2 -> 1+1; 0+2

3 -> 1+2 2+1


2-> 1가지

ㅋ

6 -> 3,3
3,1,2

4 -> 1,2,3의 경우의수 더한값



9 -> 3, 6경우의수  2 7경우의수 1 8경우의 수 ( 3,2,3)
 */
public class Boj15989 {
    static int T;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        dp = new int[10001][4];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[2][1] = 1;
        dp[2][2] = 2;
        dp[2][3] = 2;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 3;
        for(int i=4;i<10001;i++){
            for(int j=1;j<=3;j++){
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][2] + dp[i][1];
                dp[i][3] = dp[i-3][3] + dp[i][2];
            }
        }



        while(T-->0){
            int n = sc.nextInt();
            sb.append(dp[n][3]).append('\n');
        }

        System.out.print(sb);
    }


}
