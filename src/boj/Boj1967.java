package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj1967 {
    static int n;
    static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    static int max = -1;
    static int maxIdx = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map.get(a).add(new Node(b, c));
            map.get(b).add(new Node(a, c));
        }
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        dfs(visited, 1, 0);
        visited = new boolean[n + 1];
        max=-1;
        visited[maxIdx] = true;
        dfs(visited, maxIdx, 0);
        System.out.println(max);
    }

    public static void dfs(boolean[] visited, int cur, int curW) {
        if (max < curW) {
            maxIdx = cur;
            max = curW;
        }
        for (Node next : map.get(cur)) {
            int nextN = next.end;
            int nextW = next.w;
            if (!visited[nextN]) {
                visited[nextN] = true;
                dfs(visited, nextN, curW + nextW);
            }
        }
    }


    public static class Node {
        int end, w;

        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }
}
