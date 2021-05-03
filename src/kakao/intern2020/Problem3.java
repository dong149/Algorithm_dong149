package kakao.intern2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        String[] test = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] test2 = {"XYZ", "XYZ", "XYZ"};
        int[] ans = solution(test);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    static int len;
    static int gemCnt;

    public static int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};

        if (gems.length == 1) {
            return new int[]{1, 1};
        }

        HashSet<String> set = new HashSet<>();
        for (String s : gems) {
            set.add(s);
        }
        gemCnt = set.size();

        int left = 0;
        int right = 0;
        Map<String, Integer> map = new HashMap<>();
        for (; right < gems.length; right++) {
            String cur = gems[right];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (true) {
                String leftS = gems[left];
                if (map.containsKey(leftS)) {
                    if (map.get(leftS) > 1) {
                        map.put(leftS, map.get(leftS) - 1);
                        left++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (map.keySet().size() == gemCnt) {
                if (answer[1] - answer[0] > right - left) {
                    answer[1] = right + 1;
                    answer[0] = left + 1;
                }
            }
        }


        return answer;
    }
}
