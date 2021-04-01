package boj;

import java.util.Scanner;

public class Boj13711 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
//        int[] b = new int[n];
        int[] nb = new int[n];
        int[] dp = new int[n + 1];

        for (int i = 1; i < n+1; i++) {
            int temp = sc.nextInt();
            a[temp] = i;
        }
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            nb[i] = a[temp];
        }

//        for (int j = 0; j < n; j++) {
//            System.out.print(nb[j] + " ");
//        }
//        System.out.println();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (dp[cnt] < nb[i]) {
                cnt++;
                dp[cnt] = nb[i];
            } else {
                int left = 1;
                int right = cnt;
                int mid = 0;
                int res = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (dp[mid] >= nb[i]) {
                        res = mid;
                        right = mid - 1;
                    } else
                        left = mid + 1;
                }
                dp[res] = nb[i];
            }
        }
        System.out.println(cnt);
    }
}
