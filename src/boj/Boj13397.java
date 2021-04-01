package boj;

import java.util.Scanner;

public class Boj13397 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int left = 0;
        int right = 10000;
        int mid =0;
        int res = 0;
        while(left<=right){
            mid =(left+right)/2;
            if(check(a,n,m,mid)){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        System.out.println(res);



    }
    public static boolean check(int[] a,int n,int m,int mid ){
        int max=0;
        int min=0;
        int cnt=1;
        for(int i=0;i<n;i++) {
            if(i==0){
                max = a[i];
                min = a[i];
            }else{
                // 최대값 , 최소값 갱신
                // 만약에 최대, 최소의 차이가 mid보다 크다면, 구간을 하나 더 추가해야 된다.
                max = Math.max(max,a[i]);
                min = Math.min(min,a[i]);
                if(max-min>mid){
                    //최대값보다 커지면, 구간이 하나 더 늘어난다.
                    cnt++;
                    max = a[i];
                    min = a[i];
                }
            }
        }
        if(cnt>m)
            return false;
        else
            return true;

    }
}
