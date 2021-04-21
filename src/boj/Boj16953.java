package boj;

import java.util.*;

public class Boj16953 {
    static long a, b;
    static int res = -1;
    static Map<Long, Integer> visited = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        bfs();
        if (res < 0)
            System.out.println(-1);
        else
            System.out.println(res + 1);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, 0));
        visited.put(a, 1);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.val == b) {
                res = Math.max(cur.cnt, res);
            }
            long next = Long.parseLong(String.valueOf(cur.val) + "1");
            if (next <= b && !visited.containsKey(next)) {
                q.add(new Node(next, cur.cnt + 1));
                visited.put(next, 1);
            }
            if (cur.val * 2 <= b && !visited.containsKey(cur.val * 2)) {
                q.add(new Node(cur.val * 2, cur.cnt + 1));
                visited.put(cur.val * 2, 1);
            }
        }
    }

    public static class Node {
        long val;
        int cnt;

        public Node(long val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

    }
}
