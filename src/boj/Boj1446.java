package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1446 {
    public static class Edge{
        int end;
        int val;

        public Edge(int end,int val){
            this.end = end;
            this.val = val;
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,d;
        n = sc.nextInt();
        d = sc.nextInt();
        ArrayList<ArrayList<Edge>> map = new ArrayList<>();
        boolean[] visited = new boolean[d+1];
        int[] dist = new int[d+1];
        for(int i=0;i<d;i++){
            map.add(new ArrayList<>());
            map.get(i).add(new Edge(i+1,1));
        }
        for(int i=0;i<n;i++){
            int start,end,val;
            start = sc.nextInt();
            end = sc.nextInt();
            val = sc.nextInt();
            if(end>d||end-start<val){
                continue;
            }
            map.get(start).add(new Edge(end,val));
        }
        for(int i=0;i<d+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        bfs(map,visited,dist,0,d);
        System.out.println(dist[d]);
    }

    public static void bfs(ArrayList<ArrayList<Edge>> map,boolean[] visited,int[] dist,int start,int goal){
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            int curD = dist[cur];
            if(cur==goal){
                break;
            }

            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(Edge edge : map.get(cur)){
                int end = edge.end;
                int val = edge.val;
                dist[end] = Math.min(dist[end], curD + val);
                if(dist[end]<min){
                    min = dist[end];
                    minIdx = end;
                }
            }
            q.add(minIdx);
        }
    }
}
