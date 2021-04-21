package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2606 {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
        }
        m = sc.nextInt();
        visited = new boolean[n+1];
        for(int i=0;i<m;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int res = bfs();
        System.out.println(res-1);


    }
    public static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int cnt=0;
        while (!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            for(int i=0;i<map.get(cur).size();i++){
                int next = map.get(cur).get(i);
                if(!visited[next]){
                   q.add(next);
                   visited[next] =true;
                }
            }

        }
        return cnt;

    }
}
