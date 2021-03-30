package boj;

import java.util.Scanner;

public class Boj13163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(sc.nextLine());
        String pattern1  = "^(\\w+)\\b";
        String pattern2 = "\\s";
        for(int i=0;i<n;i++) {
            String st = sc.nextLine();
            st = st.replaceAll(pattern1,"god");
            st = st.replaceAll(pattern2,"");
            sb.append(st).append('\n');
        }
        System.out.print(sb);
    }


}
