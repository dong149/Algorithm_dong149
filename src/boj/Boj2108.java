package boj;

import java.util.Arrays;
import java.util.Scanner;




public class Boj2108 {
    public static void main(String[] args) {


        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        int[] cnt = new int[8002];
        int res1=0;

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            res1 += arr[i];
            cnt[arr[i]+4000]++;
        }




        System.out.println(Math.round(1.0*res1/n));

        Arrays.sort(arr);


        System.out.println(arr[n/2]);


        int max = 0;
        int res3 = 0;
        int sameCnt = 0;
        for(int i=0;i<cnt.length;i++){
            if(max<cnt[i]){
                max = cnt[i];
                res3 = i-4000;
                sameCnt=1;
            }else if(max==cnt[i]){
                if(sameCnt==1){
                    res3 = i-4000;
                }
                sameCnt++;
            }
        }
        System.out.println(res3);
        System.out.println(arr[n-1]-arr[0]);

    }
}
