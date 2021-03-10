package Kakao;

import java.util.Stack;
import java.util.StringTokenizer;

public class MaxExpression2020 {
//    /**
//     * 수식을 stack 에 저장한다.
//     * stack 을 parameter로 받는 함수를 정의한다.
//     * 우선순위를 표현하는 6가지의 경우를 배열로 선언한다.
//     **/
//
//    Stack<String> st = new Stack<String>();
//
//    public long solution(String expression) {
//        String str;
//        StringTokenizer nExpression = new StringTokenizer(expression,"+-*",true);
//        // 수식 혹은 token 을 stack 에 저장합니다.
//        while(nExpression.hasMoreTokens()){
//            str = nExpression.nextToken();
//            st.push(str);
//        }
//
//        long answer = 0;
//
//        return answer;
//    }
//
//    public long solve(Stack<String> st){
//        while(!st.isEmpty()){
//
//            String temp = st.pop();
//            long tempLong;
//            if(!temp.equals("+")&&!temp.equals("-")&&!temp.equals("*")){
//                // TODO 마이너스일 경우 처리해줘야 함.
//                tempLong = Long.parseLong(temp);
//
//            }else{ // 연산자인 경우
//
//            }
//
//        }
//
//
//    }
}
