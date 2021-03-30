package boj;

import java.util.Scanner;

public class Boj2671 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String pattern = "^(100+1+|01)+$";

        boolean res = st.matches(pattern);

        if(res)
            System.out.println("SUBMARINE");
        else
            System.out.println("NOISE");



    }



}
