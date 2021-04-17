package kakao.blind2021;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] res = solution(orders, course);
        for (String temp : res) {
            System.out.println(temp);
        }


    }


    static Map<String, Integer>[] combination = new Map[11];

    public static String[] solution(String[] orders, int[] course) {


        boolean[] isCourseCnt = new boolean[11];
        for (int i = 0; i < combination.length; i++) {
            combination[i] = new HashMap<>();
        }
        for (int i = 0; i < course.length; i++) {
            isCourseCnt[course[i]] = true;
        }
        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            dfs(isCourseCnt, order, "", 0);
        }
        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int idx = course[i];
            if (combination[idx].isEmpty()) {
                continue;
            }
            List<String> keySetList = new ArrayList<>(combination[idx].keySet());
            Collections.sort(keySetList, (o1, o2) -> combination[idx].get(o2).compareTo(combination[idx].get(o1)));
            int max = combination[idx].get(keySetList.get(0));
            if (max < 2)
                continue;
            for (int j = 0; j < keySetList.size(); j++) {
                if (combination[idx].get(keySetList.get(j)) < max) {
                    break;
                } else {
                    ansList.add(keySetList.get(j));
                }
            }
        }

        Collections.sort(ansList);
        String[] answer = new String[ansList.size()];
        ansList.toArray(answer);
        return answer;
    }


    public static void dfs(boolean[] isCourseCnt, char[] order, String temp, int idx) {
        if (isCourseCnt[temp.length()]) {
            if (combination[temp.length()].containsKey(temp)) {
                combination[temp.length()].put(temp, combination[temp.length()].get(temp) + 1);
            } else {
                combination[temp.length()].put(temp, 1);
            }
        }
        for (int i = idx; i < order.length; i++) {
            dfs(isCourseCnt, order, temp + order[i], i + 1);
        }


    }
}
