package boj;

import java.util.Scanner;

public class Boj1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n,k;
        n = sc.nextLong();
        k = sc.nextLong();


        long res = bSearch(n,k);
        System.out.println(res);
    }


    private static long bSearch(long n ,long k) {
        long start = 1;
        long end = k;
        long mid = 0;
        long res=1;
        while(start<=end) {
            mid = (start+end)/2;
            long cnt=0;
            for(int i=1;i<=n;i++){
                cnt += Math.min(mid/i,n);
            }


            if(cnt>=k){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }

        }

        return res;

    }


}
