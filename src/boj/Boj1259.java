package boj;

import java.util.Scanner;

public class Boj1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String temp = sc.nextLine();
            if(temp.equals("0")){
                break;
            }
            StringBuilder sb = new StringBuilder(temp);
            String temp2 = sb.reverse().toString();
            if(temp.equals(temp2)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
