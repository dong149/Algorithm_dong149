package coding_test_practice;

import java.util.HashMap;
import java.util.Map;

public class Problem5 {
    /*
    문자열에서 처음으로 반복되지 않는 문자를 찾아내는 함수를 작성하세요 ex) total -> o, teeter -> r
     */


    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {


        String test1 = "ttt";
        String test2 = "teeter";
        String test3 = "total";
        System.out.println(solution(test1));
        System.out.println(solution(test2));
        System.out.println(solution(test3));
    }

    public static Character solution(String s) {

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<s.length();i++) {
            if(map.get(s.charAt(i))==1)
                return s.charAt(i);
        }


        return null;
    }
}
