package boj;

import java.util.Scanner;

public class Boj6603 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String[] in = sc.nextLine().split(" ");
            if(in[0].equals("0")){
                break;
            }
            boolean[] visited = new boolean[Integer.parseInt(in[0])];
            dfs(in,0,0,visited);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static void dfs(String[] in,int idx,int cnt,boolean[] visited){

        if(cnt==6){
            for(int i=0;i<visited.length;i++){
                if(visited[i]){
                    sb.append(in[i+1]).append(' ');
                }
            }
            sb.append('\n');
        }
        if(idx>=visited.length){
            return;
        }
        for(int i=idx;i<visited.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(in,i+1,cnt+1,visited);
                visited[i] = false;
            }
        }




    }

}
