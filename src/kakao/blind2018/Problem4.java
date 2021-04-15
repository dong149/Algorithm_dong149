package kakao.blind2018;

import java.util.PriorityQueue;

public class Problem4 {
    public static void main(String[] args) {

    }



    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";


        for(int i=0;i<timetable.length;i++){
            String[] time = timetable[i].split(":");
            pq.add(Integer.parseInt(time[0])*60 +Integer.parseInt(time[1]));
        }

        int possibleIdx=-1;
        int temp=0;
        for(int i=0;i<n;i++){
            int curTime = 540 + t*i;
            int cnt=0;
            while(!pq.isEmpty()){
                if(cnt>=m) {
                    break;
                }
                temp = pq.peek();
                if(temp<=curTime){
                    pq.poll();
                    cnt++;
                }else{
                    break;
                }
            }
            if(cnt<m){
                possibleIdx=i;
            }
        }
        int possibleTime=temp-1;
        if(possibleIdx!=-1&&possibleIdx==n-1)
            possibleTime = 540 + possibleIdx * t;
        int hour = possibleTime/60;
        int min = possibleTime-hour*60;

        answer = String.format("%02d",hour) +":"+String.format("%02d",min);
        return answer;
    }
}
