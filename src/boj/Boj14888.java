package boj;

import java.util.Scanner;

public class Boj14888 {
    private static int max= Integer.MIN_VALUE;
    private static int min= Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] oper = new int[4];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        // input of operations
        for(int i=0;i<4;i++){
            oper[i] = sc.nextInt();
        }
        dfs(arr,oper,1,n,arr[0]);

        System.out.println(max);
        System.out.println(min);

    }


    private static void dfs(int[] arr,int[] oper,int cnt,int n,int val){
        if(cnt==n){
            min = Math.min(min,val);
            max = Math.max(max,val);
        }else{
            for(int i=0;i<4;i++){
                if(oper[i]>0){
                    oper[i] -= 1;
                    switch (i){
                        case 0: {
                            dfs(arr,oper,cnt+1,n,val+arr[cnt]);
                            break;
                        }
                        case 1: {
                            dfs(arr,oper,cnt+1,n,val-arr[cnt]);
                            break;
                        }
                        case 2: {
                            dfs(arr,oper,cnt+1,n,val*arr[cnt]);
                            break;
                        }
                        case 3: {
                            dfs(arr,oper,cnt+1,n,val/arr[cnt]);
                            break;
                        }
                    }
                    oper[i] += 1;
                }
            }
        }

    }
}
