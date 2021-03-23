package boj;

import java.util.Scanner;

public class Boj15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            String res = String.valueOf(i + 1);
            visited[i] = true;
            dfs(res, visited, 1, i, n, m);
            visited[i] = false;
        }


    }

    private static void dfs(String res, boolean[] visited, int cnt, int cur, int n, int m) {
        if (cnt != m) {
            for (int i = cur; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(res + " " + (i + 1), visited, cnt + 1, i, n, m);
                    visited[i] = false;
                }
            }

        } else {
            System.out.println(res);
        }
    }


}
