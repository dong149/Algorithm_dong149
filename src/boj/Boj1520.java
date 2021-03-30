package boj;

import java.util.Scanner;

public class Boj1520 {
    public static int[] dy = {0, 0, 1, -1};
    public static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        visited[0][0] = true;
        int res = dfs(arr, visited,dp, 0, 0, m, n);

        System.out.println(res);
    }

    public static int dfs(int[][] arr, boolean[][] visited,int[][] dp, int x, int y, int m, int n) {
        if (x == m-1 && y == n-1) {
            return 1;
        }
        if(dp[x][y]>=0)
            return dp[x][y];

        int sum=0;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nY >= 0 && nX < m && nY < n  && arr[nX][nY] < arr[x][y]) {

//                visited[nX][nY] = true;
                sum += dfs(arr, visited,dp, nX, nY, m, n);
//                visited[nX][nY] = false;

            }
        }

        dp[x][y] = sum;
        return sum;


    }


}
