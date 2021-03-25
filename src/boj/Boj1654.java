package boj;

import java.util.Arrays;
import java.util.Scanner;


// 이분 탐색 문제, int의 범위를 연산 중에 넘을 수 있다는 사실을 인지하지 못했다. 시험에서는 그냥 long을 사용해보는 것도 좋은 방법일듯.
public class Boj1654 {

    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k,n;
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new long[k];

        for(int i=0;i<k;i++){
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        long res = bSearch(arr[arr.length-1],k,n);
        System.out.println(res);

    }


    public static long bSearch(long max,int k,int n){
        long start = 1;
        long end = max;
        long mid;
        long res = 0;
        while(start<=end){
            mid = (end+start)/2;

            int cnt=0;
            for(int i=0;i<k;i++){
                cnt += arr[i]/mid;
            }
            if(cnt>=n){
                start = mid+1;
                res = mid;
            }else{
                end = mid-1;
            }

        }
        return res;

    }
}
