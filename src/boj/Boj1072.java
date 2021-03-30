package boj;

import java.util.Scanner;

public class Boj1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y;
        x = sc.nextLong();
        y = sc.nextLong();

        // win rate
        long z = 100 * y / x;

        long left = 1;
        long right = x;
        long mid = 0;
        long res = 0;

        if (z >= 99) {
            System.out.println(-1);
            return;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            long zTemp = 100*(y+mid)/(x+mid);
            if (zTemp != z) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res);

    }
}
