package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj16197 {
    static int n, m;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][][] visited;
    static int res = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        ArrayList<Integer> pos = new ArrayList<>();
        map = new char[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'o') {
                    pos.add(i);
                    pos.add(j);
                }
            }
        }
        dfs(pos.get(0), pos.get(1), pos.get(2), pos.get(3), 0);

        if (res == 1000) {
            res = -1;
        }
        System.out.println(res);

    }

    public static void dfs(int x1, int y1, int x2, int y2, int cnt) {
        if (cnt > 10) {
            return;
        }
        if (isFall(x1, y1) && isFall(x2, y2)) {
            return;
        }
        if (isFall(x1, y1)) {
            if (!isFall(x2, y2)) {
                res = Math.min(res, cnt);
                return;
            }
        }
        if (isFall(x2, y2)) {
            if (!isFall(x1, y1)) {
                res = Math.min(res, cnt);
                return;
            }
        }


        for (int i = 0; i < 4; i++) {
            int nX1 = x1 + dx[i];
            int nY1 = y1 + dy[i];
            int nX2 = x2 + dx[i];
            int nY2 = y2 + dy[i];

            if (!isFall(nX1, nY1)) {
                if (map[nX1][nY1] == '#') {
                    nX1 = x1;
                    nY1 = y1;
                }
            }
            if (!isFall(nX2, nY2)) {
                if (map[nX2][nY2] == '#') {
                    nX2 = x2;
                    nY2 = y2;
                }
            }
            dfs(nX1, nY1, nX2, nY2, cnt + 1);
        }


    }

    public static boolean isFall(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return true;
        } else {
            return false;
        }
    }


}
