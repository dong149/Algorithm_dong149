package boj;

import java.util.Scanner;

public class Boj1365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }


        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[cnt] < a[i]) {
                cnt++;
                dp[cnt] = a[i];
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
            }
//            for (int j = 1; j <= cnt; j++) {
//                System.out.print(dp[j] + " ");
//            }
//            System.out.println();
        }
        System.out.println(n - cnt);
    }
}
