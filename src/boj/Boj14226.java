package boj;

import java.util.Scanner;


//다시하기
public class Boj14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] dp = new int[s+1];
        dp[1] = 0;
        dp[2] = 2;
        for(int i=3;i<=s;i++){
            if(i%2==1){
                dp[i] = i/2+2;
            }else{
                dp[i] = dp[i/2]+2;
            }
        }
        System.out.println(dp[s]);
    }
}
