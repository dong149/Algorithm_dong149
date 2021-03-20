package scofe2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {
    static int[] arr;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        n = Integer.parseInt(temp);
        arr = new int[n];
        dp = new long[n];
        dp[0]=1;
        for(int i=0;i<n;i++){
            arr[i] = br.read()-'0';
        }
        long ans =dfs2(n-1);
        System.out.println(ans);
    }


    private static long dfs2(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            if(arr[n-1]==1)
                return 2;
            else
                return 1;
        }
        if(dp[n]>0){
            return dp[n];
        }
        if(arr[n-2]==1&&arr[n-1]==1){
            dp[n] = dfs2(n-2) + dfs2(n-1);
            return dp[n];
        }else if(arr[n-2]==0&&arr[n-1]==1) {
            dp[n] = dfs2(n-1);
            return dp[n];
        }else{
            dp[n] = dfs2(n-2);
            return dp[n];
        }


    }



}
