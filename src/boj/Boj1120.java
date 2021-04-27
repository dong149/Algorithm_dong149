package boj;

import java.util.Scanner;

public class Boj1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String a = input[0];
        String b = input[1];
        int lenA = a.length();
        int lenB = b.length();

        int minCnt=100;
        for(int i=0;i<=lenB-lenA;i++){
            int cnt=0;
            for(int j=0;j<lenA;j++){
                if(a.charAt(j)!=b.charAt(i+j)){
                    cnt++;
                }
            }
            minCnt = Math.min(minCnt,cnt);

        }
        System.out.println(minCnt);
    }
}
