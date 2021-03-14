package Programmers.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class CrossingTruck {



    private Queue<Integer>  q = new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum=0;
        int time=0;
        for(int w:truck_weights){

            while(true){
                //비어있으면 넣어줍니다.
                if(q.isEmpty()){
                    q.add(w);
                    sum+=w;
                    time++;
                    break;
                }else if(q.size()==bridge_length){ // 빼내야될 게 생겼을 경우 하나를 빼준다.
                    sum -= q.poll();
                }else{   //아직 무게때문에 넣지 못할 경우 0을 대신 넣어준다, 넣을만한 타이밍이면 새롭게 추가해준다.
                    if(sum+w>weight){
                        q.add(0);
                        time++;
                    }else{
                        q.add(w);
                        sum+=w;
                        time++;
                        break;
                    }
                }
            }
        }
        time += bridge_length;
        return time;
    }




}
