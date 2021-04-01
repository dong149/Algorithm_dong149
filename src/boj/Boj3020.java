package boj;

import java.util.Scanner;

public class Boj3020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,h;
        n = sc.nextInt();
        h = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int left = 2;
        int right = h;
        int mid = 0;
        int res =Integer.MAX_VALUE;
        int sumMin = Integer.MAX_VALUE;
        while(left<=right){
            mid = (left+right)/2;
            int sum=0;
            // 장애물 몇 번 지나는지 체크한다.
            for(int i=0;i<n;i++){
                if(i%2==0&&mid<a[i]){
                    sum++;
                }else if(i%2==1&&mid>h-a[i]){
                    sum++;
                }
            }
            // sum이 이전까지의 MIN 보다 작을 경우에 더 내려본다. 일단 mid 값은 저장
            if(sumMin>=sum) {
                res = sum;
                sumMin = sum;




            }





        }




    }
}
