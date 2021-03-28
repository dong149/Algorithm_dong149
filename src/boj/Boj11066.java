package boj;

import java.util.Scanner;


// 파일 합치기 문제 다시 풀기
public class Boj11066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] sum = new int[n];
            int[][] dp = new int[n][n];
            int temp=0;
            for(int j=0;j<n;j++){
                arr[i] = sc.nextInt();
                temp+=arr[i];
                sum[i] = temp;
            }
            for(int j=0;j<n;j++){
                for(int k=j+1;k<n;k++){

                }
            }

        }

    }
}
