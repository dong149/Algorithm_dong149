package boj;

import java.util.Scanner;

public class Boj10987 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.replaceAll("[^a|e|i|o|u]","");
        System.out.println(input.length());

    }
}
