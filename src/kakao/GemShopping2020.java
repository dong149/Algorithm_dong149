package kakao;

import java.util.*;



/**
 * 2020 카카오 인턴십 보석쇼핑
 * 느낀점 : 결국에는 혼자 풀지 못하였다. 나중에 다시 풀어보기
 * HashMap을 사용하여 해결하였다.
 **/


public class GemShopping2020 {

    public static void main(String[] args) {
        String [] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] res = solution(gems);
        for(int i:res){
            System.out.println(i);
        }
    }
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int length = gems.length;
        int start = 0;
        int realStart = 0;
        int dist = gems.length;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            if(!map.containsKey(gems[i])){
                map.put(gems[i],1);
            }else{
                map.put(gems[i],map.get(gems[i])+1);
            }
        }
        int gemCnt = map.size();
        map.clear();
        Queue<String> q1 = new LinkedList<>();
        for(int i=0;i<length;i++){
            // map 에 해당 보석이 있는지 확인한다. 없으면 추가하고, 시작 포인트를 변경한다.
            if(!map.containsKey(gems[i])){
                map.put(gems[i],1);
            }else{
                map.put(gems[i],map.get(gems[i])+1);
            }
            q1.add(gems[i]);
            while(!q1.isEmpty()){
                String left = q1.peek();
                //첫번째 거가 두 번 들어가 있다.
                if(map.get(left)>1){
                    map.put(left,map.get(left)-1);
                    q1.poll();
                    start++;
                }else break;
            }
            if(map.size() == gemCnt && dist>q1.size()){
                realStart = start;
                dist = q1.size();
            }
        }
        answer[0] = realStart+1;
        answer[1] = realStart + dist;

        return answer;
    }
}
