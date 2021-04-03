package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2470 {
    static long[] answer={0,1000000000};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            bSearch(arr,n,i);
        }
        System.out.println(answer[0]+" "+answer[1]);
    }

    public static void bSearch(long[] arr, int n,int idx){
        int left = 0;
        int right = n-1;
        int mid=0;
        int res;
        while(left<=right){
            mid = (left+right)/2;
            if(arr[idx]+arr[mid]<0){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(Math.abs(answer[0]+answer[1])>Math.abs(arr[idx]-arr[mid])){
            if(arr[idx]<arr[mid]){
                answer[0] = arr[idx];
                answer[1] = arr[mid];
            }else{
                answer[0] = arr[mid];
                answer[1] = arr[idx];
            }
        }
//        System.out.println(arr[mid]);
    }
}
