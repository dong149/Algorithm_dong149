package Programmers.StackQueue;

import java.util.*;

public class FeatureDeveloping {

    private class Feature{
        int prog;
        int speed;

        public Feature(int prog,int speed){
            this.prog = prog;
            this.speed = speed;
        }

        public void progress(){
            this.prog += this.speed;
        }
    }



    private Queue<Feature> q = new LinkedList<>();
    private List<Integer> list = new ArrayList<>();
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;


        //모두 넣어줍니다.
        for(int i=0;i<speeds.length;i++){
            q.add(new Feature(progresses[i],speeds[i]));
        }

        int day = 0;
        while(!q.isEmpty()){
            day++;
            for(Feature feature: q){
                feature.progress();
            }
            int progCnt=0;
            while(true){
                if(!q.isEmpty()&&q.peek().prog>=100){
                    q.poll();
                    progCnt++;
                }else{
                    break;
                }
            }
            if(progCnt>0) {
                list.add(progCnt);
            }
        }


        answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }



        return answer;
    }


}
