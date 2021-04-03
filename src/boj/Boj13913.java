package boj;

import java.awt.*;
import java.util.*;

public class Boj13913 {
    public static class Node{
        int end;
        int val;

        public Node(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }


    static boolean[] visited;
    static int[] path;
    static int res=0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[210000];
        path = new int[210000];
        bfs(n, k);
        System.out.println(res);
        System.out.println(sb);
    }

    public static void bfs(int n, int k) {
        Queue<Point> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        q.add(new Point(n, 0));
        visited[n] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == k) {
                int temp = k;
                st.push(temp);
                while (temp != n) {
                    temp = path[temp];
                    st.push(temp);
                }
                while (!st.isEmpty()) {
                    sb.append(st.pop()).append(' ');
                }
                res = p.y;
                return;

            }
            if (p.x * 2 <= 100000 && !visited[p.x * 2]) {
                q.add(new Point(p.x * 2, p.y + 1));
                path[p.x*2] = p.x;
                visited[p.x*2] = true;
            }
            if (p.x + 1 <= 100000 && !visited[p.x + 1]) {
                q.add(new Point(p.x + 1, p.y + 1));
                path[p.x+1] = p.x;
                visited[p.x+1] = true;
            }
            if (p.x - 1 >= 0 && !visited[p.x - 1]) {
                q.add(new Point(p.x - 1, p.y + 1));
                path[p.x-1] = p.x;
                visited[p.x-1] = true;
            }

        }
    }
}
