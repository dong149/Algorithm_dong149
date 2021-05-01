package boj;

import java.util.Scanner;

public class Boj5525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        String s= sc.nextLine();
        int res=0;
        int[] memo = new int[m];
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)=='I'&&s.charAt(i-1)=='O'&&s.charAt(i-2)=='I'){
                memo[i] = memo[i-2]+1;
            }
        }
        for(int i=0;i<m;i++){
            if(memo[i]>=n){
                res++;
            }
        }
        System.out.println(res);
    }
}
