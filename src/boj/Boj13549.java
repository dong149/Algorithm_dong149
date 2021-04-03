package boj;

import java.util.*;

public class Boj13549 {
    public static class Node implements Comparable<Node>{
        int end;
        int val;
        public Node(int end,int val){
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val-o.val;
        }
    }
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        dist = new int[200001];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[n] = 0;
        visited = new boolean[210000];
        bfs(n,k);
        System.out.println(dist[k]);
    }

    public static void bfs(int start,int k){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            int cur = node.end;
//            System.out.println(cur);
            int curD = dist[cur];
            if(visited[cur])
                continue;
            visited[cur]=true;
            if(cur==k)
                return;
            if(cur+1<200001){
                dist[cur+1] = Math.min(dist[cur]+1,dist[cur+1]);
                if(!visited[cur+1]){
                    q.add(new Node(cur+1,dist[cur+1]));
                }
            }
            if(cur-1>=0){
                dist[cur-1] = Math.min(dist[cur]+1,dist[cur-1]);
                if(!visited[cur-1]){
                    q.add(new Node(cur-1,dist[cur-1]));
                }
            }
            if(cur*2<200001){
                dist[cur*2] = Math.min(dist[cur],dist[cur*2]);
                if(!visited[cur*2]){
                    q.add(new Node(cur*2,dist[cur*2]));
                }
            }
        }
    }
}
