package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj5014 {
    static int s, g, f, u, d;

    public static class Node {
        int stair, cnt;

        public Node(int stair, int cnt) {
            this.stair = stair;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        boolean[] visited = new boolean[f + 1];
        int res = bfs(visited);
        if (res < 0)
            System.out.println("use the stairs");
        else
            System.out.println(res);

    }

    public static int bfs(boolean[] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, 0));
        visited[s] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.stair;
            if (cur == g)
                return node.cnt;
            if (cur + u <= f && !visited[cur + u]) {
                q.add(new Node(cur + u, node.cnt + 1));
                visited[cur + u] = true;
            }
            if (cur - d >= 1 && !visited[cur - d]) {
                q.add(new Node(cur - d, node.cnt + 1));
                visited[cur - d] = true;
            }
        }
        return -1;

    }
}
