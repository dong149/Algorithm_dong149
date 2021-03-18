package programmers.heap;

import java.util.PriorityQueue;

public class MoreSpicy {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {

        int answer = 0;
        for(int temp:scoville){
            pq.add(temp);
        }


        while(!pq.isEmpty()&&pq.peek()<K){
            if(pq.size()<2){
                int t3 = pq.peek();
                if(t3>=K){
                    break;
                }else{;
                    pq.poll();
                    break;
                }
            }
            int t1 = pq.poll();
            int t2 = pq.poll();
            pq.offer(t1+t2*2);
            answer++;
        }

        //pq가 비어있으면, -1를 Return 한다.
        if(pq.isEmpty())
            answer = -1;


        return answer;
    }
}
