package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2110 {

    public static void main(String[] args) {
        int n, c;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[n - 1] - arr[0];
        int mid = 0;
        int ans = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int cnt = 1;
            int start = arr[0];
            for (int i = 1; i < n; i++) {
                if(arr[i]-start>=mid){
                    cnt++;
                    start = arr[i];
                }
            }
            if (cnt >= c){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
