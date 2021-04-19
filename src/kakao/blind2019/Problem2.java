package kakao.blind2019;

import java.util.PriorityQueue;

public class Problem2 {

    public static void main(String[] args) {
        int[] stages = {1,1,1,1,2,2,2,2};
        int n = 450;
        int[] res = solution(n,stages);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stage = new int[502];
        int[] total = new int[502];
        for(int i=stages.length-1;i>=0;i--){
            stage[stages[i]]++;
        }
        total[N+1] = stage[N+1];
        for(int i=500;i>=1;i--){
            total[i] = total[i+1]+stage[i];
        }
        for(int i=1;i<=N;i++){
            if(total[i]==0){
                pq.add(new Node(i,0));
            }else{
                pq.add(new Node(i,(double)((1.0*stage[i])/total[i])));
            }
        }
        for(int i=0;i<N;i++){
            answer[i]=pq.poll().st;
        }
        return answer;

    }
    public static class Node implements Comparable<Node>{
        int st;
        double val;

        public Node(int st,double val){
            this.st = st;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if(o.val>this.val){
                return 1;
            }else if(o.val==this.val){
                return this.st-o.st;
            }else{
                return -1;
            }
        }
    }
}
