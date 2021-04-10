package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2252 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int[] target;
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        target = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            map.get(a).add(b);
            target[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (target[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (int next : map.get(cur)) {
                target[next]--;
                if (target[next] == 0) {
                    q.add(next);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(ans.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
