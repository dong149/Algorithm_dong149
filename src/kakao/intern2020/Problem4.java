package kakao.intern2020;

import java.util.Arrays;

public class Problem4 {
    public static void main(String[] args) {

        int[][] test = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        System.out.println(solution(test));
    }


    // 우 하 좌 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited;
    static int len;
    static int res = Integer.MAX_VALUE;
    static int[][] dp;

    public static int solution(int[][] board) {
        int answer = 0;

        visited = new boolean[board.length][board[0].length];
        visited[0][0] = true;
        len = board.length;
        dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        if (board[0][1] == 0) {
            visited[0][1] = true;
            dfs(new Pos(0, 1, 0, 100), board);
            visited[0][1] = false;
        }
        if (board[1][0] == 0) {
            visited[1][0] = true;
            dfs(new Pos(1, 0, 1, 100), board);
            visited[1][0] = false;
        }
        return res;
    }

    public static void dfs(Pos cur, int[][] board) {
//        System.out.println("x : "+cur.x+" y : "+cur.y+" cost : "+cur.cost);
        if (dp[cur.x][cur.y] < cur.cost) {
            return;
        } else {
            dp[cur.x][cur.y] = cur.cost;
        }
        if (cur.x == len - 1 && cur.y == len - 1) {
            res = Math.min(cur.cost, res);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nX = cur.x + dx[i];
            int nY = cur.y + dy[i];

            // 0->1,3  1->0,2 2->3,1 3->0,2
            if ((nX >= 0 && nX < len && nY >= 0 && nY < len) && !visited[nX][nY] && board[nX][nY] == 0) {
                visited[nX][nY] = true;
                if (Math.abs(cur.dir - i) == 1 || Math.abs(cur.dir - i) == 3) {
                    dfs(new Pos(nX, nY, i, cur.cost + 600), board);
                } else {
                    dfs(new Pos(nX, nY, i, cur.cost + 100), board);
                }
                visited[nX][nY] = false;
            }
        }
    }

    public static class Pos {
        int x;
        int y;
        int dir;
        int cost;

        public Pos(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

}
