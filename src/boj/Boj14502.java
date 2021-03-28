package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj14502 {

    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int max = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int inV = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1 || map[i][j] == 2)
                    visited[i][j] = true;
                if (map[i][j] == 0)
                    inV++;
            }
        }

        // 3 walls
        dfs(map, visited, 0, n, m, inV);
        System.out.println(max);

    }

    public static void dfs(int[][] map, boolean[][] visited, int cnt, int n, int m, int inV) {
        if (cnt == 3) {
            // inV-3 값 넣어주기
            bfs(map, visited, n, m, inV - 3);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    visited[i][j] = true;
                    dfs(map, visited, cnt + 1, n, m, inV);
                    map[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void bfs(int[][] map, boolean[][] visited, int n, int m, int inV) {
        // add virus in queue
        int res = inV;
        boolean[][] nVisited = new boolean[n][m];
        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2)
                    q.add(new Pos(i, j));
                nVisited[i][j] = visited[i][j];
            }
        }
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int cX = cur.x;
            int cY = cur.y;
            for (int i = 0; i < 4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                if (nX >= 0 && nX < n && nY >= 0 && nY < m && !nVisited[nX][nY]) {
                    nVisited[nX][nY] = true;
                    res--;
                    q.add(new Pos(nX, nY));
                }
            }
        }
        max = Math.max(max, res);
    }
}
