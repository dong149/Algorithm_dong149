package boj;

import java.util.Scanner;

public class Boj2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] a = new int[n];
        long left = 1;
        long right = 0;
        long mid = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            right += a[i];
            left = Math.max(a[i], left);
        }
        //  크기를 이분 탐색하자.
        while (left <= right) {
            mid = (left + right) / 2;
            long sum = 0;
            long blue = 1;
            for (int i = 0; i < n; i++) {
                //sum => 현재 총합, blue => 현재 블루레이 수
                if (sum + a[i] > mid) {
                    blue++;
                    sum = a[i];
                } else {
                    sum += a[i];
                }
            }
            if (blue <= m) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res);
    }


}
