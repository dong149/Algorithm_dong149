package boj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj1239 {

    static int len=0;
    static int ans=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        len = n;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] arrN = new int[n];
        boolean[] visited = new boolean[n];
        dfs(arrN,arr,visited,0);

        System.out.println(ans);

    }
    public static void dfs(int[] arrN,int[] arr,boolean[] visited,int cnt){
        if(len==cnt){
            ArrayList<Integer> sum = new ArrayList<>();
            Map<Integer,Integer> map = new HashMap<>();
            int cur=0;
            for(int i=0;i<len;i++){
                cur += arrN[i];
                map.put(cur,1);
                sum.add(cur);
            }
            int res=0;
            for(int i=0;i<sum.size();i++){
                int temp = sum.get(i);
                if(map.containsKey(temp+50)){
                    res++;
                }
            }
            ans = Math.max(res,ans);


        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] =true;
                arrN[cnt] = arr[i];
                dfs(arrN,arr,visited,cnt+1);
                arrN[cnt] = 0;
                visited[i] = false;
            }
        }


    }
}
