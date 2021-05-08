package kakao.intern2019;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Long,Long> map = new HashMap<>();
    static long[] answer ;
    public static  long[] solution(long k, long[] room_number) {
        answer =  new long[room_number.length];
        for(int i=0;i<room_number.length;i++){
          check(room_number[i],i);
        }

        return answer;
    }
    public static long check(long num,int idx){
        if(!map.containsKey(num)){
            map.put(num,num+1);
            answer[idx] = num;
            return num+1;
        }

        long next = map.get(num);
        long res = check(next,idx);
        map.put(num,res);
        return res;
    }
}
