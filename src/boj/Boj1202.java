package boj;

import java.util.*;

public class Boj1202 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] c = new int[k];
        ArrayList<Node> je= new ArrayList<>();
        for(int i=0;i<n;i++){
            int m,v;
            m = sc.nextInt();
            v = sc.nextInt();
            je.add(new Node(m,v));
        }
        for(int i=0;i<k;i++){
            c[i] = sc.nextInt();
        }
        Collections.sort(je);
        Arrays.sort(c);
        int cnt=0;
        long ans=0;
        int pqSize=0;
        for(int i=0;i<k;i++){
            for(int j=cnt;j<je.size();j++){
                if(pqSize<je.size()&&je.get(j).w<=c[i]){
                    pq.add(-je.get(j).v);
                    pqSize++;
                }else{
                    cnt = j;
                    break;
                }
            }

            if(!pq.isEmpty()){
                ans += Math.abs(pq.poll());
            }
        }
        System.out.println(ans);
    }

    public static class Node implements Comparable<Node>{
        int w;
        int v;
        public Node(int w,int v){
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }
}
