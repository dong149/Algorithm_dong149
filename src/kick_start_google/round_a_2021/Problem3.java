package kick_start_google.round_a_2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {
    public static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static long cnt;
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Pos> q = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int r, c;
            String[] temp = br.readLine().split(" ");
            r = Integer.parseInt(temp[0]);
            c = Integer.parseInt(temp[1]);
            int[][] map = new int[r][c];
            boolean[][] visited = new boolean[r][c];
            int max = -1;
            int startX = 0;
            int startY = 0;
            cnt = 0;
            for (int j = 0; j < r; j++) {
                String[] numList = br.readLine().split(" ");
                for (int k = 0; k < c; k++) {
                    int tempNum = Integer.parseInt(numList[k]);
                    if (tempNum > max) {
                        max = tempNum;
                        startY = j;
                        startX = k;
                    }
                    map[j][k] = tempNum;
                }
            }
            bfs(q, map, visited, r, c, startY, startX);
            sb.append("Case #").append(i + 1).append(": ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(Queue<Pos> q, int[][] map, boolean[][] visited, int r, int c, int startY, int startX) {
        q.add(new Pos(startY, startX));
        visited[startY][startX] = true;
        while (!q.isEmpty()) {
            Pos temp = q.poll();
            int curY = temp.y;
            int curX = temp.x;
            int curVal = map[curY][curX];
            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c && !visited[nextY][nextX]) {
                    if (curVal - map[nextY][nextX] > 1) {
                        cnt += (curVal - 1) - map[nextY][nextX];
                        map[nextY][nextX] = curVal - 1;
                    }
                    visited[nextY][nextX] = true;
                    q.add(new Pos(nextY, nextX));
                }
            }
        }
    }
}
