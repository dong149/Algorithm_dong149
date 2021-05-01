package boj;

import java.util.Scanner;

public class Boj15658 {
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] oper = new int[4];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            oper[i] = sc.nextInt();
        }

        dfs(arr,oper,arr[0],1);

        System.out.println(max);
        System.out.println(min);



    }
    public static void dfs(int[] arr,int[] oper,int cur,int cnt){
        if(cnt==arr.length){
            max = Math.max(max,cur);
            min = Math.min(min,cur);
            return;
        }

        if(oper[0]>0){
            oper[0]--;
            dfs(arr,oper,cur+arr[cnt],cnt+1);
            oper[0]++;
        }
        if(oper[1]>0){
            oper[1]--;
            dfs(arr,oper,cur-arr[cnt],cnt+1);
            oper[1]++;
        }
        if(oper[2]>0){
            oper[2]--;
            dfs(arr,oper,cur*arr[cnt],cnt+1);
            oper[2]++;
        }

//        if(cur!=0&&oper[3]>0){
        if(oper[3]>0){
            oper[3]--;
            dfs(arr,oper,cur/arr[cnt],cnt+1);
            oper[3]++;
        }

    }
}
