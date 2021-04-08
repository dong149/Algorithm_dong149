package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj15686 {
    static int n, m;
    static int[][] a;
    static boolean[] visited;
    static int chick = 0;
    static int h = 0;
    static int res = 987654321;
    static ArrayList<Node> chList = new ArrayList<>();
    static ArrayList<Node> hList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2) {
                    chick++;
                    chList.add(new Node(i, j));
                } else if (a[i][j] == 1) {
                    h++;
                    hList.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chick];
        dfs(0, 0);
        System.out.println(res);
    }

    public static void dfs(int cnt, int idx) {
        if (cnt == m) {
            int temp = 0;
            for (int i = 0; i < h; i++) {
                int tempMin = 987654321;
                for (int j = 0; j < chick; j++) {
                    if (visited[j]) {
                        Node cur = chList.get(j);
                        tempMin = Math.min(Math.abs(hList.get(i).x - cur.x) + Math.abs(hList.get(i).y - cur.y), tempMin);
                    }
                }
                temp += tempMin;
            }
            res = Math.min(res, temp);
            return;
        }
        for (int i = idx; i < chick; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Node cur = chList.get(i);
                dfs(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
