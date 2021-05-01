package boj;

import java.util.Scanner;

public class Boj12904 {
    static int tLen;
    static String t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        t = sc.nextLine();
        tLen = t.length();
        StringBuilder sb = new StringBuilder();
        sb.append(t);
        boolean mode=false;
        boolean res = false;
        while(true){
            if(sb.length()==s.length()){
                if(!mode){
                    if(sb.toString().equals(s)){
                        res = true;
                    }
                }else{
                    if(sb.reverse().toString().equals(s)){
                        res = true;
                    }
                }
                break;
            }
            char cur;
            if(!mode){
                cur = sb.charAt(sb.length()-1);
                if(cur=='A'){
                    sb.deleteCharAt(sb.length()-1);
                }else{
                    sb.deleteCharAt(sb.length()-1);
                    mode = true;
                }
            }else{
                cur = sb.charAt(0);
                if(cur=='A'){
                    sb.deleteCharAt(0);
                }else{
                    sb.deleteCharAt(0);
                    mode = false;
                }
            }
        }
        if(res){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }


}
