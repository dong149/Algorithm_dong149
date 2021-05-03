package line;

import java.util.Stack;

public class Problem1 {
    public static void main(String[] args) {

    }
    public static int solution (String inputString){
        int answer = 0;
        Stack<Character> st = new Stack<>();
        boolean check=true;
        int cnt=0;
        for(int i=0;i<inputString.length();i++){
            char cur = inputString.charAt(i);
            if(cur=='('||cur=='{'||cur=='['||cur=='<'){
                st.push(cur);
            }else if(cur==')'||cur=='}'||cur==']'||cur=='>'){
                if(st.isEmpty()){
                    answer=i*(-1);
                    check=false;
                    break;
                }
                char temp = st.peek();
                if(cur==')'&&temp=='('){
                    cnt++;
                }else if(cur=='}'&&temp=='{'){
                    cnt++;
                }else if(cur==']'&&temp=='['){
                    cnt++;
                }else if(cur=='>'&&temp=='<'){
                    cnt++;
                }else {
                    answer = i * (-1);
                    check = false;
                    break;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()&&check){
            answer=(inputString.length()-1)*-1;
        }else if(check){
            answer=cnt;
        }



        return answer;
    }
}
