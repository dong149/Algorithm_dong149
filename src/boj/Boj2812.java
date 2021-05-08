package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Boj2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        int len = n - k;
        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (st.isEmpty()) {
                st.push(cur);
            } else {
                char top = st.peek();
                if (st.size() + (s.length() - i) == (n - k)) {
                    st.push(cur);
                    continue;
                }
                if (top >= cur) {
                    if (st.size() < len) {
                        st.push(cur);
                    }
                } else {
                    st.pop();
                    while (true) {
                        if (st.isEmpty()) {
                            st.push(cur);
                            break;
                        }
                        if (st.size() + (s.length() - i) > (n - k)) {
                            if (st.peek() < cur) {
                                st.pop();
                            } else {
                                st.push(cur);
                                break;
                            }
                        } else {
                            st.push(cur);
                            break;
                        }
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        ArrayList<Character> li = new ArrayList<>();
        while (!st.isEmpty()) {
            char top = st.pop();
            li.add(top);
        }
        for (int i = li.size() - 1; i >= 0; i--) {
            sb.append(li.get(i));
        }
        System.out.println(sb);


    }

}
