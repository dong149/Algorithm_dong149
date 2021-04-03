package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj1939 {
    public static class Node{
        int end;
        int val;

        public Node(int end,int val){
            this.end = end;
            this.val = val;
        }
}
    static List<List<Node>> map = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        long right=-1;
        for(int i=0;i<n;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int a,b,c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map.get(a-1).add(new Node(b-1,c));
            map.get(b-1).add(new Node(a-1,c));
            right = Math.max(right,c);
        }
        int start,goal;
        start = sc.nextInt();
        goal = sc.nextInt();
        long left=1;
        long res=0;
        while(left<=right){
            long mid = (left+right)/2;
            boolean[] visited = new boolean[n];
            visited[start-1] = true;
            boolean check = dfs(visited,start-1,goal-1,mid);
            if(check){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(res);
    }

    public static boolean dfs(boolean[] visited,int cur,int goal,long w){
        if(cur==goal){
            return true;
        }
        for(int i=0;i<map.get(cur).size();i++){
            int next = map.get(cur).get(i).end;
            int val =map.get(cur).get(i).val;
            if(!visited[next]&&val>=w){
                visited[next] = true;
                if(dfs(visited,next,goal,w))
                    return true;
//                visited[next] = false;
            }
        }
        return false;
    }
}
