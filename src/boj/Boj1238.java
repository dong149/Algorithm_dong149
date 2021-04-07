package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1238 {
    static int n, m, x;

    public static class Node implements Comparable<Node> {
        int pos;
        int t;

        public Node(int pos, int t) {
            this.pos = pos;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }

    static final int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        int[] dist = new int[n];
        int[] dist2 = new int[n];
        ArrayList<ArrayList<Node>> map = new ArrayList<>();
        ArrayList<ArrayList<Node>> map2 = new ArrayList<>();
        Arrays.fill(dist, INF);
        Arrays.fill(dist2, INF);
        for (int i = 0; i < m; i++) {
            map.add(new ArrayList<>());
            map2.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map.get(a - 1).add(new Node(b - 1, c));
            map2.get(b - 1).add(new Node(a - 1, c));
        }
        djk(map, dist);
        djk(map2, dist2);
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dist[i] + dist2[i], max);
        }

        System.out.println(max);
    }

    public static void djk(ArrayList<ArrayList<Node>> map, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x - 1, 0));
        boolean[] visited = new boolean[n];
        dist[x - 1] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.pos])
                continue;
            else
                visited[cur.pos] = true;
            for (Node next : map.get(cur.pos)) {
                if (!visited[next.pos]&&dist[next.pos] > dist[cur.pos] + next.t) {
                    dist[next.pos] = dist[cur.pos] + next.t;
                    pq.add(new Node(next.pos, dist[next.pos]));
                }
            }
        }
    }

}
