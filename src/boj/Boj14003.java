package boj;

import java.util.Scanner;
import java.util.Stack;

public class Boj14003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[(int)(n + 1)];
        long[] dp = new long[(int)(n + 1)];
        int[] dpIdx = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
            dp[i] = -1000000001;
        }
        dp[0] = -1000000001;
//        System.out.println(dp[0]);
//        System.out.println(dp[1]);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[cnt] < a[i]) {
//                System.out.println("check");
                cnt++;
                dp[cnt] = a[i];
                dpIdx[i] = cnt;
            } else {
                int left = 1;
                int right = cnt;
                int mid = 0;
                int res = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (dp[mid] >= a[i]) {
                        res = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                dp[res] = a[i];
                dpIdx[i] = res;
            }
        }
        System.out.println(cnt);
        Stack<Long> st = new Stack<>();
        for(int j=n;j>=1;j--){
            if(dpIdx[j]==cnt){
                int count = cnt;
                 for(int k=j;k>=1;k--){
                     if(dpIdx[k]==count){
                         st.push(a[k]);
                         count--;
                     }
                     if(count==0)
                         break;
                 }
                 break;
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
//        for (int j = 1; j <= cnt; j++) {
//            System.out.print(dp[j] + " ");
//        }
//        System.out.println();
    }
}
