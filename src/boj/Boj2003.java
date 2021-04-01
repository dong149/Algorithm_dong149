package boj;

import java.util.Scanner;

public class Boj2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int start = 0;
        int end = 0;
        long sum = 0;
        int res =0;
        while(true){
            if(sum>=m){
                sum = sum - a[start++];
            }else if(end==n){
                break;
            }else{
                sum = sum + a[end++];
            }
            if(sum==m){
                res++;
            }
        }

        System.out.println(res);


    }
}
