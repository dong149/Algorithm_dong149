package boj;

import java.util.Scanner;

public class Boj17070 {
    static int n;
    static int[][] a;
    static boolean[][] visited;
    static int[][][] dp;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        visited = new boolean[n][n];
        dp = new int[n][n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                for(int k=0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(dfs(0, 1, 0));
    }

    // dir -> 0 : 가로  , 1: 대각선 , 2: 세로
    public static int dfs(int x, int y, int dir) {
        if (x == n - 1 && y == n - 1)
            return 1;
//        if(dir==0){
//            if(dp[x][y][0]
//        }
//        int res=  checkDp(x,y,dir);
//        if(res>=0)
//            return res;
//        if (dp[x][y][dir] >= 0)
//            return dp[x][y][dir];
        int nX, nY;
        int sum = 0;
        if (dir == 0) {
            for (int i = 0; i < 2; i++) {
                nX = x + dx[i];
                nY = y + dy[i];
                if (check(nX, nY, i)) {
                    sum += dfs(nX, nY, i);
                }
            }
        } else if (dir == 1) {
            for (int i = 0; i < 3; i++) {
                nX = x + dx[i];
                nY = y + dy[i];
                if (check(nX, nY, i)) {
                    sum += dfs(nX, nY, i);
                }
            }
        } else {
            for (int i = 1; i < 3; i++) {
                nX = x + dx[i];
                nY = y + dy[i];
                if (check(nX, nY, i)) {
                    sum += dfs(nX, nY, i);
                }
            }
        }
        dp[x][y][dir] = sum;
        return dp[x][y][dir];
    }

    public static boolean check(int x, int y, int dir) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            int temp = a[x][y];
            if ((dir == 0||dir==2) && temp == 0) {
                return true;
            }
            if (dir == 1 && temp == 0 && a[x - 1][y] == 0 && a[x][y - 1] == 0) {
                return true;
            }
        }
        return false;
    }
//    public static int checkDp(int x,int y,int dir){
//        int sum=0;
//        boolean isRight=false;
//        if(dir==0) {
//            for(int i=0;i<2;i++){
//                int temp = dp[x][y][i];
//                if(temp>=0){
//                    isRight=true;
//                    sum+=temp;
//                }
//            }
//        }else if(dir==1) {
//            for (int i = 0; i < 3; i++) {
//                int temp = dp[x][y][i];
//                if (temp >= 0) {
//                    isRight = true;
//                    sum += temp;
//                }
//            }
//        }
//        else{
//            for(int i=1;i<3;i++){
//                int temp = dp[x][y][i];
//                if(temp>=0){
//                    isRight=true;
//                    sum+=temp;
//                }
//            }
//        }
//
//        if(isRight){
//            return sum;
//        }else{
//            return -1;
//        }
//    }
}
