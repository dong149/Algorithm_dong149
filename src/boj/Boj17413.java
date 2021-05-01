package boj;

import java.util.Scanner;
import java.util.Stack;

public class Boj17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isInTag = false;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(isInTag){
                if(cur=='>'){
                    sb.append('>');
                    isInTag = false;
                    continue;
                }else{
                    sb.append(cur);
                    continue;
                }
            }
            if(cur=='<'){
                isInTag= true;
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
                sb.append('<');
                continue;
            }
            if(cur>='a'&&cur<='z'||cur>='0'&&cur<='9'){
                st.push(cur);
            }else if(cur==' '){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
                sb.append(' ');
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb);

    }
}
