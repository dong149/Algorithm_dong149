package kakao;

import java.util.Stack;

public class Bracket2020 {
    public static void main(String[] args) {
        String test = ")(";
        String res = solution(test);
        System.out.println(res);
    }

    public static String solution(String p) {
        String answer = "";
        if (isCorrect(p)) {
            answer = p;
            return answer;
        }
        answer = solve(p, "");
        return answer;
    }

    public static String solve(String u, String v) {
        if (u.length() == 0) {
            return u;
        }
        int idx = 0;
        for (int i = 0; i < u.length(); i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j <= i; j++) {
                if (u.charAt(j) == '(') {
                    left++;
                } else {
                    right++;
                }
            }
            if (left == right) {
                idx = i;
                break;
            }
        }
        String temp = u;
        String nStr = "(";
        u = temp.substring(0, idx + 1);
        v = temp.substring(idx + 1, temp.length());
        if (isCorrect(u)) {
            u += solve(v, "");
        } else {
            String res = solve(v, "");
            nStr = nStr + res + ")";
            u = u.substring(1, u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    nStr += ")";
                } else {
                    nStr += "(";
                }
            }
            u = nStr;
        }
        return u;
    }

    // 올바른 문자열인지 체크합니다.
    public static boolean isCorrect(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    Character top = st.peek();
                    if (top == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        if (st.isEmpty())
            return true;
        else
            return false;
    }
}
