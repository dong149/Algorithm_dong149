package boj;

import java.util.Scanner;

public class Boj12738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[(int)(n + 1)];
        long[] dp = new long[(int)(n + 1)];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
            dp[i] = -1000000001;
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
        System.out.println(cnt);
    }
}
