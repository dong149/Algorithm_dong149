package programmers.monthlyChallenge4;

import java.util.Stack;

public class Problem2 {
    //    static Stack<Character> st = new Stack<>();
    public static void main(String[] args) {
        String test ="{";
        int res = solution(test);
        System.out.println(res);
    }

    public static int solution(String s) {
        int answer = 0;
        String test = s;

        for (int i = 0; i < s.length(); i++) {
            test = test.substring(1, s.length()) + test.charAt(0);
            System.out.println(test);
            if (check(test)) {
                System.out.println(i);
                answer++;
            }
        }
        return answer;
    }

    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')') {
                if (st.isEmpty()) {
                    return false;
                }
                Character temp = st.peek();
                if (s.charAt(i) == ']') {
                    if (temp == '[') {
                        st.pop();
                        continue;
                    }
                }
                if (s.charAt(i) == '}') {
                    if (temp == '{') {
                        st.pop();
                        continue;
                    }
                }
                if (s.charAt(i) == ')') {
                    if (temp == '(') {
                        st.pop();
                        continue;
                    }
                }
                return false;
            } else {
                st.push(s.charAt(i));
            }
        }
        if (st.isEmpty())
            return true;
        return false;
    }
}
