package boj;

import java.util.Scanner;
import java.util.Stack;

public class Boj4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            char[] a = sc.nextLine().toCharArray();
            if(a.length==1&&a[0]=='.')
                break;
            if(check(a)){
                sb.append("yes").append('\n');
            }else
                sb.append("no").append('\n');
        }

        System.out.print(sb);
    }
    public static boolean check(char[] a){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<a.length;i++){
            if(a[i]=='('||a[i]=='['){
                st.push(a[i]);
            }else if(a[i]==')'||a[i]==']'){
                if(!st.isEmpty()){
                    char temp = st.pop();
                    if(a[i]==')'&&temp=='('){
                        continue;
                    }else if(a[i]==']'&&temp=='[')
                        continue;
                    return false;
                }else{
                    return false;
                }
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
    }
}
