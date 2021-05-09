package kakao.intern2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Problem3 {
    public static void main(String[] args) {
        int n = 6;
        int k = 0;
        String[] cmd = {"C","C","D 3","Z","Z","C","C"};
        String answer = solution(n, k, cmd);
        System.out.println(answer);
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";

        LinkedList<Integer> li = new LinkedList<>();
        boolean[] isValid = new boolean[n];
        Arrays.fill(isValid,true);
        for (int i = 0; i < n; i++) {
            li.add(i);
        }



        int idx = k;
        Stack<Integer> st = new Stack<>();
        for (String c : cmd) {
            char cmdChar = c.charAt(0);
            int len = li.size();
            if (cmdChar == 'C') {
                st.push(li.get(idx));
                for(int i=0;i<li.size();i++){
                    System.out.print(li.get(i)+" ");
                }
                System.out.println();
                li.remove(idx);
                if (idx == len - 1) {
                    idx--;
                }
            } else if (cmdChar == 'U') {
                int X = Integer.parseInt(c.split(" ")[1]);
                idx -= X;
            } else if (cmdChar == 'D') {
                int X = Integer.parseInt(c.split(" ")[1]);
                idx += X;
            } else if (cmdChar == 'Z') {
                int top = st.pop();
                int left = 0;
                int right = len-1;
                int mid = 0;
                int res = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (li.get(mid) <= top) {
                        res = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

                }
                li.add(res,top);
                if(idx>res){
                    idx++;
                }
            }
        }
        while(!st.isEmpty()){
            isValid[st.pop()] = false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(!isValid[i]){
                sb.append("X");
            }else{
                sb.append("O");
            }
        }

        return answer = sb.toString();
    }
}
