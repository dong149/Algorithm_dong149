package kakao.intern2019;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem5 {
    public static int solution(int[] stones, int k) {
        int answer = 200000001;


        PriorityQueue<Stone> pq = new PriorityQueue<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            pq.add(new Stone(stones[i],i));
            map.put(stones[i],1+map.getOrDefault(stones[i],0));
        }

        answer=Math.min(pq.peek().val,answer);


        for(int i=1;i<=stones.length-k;i++){
//            int max=0;
//            for(int j=i;j<i+k;j++){
//                max = Math.max(max,stones[j]);
//            }
            int end = i+k-1;
            pq.add(new Stone(stones[end],end));
            map.put(stones[i-1],map.get(stones[i-1])-1);
            map.put(stones[end],1+map.getOrDefault(stones[end],0));
            while(map.get(pq.peek().val)==0){
                pq.poll();
            }
            answer= Math.min(answer,pq.peek().val);
        }
        return answer;
    }

    public static class Stone implements Comparable<Stone>{
        int val;
        int idx;

        public Stone(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Stone o) {
            return o.val- this.val;
        }
    }

}
