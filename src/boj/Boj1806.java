package boj;

import java.util.Scanner;

public class Boj1806 {
    static int n, s;
    static int[] a;
    static final int MAX = 987654321;
    static int res = MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        while (true) {
            if (sum >= s) {
                sum -= a[p1++];
                res = Math.min(p2 - p1 + 1, res);
            } else if (p2 == n) {
                break;
            } else {
                sum += a[p2++];
            }
        }
        if (res == MAX) {
            System.out.println(0);
        } else
            System.out.println(res);
    }
}
