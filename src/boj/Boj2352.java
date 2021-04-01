package boj;

import java.util.Scanner;

public class Boj2352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] res = new int[n+1];
        for(int i=1;i<=n;i++) {
            a[i] = sc.nextInt();
        }

        int cnt=0;
        for(int i=1;i<=n;i++){
            if(a[i]>res[cnt]){
                res[++cnt] = a[i];
            }else if(a[i]<res[cnt]){
                int left = 1;
                int right = cnt;
                int find=0;
                int mid=0;
                while(left<=right){
                    mid = (left+right)/2;
                    if(res[mid]>=a[i]){
                        find = mid;
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
                res[find] = a[i];
            }
//            for(int j=1;j<=cnt;j++){
//                System.out.print(res[j]+" ");
//            }
//            System.out.println();

        }
        System.out.println(cnt);
    }
}