package programmers.monthlyChallenge4;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Problem3 {
    public static void main(String[] args) {
//        int[] a ={-5,0,2,1,2};
        int[] a ={2,-1,-1};
//        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        int[][] edges = {{0,1},{0,2}};
        long res = solution(a,edges);
        System.out.println(res);
    }
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static long solution(int[] a, int[][] edges) {


        boolean checkZero=true;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0) {
                checkZero = false;
//                if(a[i]>0)
                    pq.add(new Node(i, a[i]));
            }
        }
        if(checkZero){
            return 0;
        }
        for(int i=0;i<a.length;i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            arr.get(edges[i][0]).add(edges[i][1]);
            arr.get(edges[i][1]).add(edges[i][0]);
        }
        long answer = 0;
        boolean[] visited = new boolean[a.length];
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(a[cur.idx]==0){
                continue;
            }
            visited[cur.idx] = true;
            System.out.println(cur.idx);
            int min=1000001;
            int idx=-1;
            for(int i=0;i<arr.get(cur.idx).size();i++){
//                System.out.println(arr.get(cur.idx).get(i));
                if(!visited[arr.get(cur.idx).get(i)]){
                    if(a[arr.get(cur.idx).get(i)]<min){
                        idx = arr.get(cur.idx).get(i);
                        min = a[arr.get(cur.idx).get(i)];
                    }
                }
            }
//            System.out.println(idx);
//            System.out.println();
            if(idx==-1)
                break;
            if(a[cur.idx]>0){
                a[idx] += a[cur.idx];
                answer += a[cur.idx];
                a[cur.idx] = 0;
            }else{
                a[idx] -= -a[cur.idx];
                answer += -a[cur.idx];
                a[cur.idx] = 0;
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                return -1;
            }
        }
        return answer;
    }


    public static class Node implements Comparable<Node>{
        int idx;
        int val;
        public Node(int idx,int val){
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return o.val-this.val;
        }
    }
}
