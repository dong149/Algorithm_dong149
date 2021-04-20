package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj2638 {
    static int n, m;
    static int[][] map;
    static boolean[][] outOne;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        outOne = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int time = 0;
        while (true) {
            int cCnt = 0;
            ArrayList<Node> li = new ArrayList<>();
            boolean[][] visited = new boolean[n][m];
            dfs(0, 0, visited);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && check(i, j)) {
                        li.add(new Node(i, j));
                    }
                    if (map[i][j] == 1) {
                        cCnt++;
                    }
                }
            }
            for (Node cur : li) {
                map[cur.x][cur.y] = 0;
            }

            if (cCnt == 0)
                break;
            time++;
        }

        System.out.println(time);

    }

    public static boolean check(int x, int y) {
        int zCnt = 0;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < n && nY >= 0 && nY < m && map[nX][nY] == 0 && outOne[nX][nY]) {
                zCnt++;
            }
        }
        if (zCnt >= 2)
            return true;
        return false;
    }

    public static void dfs(int x, int y, boolean[][] visited) {
        outOne[x][y] = true;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < n && nY >= 0 && nY < m && !visited[nX][nY] && map[nX][nY] == 0) {
                dfs(nX, nY, visited);
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
