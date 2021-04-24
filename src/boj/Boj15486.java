package boj;
import java.util.*;
public class Boj15486 {
    static int n;
    static int[] t;
    static int[] p;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n];
        p = new int[n];
        dp = new int[n+1];

        for(int i=0;i<n;i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for(int i=n-1;i>=0;i--){
            if(i+t[i]>n){
                dp[i] = dp[i+1];
            }else{
                dp[i] = Math.max(dp[i+t[i]] + p[i],dp[i+1]);
            }
        }
        System.out.println(dp[0]);
    }
}
