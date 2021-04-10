package boj;

import java.util.Scanner;

public class Boj2467 {
    static int n;
    static int[] a;
    static int res=2_000_000_000;
    static int[] ans = new int[2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }


        int left=0;
        int right=n-1;

        while(left<right){
            int leftN = a[left];
            int rightN = a[right];

            if(Math.abs(leftN+rightN)<res){
                res = Math.abs(leftN+rightN);
                ans[0] = leftN;
                ans[1] = rightN;
            }
            if(leftN+rightN>0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(ans[0]+" "+ans[1]);

    }
}
