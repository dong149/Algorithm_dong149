package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj7453 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[cnt] = a[i] + b[j];
                cd[cnt] = c[i] + d[j];
                cnt++;
            }
        }
        // ab -> 오름차순
        Arrays.sort(ab);
        // cd -> 내림차순
        Arrays.sort(cd);

        long res = 0;
        int abI = 0;
        int cdI = n * n - 1;
        int x = 0;
        int y = 0;
        int toSum = 0;
        while (abI < (n * n) && cdI >= 0) {
//            System.out.println(x);
//            System.out.println(y);
            x = ab[abI];
            y = cd[cdI];
            toSum = x + y;
//            System.out.println(toSum);

            if (toSum == 0) {
                long abCnt = 0;
                long cdCnt = 0;
                while (abI < (n * n) && x == ab[abI]) {
//                    System.out.println(abI);
                    abI++;
                    abCnt++;
                }
                while (cdI >= 0 && y == cd[cdI]) {
//                    System.out.println("cdI:"+cdI);
                    cdI--;
                    cdCnt++;
                }
                res += abCnt * cdCnt;
            } else if (toSum > 0) {
                cdI--;
            } else {
                abI++;
            }
        }
        System.out.println(res);
    }
}

