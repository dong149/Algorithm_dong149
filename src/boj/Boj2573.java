package boj;

import java.util.Scanner;

public class Boj2573 {
    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    // 덩어리 체크 하는 함수 1개 + 빙하 녹이는 함수 1개
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int year = 0;
        while (true) {
            // 몇 덩이리인지 확인
            int cnt = 0;
            int bergCnt = 0;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != 0) {
                        bergCnt++;
                    }
                    if (a[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        check(a, visited, i, j);
                        cnt++;
                    }
                }
            }
            if (bergCnt == 0) {
                System.out.println(0);
                return;
            }
            if (cnt >= 2)
                break;

            int[][] prevA = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    prevA[i][j] = a[i][j];
                }
            }
            // 1년 지나감
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != 0)
                        yearPass(a, prevA, i, j);
                }
            }
            year++;

        }
        System.out.println(year);
    }


    public static void check(int[][] a, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < n && nY >= 0 && nY < m && !visited[nX][nY] && a[nX][nY] != 0) {
                visited[nX][nY] = true;
                check(a, visited, nX, nY);
            }
        }
    }

    public static void yearPass(int[][] a, int[][] prevA, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < n && nY >= 0 && nY < m && prevA[nX][nY] == 0) {
                a[x][y] -= 1;
                if (a[x][y] == 0)
                    return;
            }
        }
    }
}
