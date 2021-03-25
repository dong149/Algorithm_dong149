package boj;

import java.util.Scanner;

public class Boj12015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] res = new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(i==0) {
                res[0] = arr[i];
                continue;
            }
            if(res[cnt]<arr[i]){
                cnt++;
                res[cnt] = arr[i];
            }else if(res[cnt]==arr[i])
                continue;
            else{
                solve(res,cnt,arr[i]);
            }
        }
//        for(int temp:res){
//            System.out.println(temp);
//        }
        System.out.println(cnt+1);
    }

    public static void solve(int[] res,int cnt,int val){
        int start = 0;
        int end = cnt;
        int ans=0;
        int mid=0;
        while(start<=end){
            mid = (start+end)/2;

            if(val<=res[mid]){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        if(res[ans] != val){
            res[ans] = val;
        }
    }


}
