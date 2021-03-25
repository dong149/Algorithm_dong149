package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2805 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        long res = bSearch(n, m);


        System.out.println(res);


    }


    public static long bSearch(int n, int m) {
        long start = 0;
        long end = arr[arr.length - 1] - 1;
        long res = 0;
        long mid;

        while (start <= end) {
            mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] - mid > 0) {
                    sum += arr[i] - mid;
                }
            }
            if (sum >= m) {
                start = mid + 1;
                res = mid;
            } else {
                end = mid - 1;
            }
        }


        return res;


    }


}
