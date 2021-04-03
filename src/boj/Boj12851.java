package boj;

import java.awt.*;
import java.util.*;

public class Boj12851 {
    public static class Node implements Comparable<Node> {
        int end;
        int val;

        public Node(int end, int val) {
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }


    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int cnt=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[210000];
        bfs(n, k);
        System.out.println(min);
        System.out.println(cnt);
    }

    public static void bfs(int n, int k) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n,0));
        while(!q.isEmpty()){
            Point p = q.poll();
            visited[p.x] = true;
            if(p.x==k){
                if(p.y<min){
                    cnt=1;
                    min = p.y;
                }else if(p.y==min){
                    cnt++;
                }
            }
            if(p.x*2<=100000 && !visited[p.x*2]){
                q.add(new Point(p.x*2,p.y+1));
            }
            if(p.x+1<=100000 && !visited[p.x+1]){
                q.add(new Point(p.x+1,p.y+1));
            }
            if(p.x-1>=0 && !visited[p.x-1]){
                q.add(new Point(p.x-1,p.y+1));
            }

        }
    }
}

