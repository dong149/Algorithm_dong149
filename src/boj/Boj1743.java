package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1743 {
    static int n,m,k;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int res=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new boolean[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<k;i++){
                int a,b;
                a = sc.nextInt();
                b = sc.nextInt();
                map[a-1][b-1] = true;

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]&&!visited[i][j]){
                    res = Math.max(bfs(i,j),res);
                }
            }
        }

        System.out.println(res);

    }

    public static int bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int cnt=0;
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt++;
            int nX,nY;
            for(int i=0;i<4;i++){
                nX = cur[0]+dx[i];
                nY = cur[1]+dy[i];
                if(nX>=0&&nX<n&&nY>=0&&nY<m&&!visited[nX][nY]&&map[nX][nY]){
                    visited[nX][nY] = true;
                    q.add(new int[]{nX,nY});
                }
            }
        }
        return cnt;
    }
}
