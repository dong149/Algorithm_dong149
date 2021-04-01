package boj;

import java.util.Scanner;

public class Boj3079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        long m;
        n = sc.nextInt();
        m = sc.nextLong();
        int[] a = new int[n];
        long max = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max = Math.max(a[i],max);
        }

        long left = 1;
        long right = max*m;
        long mid = 0;
        long res = 0;
        while (left <= right) {

            mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += mid / a[i];
            }
            if (sum >= m) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }


        System.out.println(res);


    }

}
