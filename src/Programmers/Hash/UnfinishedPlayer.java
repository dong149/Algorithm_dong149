package Programmers.Hash;

import java.util.HashMap;
import java.util.Map;

public class UnfinishedPlayer {

    private Map<String,Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        for(String temp:participant){
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }else{
                map.put(temp,map.get(temp)+1);
            }
        }

        for(String temp:completion){
            if(map.get(temp)==1){
                map.remove(temp);
            }else{
                map.put(temp,map.get(temp)-1);
            }
        }

        String[] strSet = map.keySet().toArray(new String[0]);


        String answer = strSet[0];
        return answer;
    }

}
