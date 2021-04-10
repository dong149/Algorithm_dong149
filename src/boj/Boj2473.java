package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2473 {
    static int n;
    static long[] a;
    static long[] ans = new long[3];
    static long res = 3000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        Arrays.sort(a);

        for (int i = 0; i < n - 2; i++) {
            long midN = a[i];
            int left = i+1;
            int right = n - 1;
            while (left < right) {
                long leftN = a[left];
                long rightN = a[right];
                if (res > Math.abs(leftN + rightN + midN)) {
                    res = Math.abs(leftN + rightN + midN);
                    ans[0] = midN;
                    ans[1] = leftN;
                    ans[2] = rightN;
                }
                if (leftN + rightN + midN> 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
