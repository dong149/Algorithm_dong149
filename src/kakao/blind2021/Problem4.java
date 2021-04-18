package kakao.blind2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem4 {
    public static void main(String[] args) {
        int n=3;
        int s = 1;
        int a = 2;
        int b = 3;
        int[][] fares = {{1,2,10},{1,3,11},{2,3,12}};
        int res = solution(n,s,a,b,fares);
        System.out.println(res);
    }



    static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    static int[][] dist;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
        }
        dist = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dist[i],100000*n+1);
        }
        for(int i=0;i<fares.length;i++){
            map.get(fares[i][0]).add(new Node(fares[i][1],fares[i][2]));
            map.get(fares[i][1]).add(new Node(fares[i][0],fares[i][2]));
        }
        bfs(n,s);
        bfs(n,a);
        bfs(n,b);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            min = Math.min(dist[s][i]+dist[a][i]+dist[b][i],min);
        }



        int answer = min;
        return answer;
    }


    public static void bfs(int n ,int s){
        PriorityQueue<Node> pq =  new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        pq.add(new Node(s,0));
        dist[s][s] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.end]){
                continue;
            }else{
                visited[cur.end] = true;
            }
            for(int i=0;i<map.get(cur.end).size();i++){
                 Node next = map.get(cur.end).get(i);
                 if(dist[s][next.end]>dist[s][cur.end]+next.val){
                     dist[s][next.end] = dist[s][cur.end]+next.val;
                     pq.add(new Node(next.end,dist[s][next.end]));
                 }
//                 dist[s][next.end] = Math.min(dist[s][next.end],dist[s][cur.end]+next.val);
//                 if(!visited[next.end]){
//                     pq.add(next);
//                 }
            }
        }
    }


    public static class Node implements Comparable<Node>{
        int end;
        int val;

        public Node(int end,int val){
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val-o.val;
        }
    }
}
