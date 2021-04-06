package boj;

import java.util.Scanner;

public class Boj14500 {
    static int res=0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m ;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] a = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]= sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] =true;
                dfs(visited,a,i,j,n,m,1,a[i][j]);
                visited[i][j] = false;
                for(int k=0;k<4;k++) {

                    if(i-1>=0&&j-1>=0&&j+1<m){
                        res = Math.max(res,a[i][j]+a[i-1][j]+a[i][j-1]+a[i][j+1]);
                    }
                    if(i-1>=0&&i+1<n&&j+1<m){
                        res = Math.max(res,a[i][j]+a[i-1][j]+a[i][j+1]+a[i+1][j]);
                    }
                    if(i+1<n&&j-1>=0&&j+1<m){
                        res = Math.max(res,a[i][j]+a[i][j+1]+a[i+1][j]+a[i][j-1]);
                    }
                    if(i-1>=0&&i+1<n&&j-1>=0){
                        res = Math.max(res,a[i][j]+a[i][j-1]+a[i-1][j]+a[i+1][j]);
                    }
                }
            }
        }


        System.out.println(res);

    }


    public static void dfs(boolean[][] visited,int[][] arr,int x,int y,int n,int m,int cnt,int sum){
        if(cnt==4){
            res= Math.max(sum,res);
            return;
        }
        for(int i=0;i<4;i++){
            int nX = x+dx[i];
            int nY = y+dy[i];
            if(nX>=0&&nX<n&&nY>=0&&nY<m&&!visited[nX][nY]){
                visited[nX][nY] = true;
                dfs(visited,arr,nX,nY,n,m,cnt+1,sum+arr[nX][nY]);
                visited[nX][nY] = false;
            }
        }

    }
}
