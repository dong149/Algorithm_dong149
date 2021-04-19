package kakao.blind2019;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public static void main(String[] args) {
        String[] record ={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }

    static Map<String, String> map = new HashMap<>();

    public static String[] solution(String[] record) {
        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            if (temp[0].equals("Enter")) {
                map.put(temp[1], temp[2]);
            }
            if (temp[0].equals("Change")) {
                map.put(temp[1], temp[2]);
            }
            if (temp[0].equals("Enter") || temp[0].equals("Leave")) {
                cnt++;
            }

        }
        String[] answer = new String[cnt];
        int idx=0;

        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            if (temp[0].equals("Change"))
                continue;
            if (temp[0].equals("Enter")) {
                answer[idx] = map.get(temp[1]) + "님이 들어왔습니다.";
            }else {
                answer[idx] = map.get(temp[1]) + "님이 나갔습니다.";
            }
            idx++;

        }

        return answer;
    }
}

