package interview;

import java.util.Scanner;
import java.util.Stack;

public class StringFunc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = intToString(Integer.parseInt(s));
        System.out.println(res);
    }



    // String을 뒤집습니다.
    private static String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            st.add(s.charAt(i));
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }


    // 정수형을 String으로 바꿉니다.
    private static String intToString(int n){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        while(true){
            int divide = n%10;
            st.add(divide);
            n = n/10;
            if(n==0)
                break;
        }

        while(!st.isEmpty()){
            sb.append((char)('0'+st.pop()));
        }
        return sb.toString();
    }
}
