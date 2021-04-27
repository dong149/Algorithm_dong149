package boj;

import java.util.Scanner;

public class Boj9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-->0){
            String[] temp = sc.nextLine().split(" ");
            StringBuilder res = new StringBuilder();
            for(int i=0;i<temp.length;i++){
                StringBuilder sb = new StringBuilder(temp[i]);
                res.append(sb.reverse().toString()).append(' ');
            }
            System.out.println(res);
        }


    }
}
