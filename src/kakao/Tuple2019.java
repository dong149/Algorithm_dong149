package kakao;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Tuple2019 {

    public static void main(String[] args) {
        String test = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] res = solution(test);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }
    }

    public static int[] solution(String s) {


        int cnt = 0;
        String temp = "";
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<ListNode> pq = new PriorityQueue<>();
        s = s.substring(1, s.length() - 1);
        s = s.replaceAll("},\\{", "}{");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                temp += s.charAt(i);
            } else if (s.charAt(i) == ',') {
                list.add(Integer.parseInt(temp));
                temp = "";
            } else if (s.charAt(i) == '}') {
                list.add(Integer.parseInt(temp));
                temp = "";
                pq.add(new ListNode(list, list.size()));
                list = new ArrayList<>();
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
//            System.out.println(cur.list.size());
            for (int i = 0; i < cur.list.size(); i++) {
                int curVal = cur.list.get(i);
                if (res.size() == 0) {
                    res.add(curVal);
                    break;
                }
                boolean check = false;
                for (int j = 0; j < res.size(); j++) {
                    if (res.get(j) == curVal) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    res.add(curVal);
                    break;
                }
            }
        }


        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static class ListNode implements Comparable<ListNode> {
        ArrayList<Integer> list;
        int size;

        public ListNode(ArrayList<Integer> list, int size) {
            this.list = list;
            this.size = size;
        }

        @Override
        public int compareTo(ListNode o) {
            return this.size - o.size;
        }
    }
}
