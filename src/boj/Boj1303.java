package boj;

import java.util.Scanner;

public class Boj1303 {
    static int n,m ;
    static char[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        m=  Integer.parseInt(input[0]);
        n=  Integer.parseInt(input[1]);
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            map[i] = sc.nextLine().toCharArray();
        }
        int w=0,b=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    int res = dfs(i,j);
                    if(map[i][j]=='W'){
                        w+=res*res;
                    }else{
                        b+=res*res;
                    }
                }
            }
        }
        System.out.println(w+" "+b);



    }
    public static int dfs(int x,int y){
        visited[x][y] =true;
        char side = map[x][y];
        int nX,nY;
        int cnt=1;
        for(int i=0;i<4;i++){
            nX = x+dx[i];
            nY = y+dy[i];
            if(nX>=0&&nX<n&&nY>=0&&nY<m&&!visited[nX][nY]&&map[nX][nY]==side){
                cnt+=dfs(nX,nY);
            }
        }
        return cnt;


    }
}
