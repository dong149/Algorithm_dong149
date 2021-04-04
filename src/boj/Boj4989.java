package boj;

import java.util.Scanner;

public class Boj4989 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[300000];
        // false -> prime;
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!prime[i])
                    cnt++;
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);

    }
}
