package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Boj14226 {
    static int s;
    static int res = 1001;
    static boolean[][] visited = new boolean[2002][2002];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();


        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0, 0));
        visited[1][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int val = cur.val;
            int cnt = cur.cnt;
            int clip = cur.clip;
            if (val == s) {
                res = Math.min(res, cnt);
            }
            if (cnt > s) {
                break;
            }
            //1
            if (clip != val) {
                q.add(new Node(val, cnt + 1, val));
            }
            //2
            if (val + clip < s * 2 && clip != 0 && !visited[val + clip][clip]) {
                q.add(new Node(val + clip, cnt + 1, clip));
                visited[val + clip][clip] = true;
            }
            //3
            if (val > 0 && !visited[val - 1][clip]) {
                q.add(new Node(val - 1, cnt + 1, clip));
                visited[val - 1][clip] = true;
            }
        }

        System.out.println(res);

    }

    public static class Node {
        int val;
        int cnt;
        int clip;

        public Node(int val, int cnt, int clip) {
            this.val = val;
            this.cnt = cnt;
            this.clip = clip;
        }

    }
}
