package boj;

import java.util.Scanner;

public class Boj2954 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String input = sc.nextLine();
        input = input.replaceAll("(a|e|i|o|u)(p{1})(a|e|i|o|u)","$1");
        System.out.println(input);


    }
}


