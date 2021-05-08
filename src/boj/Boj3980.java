package boj;

import java.util.Scanner;

public class Boj3980 {
    static int T;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        while(T-->0){
            int[][] map = new int[11][11];
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    map[i][j] = sc.nextInt();
                }
            }

            boolean[] visited = new boolean[11];
            max=0;
            dfs(map,visited,0,0);


            sb.append(max).append('\n');
        }

        System.out.print(sb);
    }


    public static void dfs(int[][] map,boolean[] visited,int idx,int sum){

        if(idx==11){
            max = Math.max(max,sum);
            return;
        }
        for(int i=0;i<11;i++){
            if(map[idx][i]!=0&&!visited[i]){
                visited[i] = true;
                dfs(map,visited,idx+1,sum+map[idx][i]);
                visited[i] = false;
            }
        }


    }

}
