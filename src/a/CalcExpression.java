package a;

import java.util.*;

public class CalcExpression {
    public static void main(String[] args) {

        String test = "100-200*300-500+20";
        Set<Integer> set = new HashSet<>();
        List<Integer> li  = new ArrayList<>();
        Stack<Integer> st = new Stack<>();



        li.add(1);
        li.add(2);
        li.add(3);
        li.add(0,4);
        System.out.println(li.toString());
        System.out.println(li.remove(0));

        System.out.println(li.toString());



//        System.out.println(solution(test));
    }


    static String[] pr = {"+*-","+-*","-+*","-*+","*+-","*-+"};

    public static long solution(String expression) {
        long answer = Long.MIN_VALUE;

        for(String s:pr){
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                map.put(s.charAt(i),i);
            }
            answer = Math.max(Math.abs(calcPostExpression(getPostExpression(expression,map))),answer);
            System.out.println(answer);
        }
        return answer;
    }

    public static String getPostExpression(String ex,Map<Character,Integer> map) {
        StringTokenizer st = new StringTokenizer(ex, "+*-", true);
        StringBuilder sb = new StringBuilder();
        Stack<String> opStack = new Stack<>();
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (next.matches("[\\+\\*\\-]")) {
                while (!opStack.isEmpty()) {
                    String top = opStack.peek();
                    if (map.get(top.charAt(0)) >= map.get(next.charAt(0)))
                        sb.append(opStack.pop());
                    else
                        break;
                }

                opStack.push(next);

            } else {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9')
                    sb.append(',');
                sb.append(next);
            }
        }
        while (!opStack.isEmpty()) {
            sb.append(opStack.pop());
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static long calcPostExpression(String ex) {
        //token으로 나누고, 연산자가 나오면 두 개를 빼서 다시 스택에 넣는다.
        StringTokenizer st = new StringTokenizer(ex, "+*-,", true);
        Stack<Long> opStack = new Stack<>();
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (next.matches("[\\*\\-\\+]")) {
                long b = opStack.pop();
                long a = opStack.pop();
                if (next.equals("*"))
                    opStack.push(a * b);
                else if (next.equals("-"))
                    opStack.push(a - b);
                else {
                    opStack.push(a + b);
                }
            } else if (next.matches("[,]")) {
                continue;
            } else {
//                System.out.println(next);
                opStack.push(Long.parseLong(next));
            }
        }

        return opStack.pop();
    }

}
