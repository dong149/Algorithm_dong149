package kakao.blind2019;

import java.util.ArrayList;
import java.util.Collections;

public class Problem4 {
    public static void main(String[] args) {
        int[] food_times = {3, 4, 2};
        long k = 1;
        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        int answer = 0;

        int len = food_times.length;
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=0;i<food_times.length;i++){
            li.add(food_times[i]);
        }
        Collections.sort(li);


        long cnt=0;
        int idx=-1;
        for(int i=0;i<li.size();i++){
            long size = li.size()-i;
            if(i==0){
                cnt+=size*li.get(i);
            }else{
                cnt+=size*(li.get(i)-li.get(i-1));
            }
            if(k<=cnt){
                idx = (int)(cnt-k);
                cnt = li.get(i);
                break;
            }

        }

        if(idx==-1){
            return -1;
        }
        idx++;
        for(int i=0;i<len;i++){
            if(food_times[i]<=cnt){
                food_times[i] = 0;
            }
        }
        int numCnt=0;
        for(int i=0;i<len;i++){
            if(food_times[i]==0){
                continue;
            }else{
                numCnt++;
            }
            if(numCnt==idx){
                return i+1;
            }
        }
        return -1;

    }
}
