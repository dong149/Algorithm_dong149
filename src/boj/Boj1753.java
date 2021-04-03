package boj;

import java.util.*;

public class Boj1753 {
    public static class Edge implements Comparable<Edge>{
        int end;
        int val;

        public Edge(int end,int val ){
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            return  val-o.val;
        }
    }
    public static List<Edge>[] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v,e,s;
        v = sc.nextInt();
        e = sc.nextInt();
        s = sc.nextInt();
        int[] d = new int[v+1];
        boolean[] visited = new boolean[v+1];
        map = new ArrayList[v+1];
        for(int i=0;i<v+1;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            int a,b,c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map[a].add(new Edge(b,c));
        }
        Arrays.fill(d,Integer.MAX_VALUE);
        d[s] = 0;
        bfs(d,visited,s,v);
        for(int i=1;i<=v;i++){
            if(d[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(d[i]);
            }
        }
    }

    public static void bfs(int[] d,boolean[] visited,int start,int v){

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start,0));
        while(!q.isEmpty()){
            Edge curEdge = q.poll();
            int cur = curEdge.end;
            if(visited[cur])
                continue;
            visited[cur] = true;
            for(Edge edge:map[cur]){
                int next = edge.end;
                int val = edge.val;
                if(d[next]>d[cur]+val){
                    d[next] = d[cur]+val;
                    q.add(new Edge(next,d[next]));
                }
            }
        }
    }
}
