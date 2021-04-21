package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj2533 {
    static int n;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
        }
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        for(int i=0;i<n-1;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
    public static void dfs(int cur){

        dp[cur][0] = 0;
        dp[cur][1] = 1;
        visited[cur] = true;
        for(int i=0;i<map.get(cur).size();i++){
            int next = map.get(cur).get(i);
            if(!visited[next]){
                dfs(next);
                dp[cur][0] += dp[next][1];
                dp[cur][1] += Math.min(dp[next][0],dp[next][1]);
            }
        }
    }

}
