package boj;

import java.util.Scanner;

public class Boj1013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();

        while(T-->0){
            String s = sc.nextLine();
            if(s.matches("((100+1+)|(01))+")){
                sb.append("YES").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
        }

        System.out.print(sb);


    }
}
