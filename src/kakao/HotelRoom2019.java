package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HotelRoom2019 {
    public static void main(String[] args) {
        long k=10;
        long[] room_number = {1,3,4,1,3,1};
        long[] res = solution(k,room_number);
        System.out.println(Arrays.toString(res));
    }
    static Map<Long,Long> map= new HashMap<>();

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i=0;i<room_number.length;i++){
            answer[i] = checkMap(room_number[i]);
        }
        return answer;

    }
    public static long checkMap(long n){
        if(!map.containsKey(n)){
            map.put(n,n+1);
            return n;
        }

        long cur = map.get(n);
        long next = checkMap(cur);
        map.put(n,next);
        return next;
    }
}

//        for(int i=0;i<room_number.length;i++){
//            if(!map.containsKey(room_number[i])){
//                answer[i] = room_number[i];
//                map.put(room_number[i],room_number[i]+1);
//            }else{
//                long temp = map.get(room_number[i]);
//                while(true){
//                    if(map.containsKey(temp)){
//                        temp = map.get(temp);
//                    }else{
//                        break;
//                    }
//                }
//                answer[i] = temp;
//                map.put(room_number[i],temp);
//                map.put(temp,temp+1);
//            }
//        }