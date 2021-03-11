package Kakao;

import java.util.*;




/**
 * 2020 카카오 인턴십
 * 느낀점 : ArrayList 를 다른 변수에 임의로 저장해놓을 때, addAll 이라는 함수를 통해, 저장하는 것을 배웠다.
 * iterator로 ArrayList 를 순환해야 하는 것도 배웠다.
 **/

public class MaxExpression2020 {

    char[][] tokenPriority = {{'+', '-', '*'}, {'+', '*', '-'}, {'-', '*', '+'}, {'-', '+', '*'}, {'*', '+', '-'}, {'*', '-', '+'}};
    //    char[][] tokenPriority = {{'*', '+', '-'}};
    List<Long> num = new ArrayList<>();
    List<Character> token = new ArrayList<>();

    int numCnt = 0;
    int tokenCnt = 0;

    public long solution(String expression) {
        long answer = 0;
        String temp = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 수일 경우
            if (c >= '0' && c <= '9') {
                temp = temp + Character.toString(c);
            } else {
                // 토큰 추가하기
                token.add(c);
                // 숫자 추가하기
                num.add(Long.parseLong(temp));
                temp = "";
                continue;
            }
            //마지막 수일 때 추가
            if (i == expression.length() - 1) {
                num.add(Long.parseLong(temp));
            }
        }


        long Max = 0;
        for (char[] chars : tokenPriority) {

            List<Character> tToken = new ArrayList<>();
            tToken.addAll(token);
            List<Long> tNum = new ArrayList<>();
            tNum.addAll(num);
            for (char tokenP : chars) {
                for (Iterator<Character> it = tToken.iterator(); it.hasNext(); ) {
                    char t = it.next();
                    int k = tToken.indexOf(t);
                    if (t == tokenP) {
                        switch (tokenP) {
                            case '+':
                                tNum.set(k, tNum.get(k) + tNum.get(k + 1));
                                tNum.remove(k + 1);
                                break;
                            case '*':
                                tNum.set(k, tNum.get(k) * tNum.get(k + 1));
                                tNum.remove(k + 1);
                                break;
                            case '-':
                                tNum.set(k, tNum.get(k) - tNum.get(k + 1));
                                tNum.remove(k + 1);
                                break;
                        }
                        it.remove();
                    }
                }

            }
            if (Max < Math.abs(tNum.get(0))) Max = Math.abs(tNum.get(0));
        }


        answer = Max;

        return answer;
    }
}
