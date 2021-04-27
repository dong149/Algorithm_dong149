package boj;

import java.util.Scanner;

public class Boj10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb;

        String s = sc.nextLine();
        sb = new StringBuffer(s);
        String r = sb.reverse().toString();
        if(s.equals(r)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
//
//        for(int i=0;i<s.length()/2;i++){
//            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
//                System.out.println(0);
//                return;
//            }
//        }
//        System.out.println(1);
    }
}
