package boj;

import java.util.Scanner;

public class Boj9663 {

    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[0][i] = true;
            dfs(map, 1, n);
            map[0][i] = false;
        }
        System.out.println(res);

    }

    private static void dfs(boolean[][] map, int cnt, int n) {
        if (n == cnt) {
            res++;
        } else {
            for (int i = 0; i < n; i++) {
                if (!map[cnt][i] && isRight(map, cnt, i, n)) {
                    map[cnt][i] = true;
                    dfs(map, cnt + 1, n);
                    map[cnt][i] = false;
                }
            }

        }
    }

    private static boolean isRight(boolean[][] map, int y, int x, int n) {
        for (int i = 0; i < n; i++) {
            if (map[y][i] && i != x) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (map[i][x] && i != y) {
                return false;
            }
        }
        // 대각선
        for (int i = 1; i < n; i++) {
            if (i + x >= n || i + y >= n) {
                break;
            }
            if (map[y + i][x + i])
                return false;
        }
        for (int i = 1; i < n; i++) {
            if (i + y >= n || x - i < 0) {
                break;
            }
            if (map[y + i][x - i])
                return false;
        }
        for (int i = 1; i < n; i++) {
            if (y - i < 0 || i + x >= n) {
                break;
            }
            if (map[y - i][x + i])
                return false;
        }
        for (int i = 1; i < n; i++) {
            if (y - i < 0 || x - i < 0) {
                break;
            }
            if (map[y - i][x - i])
                return false;
        }

        return true;

    }
}
