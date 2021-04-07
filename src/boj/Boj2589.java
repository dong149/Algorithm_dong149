package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2589 {
    static int n, m;
    static boolean[][] map;

    public static class Node {
        int x, y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int res = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'W') {
                    map[i][j] = false;
                } else
                    map[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]) {
                    boolean[][] visited = new boolean[n][m];
                    bfs(i, j, visited);
                }
            }
        }

        System.out.println(res);
    }

    public static void bfs(int x, int y, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cX = cur.x;
            int cY = cur.y;
            int cnt = cur.cnt;
            res = Math.max(cnt, res);
            for (int i = 0; i < 4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                if (nX >= 0 && nX < n && nY >= 0 && nY < m && !visited[nX][nY] && map[nX][nY]) {
                    visited[nX][nY] = true;
                    q.add(new Node(nX, nY, cnt + 1));
                }
            }
        }
    }
}
