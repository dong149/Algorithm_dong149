package practice;

import java.util.Stack;

public class Problem2 {


    Stack<Character> st = new Stack<>();
    public int solution(String s, String t) {
        int result = 0;

        for(int i=0;i<s.length();i++){
            st.push(s.charAt(i));
            if(st.size()>=t.length()){
                boolean isSame= true;
                for(int j=0;j<t.length();j++){
                    if(st.get(st.size()-t.length()+j) != t.charAt(j)){
                        isSame = false;
                        break;
                    }
                }
                if ( isSame ) {
                    result++;
                    for(int j=0;j<t.length();j++){
                        st.pop();
                    }
                }
            }
        }
        return result;
    }
}
