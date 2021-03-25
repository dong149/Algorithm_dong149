package boj;

import java.util.Scanner;

public class Boj11401 {

    // ( n,k ) = ( n-1,k ) + ( n-1,k-1 )
    private static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
//        long [][] arr = new long[n+1][n+1];
//        arr[0][0] = 1;
//        arr[1][0] = 1;
//        arr[1][1] = 1;
        long res= solve(n,k);

        System.out.println(res);

    }


    private static long solve(int n,int k){
//        System.out.println("n: "+n+"k: "+k);
//        if(arr[n][k]>0){
//            return arr[n][k];
//        }
        if(k==0||n==k){
            return 1;
        }
        return (solve(n-1,k)%MOD + solve(n-1,k-1)%MOD)%MOD;


    }
}
