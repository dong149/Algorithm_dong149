package boj;

import java.util.Scanner;

public class Boj14503 {
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int res = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, c, d;
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited[r][c] = true;
        dfs(r,c,d,arr,visited);

        System.out.println(res);


    }
    public static void dfs(int r,int c,int d,int[][] arr,boolean[][] visited) {
        int nextD = d;
        int nextR;
        int nextC;
        for (int i = 1; i <= 4; i++) {
            nextD--;
            if (nextD < 0) {
                nextD = 3;
            }
            nextR = r + dx[nextD];
            nextC = c + dy[nextD];
            if (((nextR >= 0) && (nextR < n) && (nextC >= 0) && (nextC < m)) && !visited[nextR][nextC]&&arr[nextR][nextC]!=1) {
                visited[nextR][nextC] = true;
                res++;
                dfs(nextR, nextC, nextD, arr, visited);
                return;
            }
        }
        int backD = nextD;
        for (int i = 1; i <= 2; i++) {
            backD--;
            if (backD < 0) {
                backD = 3;
            }
        }
        nextR = r + dx[backD];
        nextC = c + dy[backD];
        if (((nextR >= 0) && (nextR < n) && (nextC >= 0) && (nextC < m)) && arr[nextR][nextC]!=1) {
            dfs(nextR, nextC, nextD, arr, visited);
        }
    }

}
