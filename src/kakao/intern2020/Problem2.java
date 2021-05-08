package kakao.intern2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        long answer = solution("50*300");
        System.out.println(answer);

    }

    static String[] Pr = {"-+*","+-*","+*-","-*+","*-+","*+-"};
    public static long solution(String expression) {
        long answer = 0;

        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<Character> opList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(expression,"-*+",true);

        while(st.hasMoreTokens()){
            String cur = st.nextToken();
            if(cur.matches("[-*+]")){
                opList.add(cur.charAt(0));
            }else{
                numList.add(Long.parseLong(cur));
            }
        }

        ArrayList<Long> numLi;
        ArrayList<Character> opLi;
        for(String pr:Pr){
            numLi = new ArrayList<>();
            opLi = new ArrayList<>();
            numLi.addAll(numList);
            opLi.addAll(opList);
            for(int i=0;i<3;i++){
                ArrayList<Long> numTemp = new ArrayList<>();
                ArrayList<Character> opTemp = new ArrayList<>();
                char op = pr.charAt(i);
                numTemp.add(numLi.get(0));
                int numIdx=1;
                for(int opIdx=0;opIdx<opLi.size();opIdx++) {
                    if (opLi.get(opIdx) == op) {
                        long top = numTemp.get(numTemp.size() - 1);
                        long next = numLi.get(numIdx);
                        long res=0;
                        if (op == '*') {
                            res = top * next;
                        } else if (op == '+') {
                            res = top + next;
                        } else {
                            res = top - next;
                        }
//                        System.out.println(res);
                        //-100
                        numTemp.set(numTemp.size() - 1, res);
                        numIdx++;
                    } else {
                        opTemp.add(opLi.get(opIdx));
                        numTemp.add(numLi.get(numIdx));
                        numIdx++;
                    }
                }
                numLi = new ArrayList<>();
                opLi = new ArrayList<>();
                numLi.addAll(numTemp);
                opLi.addAll(opTemp);
            }
            answer = Math.max(answer,Math.abs(numLi.get(0)));
        }






        return answer;
    }


}
