package kakao.blind2018;

import java.util.HashMap;
import java.util.Map;

public class Problem5 {
    public static void main(String[] args) {

    }

    Map<String, Integer> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 0; i < str1.length() - 1; i++) {
            Character c1 = str1.charAt(i);
            Character c2 = str1.charAt(i + 1);
            if ((c1 >= 'a' && c1 <= 'z') && (c2 >= 'a' && c2 <= 'z')) {
                String temp = "" + str1.charAt(i) + str1.charAt(i + 1);
                if (map1.containsKey(temp)) {
                    map1.put(temp, map1.get(temp) + 1);
                } else {
                    map1.put(temp, 1);
                }
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            Character c1 = str2.charAt(i);
            Character c2 = str2.charAt(i + 1);
            if ((c1 >= 'a' && c1 <= 'z') && (c2 >= 'a' && c2 <= 'z')) {
                String temp = "" + str2.charAt(i) + str2.charAt(i + 1);
                if (map2.containsKey(temp)) {
                    map2.put(temp, map2.get(temp) + 1);
                } else {
                    map2.put(temp, 1);
                }
            }
        }


        String[] map1Key = map1.keySet().toArray(new String[0]);
        String[] map2Key = map2.keySet().toArray(new String[0]);
        if (map1Key.length == 0 && map2Key.length == 0) {
            return 65536;
        }else if(map1Key.length == 0 || map2Key.length == 0){
            return 0;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < map1Key.length; i++) {
            if (map2.containsKey(map1Key[i])) {
                a += Math.min(map1.get(map1Key[i]), map2.get(map1Key[i]));
                b += Math.max(map1.get(map1Key[i]), map2.get(map1Key[i]));
            } else {
                b += map1.get(map1Key[i]);
            }
        }
        for (int i = 0; i < map2Key.length; i++) {
            if (!map1.containsKey(map2Key[i])) {
                b += map2.get(map2Key[i]);
            }
        }


        double res = ((1.0) * a) / b;
        answer = (int) (res * 65536);


        return answer;
    }
}
