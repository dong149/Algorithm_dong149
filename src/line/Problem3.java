package line;

import java.util.PriorityQueue;

public class Problem3 {
    public static void main(String[] args) {

    }




    PriorityQueue<Time> pq = new PriorityQueue<>();
    public int solution(int[][] ads) {
        int answer = 0;
        for(int i=0;i<ads.length;i++){
            pq.add(new Time(ads[i][0],ads[i][0]+5,ads[i][1]));
        }

        int curTime=0;
        while(!pq.isEmpty()){
            Time cur = pq.poll();
            Time next= null;
            if(!pq.isEmpty()){
                next = pq.poll();
            }





        }


        return answer;
    }

    public class Time implements Comparable<Time>{
        int start;
        int end;
        int val;

        public Time(int start,int end,int val){
            this.start=start;
            this.end = end;
            this.val = val;
        }


        @Override
        public int compareTo(Time o) {
            if(this.start-o.start>0){
                return 1;
            }else if(this.start-o.start==0){
                return o.val-this.val;
            }else{
                return -1;
            }
        }
    }



}
