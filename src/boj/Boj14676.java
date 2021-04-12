package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj14676 {
    static int n, m, k;
    static int[] parentNum;
    static int[] curNum;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static boolean isCorrect = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        parentNum = new int[n + 1];
        curNum = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            parentNum[b]++;
            map.get(a).add(b);
        }
        for (int i = 0; i < k; i++) {
            int a, b;
            int cnt = 0;
            a = sc.nextInt();
            b = sc.nextInt();
            if (!isCorrect)
                continue;
            if (a == 1) {
                if (parentNum[b] > 0) {
                    isCorrect = false;
                    continue;
                }
                curNum[b]++;
                if (curNum[b] == 1) {
                    for (int temp : map.get(b)) {
                        parentNum[temp]--;
                    }
                }

            } else {
                if (curNum[b] == 0) {
                    isCorrect = false;
                    continue;
                }
                curNum[b]--;
                if (curNum[b] == 0) {
                    for (int temp : map.get(b)) {
                        parentNum[temp]++;
                    }
                }

            }
        }

        if (isCorrect)
            System.out.println("King-God-Emperor");
        else
            System.out.println("Lier!");

    }
}
