package kakao.intern2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public static void main(String[] args) {

    }


    static Map<String,Integer> map = new HashMap<>();
    public int solution(String s) {
        int answer = 0;

        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);


        StringBuilder res = new StringBuilder();
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                res.append(s.charAt(i));
                continue;
            }
            sb.append(s.charAt(i));
            if(map.containsKey(sb.toString())){
                res.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
        }
        answer = Integer.parseInt(res.toString());

        return answer;
    }

}
