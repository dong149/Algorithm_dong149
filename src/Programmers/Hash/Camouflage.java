package Programmers.Hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

    private Map<String,Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 0;


        // Map 에 모두 넣어줍니다.
        for(String[] temp:clothes){
            if(map.containsKey(temp[1])){
                map.put(temp[1],map.get(temp[1])+1);
            }else{
                map.put(temp[1],1);
            }
        }

        String[] keySet = map.keySet().toArray(new String[0]);
        int multiplySum = 1;
        for(String temp:keySet){
            int n = map.get(temp);
            multiplySum *= n+1;
        }
        answer = multiplySum-1;


        return answer;
    }

}
