package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        long m = sc.nextLong();
        Arrays.sort(a);
        int start = 1;
        int end = a[a.length-1];
        int mid;
        int res =0;
        while(start<=end){
            mid = (start+end)/2;
            long sum=0;
            for(int i=0;i<n;i++){
                if(a[i]>mid){
                    sum+= mid;
                }else{
                    sum += a[i];
                }
            }

            if(sum<=m){
                res = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        System.out.println(res);
    }
}
