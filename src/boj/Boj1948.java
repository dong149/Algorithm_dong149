package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Boj1948 {
    static int n,m,start,end;
    static int[] ans;
    static int[] parentNum;
    static ArrayList<ArrayList<Road>> map = new ArrayList<>();
    static ArrayList<ArrayList<Road>> cost = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
            cost.add(new ArrayList<>());
        }
        ans = new int[n+1];
        parentNum = new int[n+1];
        for(int i=0;i<m;i++){
            int a,b,c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map.get(a).add(new Road(b,c));
            cost.get(b).add(new Road(a,c));
            parentNum[b]++;
        }
        start = sc.nextInt();
        end = sc.nextInt();
        q.add(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Road road:map.get(cur)){
                int next = road.goal;
                parentNum[next]--;
                if(ans[cur]+road.time>ans[next]){
                    ans[next] =ans[cur]+road.time;
                }
                if(parentNum[next]==0){
                    q.add(next);
                }
            }
        }
        q = new LinkedList<>();
        q.add(end);
        int cnt=0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Road road:cost.get(cur)){
                int next = road.goal;
                if(road.time!=0&&ans[cur]-ans[next]==road.time){
                    q.add(next);
                    cnt++;
                    road.time=0;
                }
            }
        }
        System.out.println(ans[end]);
        System.out.println(cnt);
    }
    public static class Road{
        int goal;
        int time;

        public Road(int goal,int time){
            this.goal = goal;
            this.time = time;
        }
    }
}
