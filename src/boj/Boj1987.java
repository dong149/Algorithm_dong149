package boj;

import java.util.Scanner;

public class Boj1987 {
    static int r, c;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static boolean[] alpha;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new int[r][c];
        visited = new boolean[r][c];
        alpha = new boolean['Z' - 'A' + 1];
        for (int i = 0; i < r; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j) - 'A';
            }
        }
        alpha[map[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(res);
    }

    public static void dfs(int x, int y, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < r && nY >= 0 && nY < c && !alpha[map[nX][nY]]) {
                alpha[map[nX][nY]] = true;
                dfs(nX, nY, cnt + 1);
                alpha[map[nX][nY]] = false;
            }
        }
        res = Math.max(cnt, res);
    }
}
