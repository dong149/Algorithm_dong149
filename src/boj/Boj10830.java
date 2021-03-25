package boj;

import java.util.Scanner;

public class Boj10830 {
    static int[][] arr;
    static int[][] a;
    static int[][] temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        long b;
        n = sc.nextInt();
        b = sc.nextLong();
        arr = new int[n][n];
        a = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
                a[i][j]= arr[i][j];
            }
        }
        solve(b,n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }



    }

    private static void solve(long cnt,int n){

        if(cnt==1){
            temp = a;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    temp[i][j] = temp[i][j]%1000;
                }
            }
            return;
        }
        solve(cnt/2,n);
        int[][] res;
        if(cnt%2==1){
            res = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        res[i][j] += (temp[i][k]*temp[k][j])%1000;
                    }
                    res[i][j] = res[i][j]%1000;
                }
            }
            temp = res;
            res = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        res[i][j] += (temp[i][k]*a[k][j])%1000;
                    }
                    res[i][j] = res[i][j]%1000;
                }
            }
            temp = res;
        }else{
            res = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        res[i][j] += (temp[i][k]*temp[k][j])%1000;
                    }
                    res[i][j] = res[i][j]%1000;
                }
            }
            temp = res;
        }





    }

}
