package boj;

import java.util.Scanner;

public class Boj5555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        int res=0;
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            String in = sc.nextLine();
            if(sb.append(in).append(in).toString().contains(s)){
                res++;
            }
        }
        System.out.println(res);
    }
}
