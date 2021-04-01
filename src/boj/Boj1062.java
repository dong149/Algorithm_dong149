package boj;

import java.util.Scanner;

public class Boj1062 {
    public static int max=0;
    public static char[] initChar = {'a','n','t','i','c'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        String[] a = new String[n];
        boolean[] visited = new boolean[28];
        for(int i=0;i<initChar.length;i++){
            visited[initChar[i]-'a'] = true;
        }
        for(int i=0;i<n;i++){
            a[i] = sc.nextLine().replaceAll("[a|n|t|i|c]","");
        }
        if(k<5){
            System.out.println(0);
            return;
        }
        dfs(a,visited,0,k-5,0);
        System.out.println(max);

    }

    public static void dfs(String[] a,boolean[] visited,int cnt,int m,int idx){
        if(cnt==m||m<0){
            int checkCnt=0;
            for(int i=0;i<a.length;i++){
                boolean check=true;
//                System.out.println(cnt);
                for(int j=0;j<a[i].length();j++){
                    if(!visited[a[i].charAt(j)-'a']) {
                        check=false;
                        break;
                    }
                }
                if(check){
                    checkCnt++;
                }
            }
            max = Math.max(checkCnt,max);
            return;
        }
        for(int i=idx;i<('z'-'a'+1);i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(a,visited,cnt+1,m,i+1);
                visited[i] = false;
            }
        }
    }

}
