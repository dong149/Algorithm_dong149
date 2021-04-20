package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj17086 {
    static int n, m;
    static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    check(i, j);
                }
            }
        }


        System.out.println(ans);


    }

    public static void check(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (map[cur[0]][cur[1]] == 1) {
                ans = Math.max(ans, cur[2]);
                return;
            }
            int nX, nY;
            for (int i = 0; i < 8; i++) {
                nX = cur[0] + dx[i];
                nY = cur[1] + dy[i];
                if (nX >= 0 && nX < n && nY >= 0 && nY < m && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    q.add(new int[]{nX, nY, cur[2] + 1});
                }
            }

        }

    }
}
