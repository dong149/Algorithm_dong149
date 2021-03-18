package boj;

import java.util.Scanner;

public class Boj13458 {
    static int n,b,c;
    static int[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long answer=0;
        list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = sc.nextInt();
        }
        b = sc.nextInt();
        c = sc.nextInt();

        for(int i=0;i<n;i++){
            answer += solve(list[i],b,c);
        }

        System.out.println(answer);
    }

    private static long solve(int a,int b,int c){
        long sum=1;
        if(a<=b){
            return 1;
        }else{
            sum += (a-b)/c;
            if((a-b)%c!=0)
                sum++;
        }
        return sum;

    }

}
