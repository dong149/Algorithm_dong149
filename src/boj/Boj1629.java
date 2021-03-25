package boj;

import java.util.Scanner;


// 분할정복 문제 아직 못풀었다.
public class Boj1629 {

    public static long res=0;
    public static long a;
    public static long b;
    public static long c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();


        a = a%c;
        long answer = solve(b);
        System.out.println(answer);
    }

    private static long solve(long cnt){
        if(cnt==1){
            return a;
        }
        long temp = solve(cnt/2);
        if(cnt%2==1){
            return (((temp%c)*(temp%c)%c)*a)%c;
        }else{
            return ((temp%c)*(temp%c)%c);
        }


    }
}
