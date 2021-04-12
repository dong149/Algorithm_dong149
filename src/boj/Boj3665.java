package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj3665 {
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] in = new int[n];
            boolean[][] map = new boolean[n+1][n+1];
            int[] parentNum = new int[n+1];
            ArrayList<Integer> ans = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            boolean check=true;
            boolean isPossible=true;
            for(int i=0;i<n;i++){
                in[i] = sc.nextInt();
            }
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    map[in[i]][in[j]] = true;
                    parentNum[in[j]]++;
                }
            }
            int m = sc.nextInt();
            for(int i=0;i<m;i++){
                int a,b;
                a = sc.nextInt();
                b = sc.nextInt();
                if(map[a][b]==true){
                    map[b][a] = true;
                    map[a][b] = false;
                    parentNum[a]++;
                    parentNum[b]--;
                }else{
                    map[b][a] = false;
                    map[a][b] = true;
                    parentNum[a]--;
                    parentNum[b]++;
                }
            }
            for(int i=1;i<=n;i++){
                if(parentNum[i]==0){
                    q.add(i);
                }
            }
            if(q.size()>1){
                sb.append("?").append('\n');
                continue;
            }
            int cnt=0;
            for(int i=0;i<n;i++){
                if(q.isEmpty()){
                    isPossible=false;
                    break;
                }
                if(cnt>1){
                    check=false;
                    break;
                }
                int cur = q.poll();
                ans.add(cur);
                cnt=0;
                for(int j=1;j<=n;j++){
                    if(map[cur][j]){
                        parentNum[j]--;
                        if(parentNum[j]==0){
                            q.add(j);
                            cnt++;
                        }
                    }
                }
            }
            if (!isPossible) {
                sb.append("IMPOSSIBLE").append('\n');
            }
            else if(!check) {
                sb.append("?").append('\n');
            }else{
                for(int i=0;i<ans.size();i++){
                    sb.append(ans.get(i)).append(" ");
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);

    }
}
