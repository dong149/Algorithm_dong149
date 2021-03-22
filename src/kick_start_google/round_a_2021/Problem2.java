package kick_start_google.round_a_2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2 {

    private static int cnt;
    private static int[] dy = {-1, 1, -1, 0, 0};
    private static int[] dx = {-1, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int r, c;
            String[] temp = br.readLine().split(" ");
            r = Integer.parseInt(temp[0]);
            c = Integer.parseInt(temp[1]);
            int[][] map = new int[r][c];
            boolean[][] visited = new boolean[r][c];

            for (int j = 0; j < r; j++) {
                String[] numList = br.readLine().split(" ");
                for (int k = 0; k < c; k++) {
                    map[j][k] = Integer.parseInt(numList[k]);
                }
            }
            cnt = 0;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        visited[j][k] = true;
                        dfs(map, visited, false, 0, j, k, 1, 0, r, c);
                        visited[j][k] = false;
                    }
                }
            }

            sb.append("Case #").append(i + 1).append(": ").append(cnt / 2).append("\n");

        }

        System.out.println(sb);
    }


    public static void dfs(int[][] map, boolean[][] visited, boolean dChange, int dir, int y, int x, int len1, int len2, int r, int c) {
        if (len2 > 1 && (len1 * 2 == len2 || len1 == len2 * 2) && dChange) {
//            System.out.println("y: " + y + " x: " + x);
//            System.out.println("len1: " + len1 + " len2: " + len2);
            cnt++;
//            return;
        }
        if (!dChange && dir == 0) {
            for (int i = 1; i <= 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    dfs(map, visited, false, i, nextY, nextX, 2, 0, r, c);
                    visited[nextY][nextX] = false;
                }
            }
        }
        if (!dChange && dir > 0) {
            int nextY;
            int nextX;
            if (dir == 1 || dir == 2) {
                nextY = y + dy[dir];
                nextX = x + dx[dir];
                if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    dfs(map, visited, false, dir, nextY, nextX, len1 + 1, 0, r, c);
                    visited[nextY][nextX] = false;
                }
                for (int i = 3; i <= 4; i++) {
                    nextY = y + dy[i];
                    nextX = x + dx[i];
                    if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                        visited[nextY][nextX] = true;
                        dfs(map, visited, true, i, nextY, nextX, len1, 2, r, c);
                        visited[nextY][nextX] = false;
                    }
                }
            }
            if (dir == 3 || dir == 4) {
                nextY = y + dy[dir];
                nextX = x + dx[dir];
                if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    dfs(map, visited, false, dir, nextY, nextX, len1 + 1, 0, r, c);
                    visited[nextY][nextX] = false;
                }
                for (int i = 1; i <= 2; i++) {
                    nextY = y + dy[i];
                    nextX = x + dx[i];
                    if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                        visited[nextY][nextX] = true;
                        dfs(map, visited, true, i, nextY, nextX, len1, 2, r, c);
                        visited[nextY][nextX] = false;
                    }
                }
            }

        }
        if (dChange && dir > 0) {
            int nextY = y + dy[dir];
            int nextX = x + dx[dir];
            if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                visited[nextY][nextX] = true;
                dfs(map, visited, true, dir, nextY, nextX, len1, len2 + 1, r, c);
                visited[nextY][nextX] = false;
            }

        }


    }

}
