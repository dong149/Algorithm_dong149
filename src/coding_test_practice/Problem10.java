package coding_test_practice;

import java.util.ArrayList;
import java.util.List;

public class Problem10 {
    /*
    hat이라는 문자열이 주어질 때, 모든 경우의 수를 재귀를 통해서 return 하는 함수를 만들어라
     */

    static List<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        solution("hat",new StringBuilder(),new boolean[3]);
        for (String s:ans){
            System.out.println(s);
        }
    }

    public static void solution(String s, StringBuilder sb, boolean[] visited) {
        if(sb.length() == s.length())
            ans.add(sb.toString());

        for(int i=0;i<s.length();i++){
            if(!visited[i]) {
                visited[i] = true;
                sb.append(s.charAt(i));
                solution(s,sb,visited);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
    }
}
