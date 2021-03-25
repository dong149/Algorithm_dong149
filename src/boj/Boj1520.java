package boj;

import java.util.Scanner;


// 다시.. 과몰입 오졌다.
public class Boj1520 {
    public static int[] dy = {0,0,1,-1};
    public static int[] dx = {1,-1,0,0};
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m,n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }


        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0)
                    continue;
                int temp=0;
                if(i-1>=0&&arr[i-1][j]>arr[i][j])
                    temp += dp[i-1][j];
                if(j-1>=0&&arr[i][j-1]>arr[i][j])
                    temp += dp[i][j-1];
                dp[i][j] = temp;
            }
        }
        visited[0][0] = true;
        dfs(dp,visited,0,0,m,n);
        System.out.println(ans);
    }

    public static void dfs(int[][] dp,boolean[][] visited,int y,int x,int m,int n){
        if(y==m-1&&x==n-1){
            ans++;
            return;
        }
        for(int i=0;i<4;i++){
            int nY = y+dy[i];
            int nX = x+dx[i];
            if(nY>=0&&nY<m&&nX>=0&&nX<n&&!visited[nY][nX]&&dp[nY][nX]>0){
                visited[nY][nX] = true;
                dfs(dp,visited,nY,nX,m,n);
                visited[nY][nX] = false;
            }
        }

    }

}
