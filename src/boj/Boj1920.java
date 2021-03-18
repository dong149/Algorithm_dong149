package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


// 이분 탐색 문제
// 두가지 방법으로 해결했습니다.
// Arrays.binarySearch(); 함수를 이용해서 빠르게 해결 가능합니다.
public class Boj1920 {
    //    public static void main(String[] args) throws IOException {
//        int n,m;
//        int[] nArr,mArr;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.parseInt(br.readLine());
//        nArr = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i=0;i<n;i++){
//            nArr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        m = Integer.parseInt(br.readLine());
//        mArr = new int[m];
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        for(int i=0;i<m;i++){
//            mArr[i] = Integer.parseInt(st1.nextToken());
//        }
//        Arrays.sort(nArr);
//        for(int temp:mArr){
//            if(binarySearch(nArr,temp)){
//                System.out.println(1);
//            }else{
//                System.out.println(0);
//            }
//        }
//    }
//
//    private static boolean binarySearch(int[] arr,int m){
//        int left = 0;
//        int right = arr.length-1;
//        int mid=0;
//        while(left<=right){
//            mid= (left+right)/2;
//            if(arr[mid]<m){
//                left = mid+1;
//            }else if(arr[mid]>m){
//                right = mid-1;
//            }else{
//                return true;
//            }
//        }
//        return false;
//    }
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] nArr = new int[n];
        for(int i=0;i<n;i++){
            nArr[i] = sc.nextInt();
        }
        Arrays.sort(nArr);

        m = sc.nextInt();
        for(int i=0;i<m;i++){
            if(Arrays.binarySearch(nArr,sc.nextInt())>=0){
                System.out.println(1);
            }else
                System.out.println(0);
        }
    }
}
