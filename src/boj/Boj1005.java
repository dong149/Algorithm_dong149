package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1005 {
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        first:
        while (T-- > 0) {
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();
            int[] cost = new int[n + 1];
            int[] ans = new int[n + 1];
            int[] parentNum = new int[n + 1];
            ArrayList<ArrayList<Integer>> map = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i <= n; i++) {
                map.add(new ArrayList<>());
            }
            for (int i = 1; i <= n; i++) {
                cost[i] = sc.nextInt();
            }
            for (int i = 0; i < k; i++) {
                int a, b;
                a = sc.nextInt();
                b = sc.nextInt();
                map.get(a).add(b);
                parentNum[b]++;
            }
            int find = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                if (parentNum[i] == 0) {
                    q.add(i);
                    ans[i] = cost[i];
                    if (i == find) {
                        sb.append(ans[i]).append('\n');
                        continue first;
                    }
                }
            }
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : map.get(cur)) {
                    parentNum[next]--;
                    ans[next] = Math.max(ans[next], ans[cur] + cost[next]);
                    if (parentNum[next] == 0) {
                        if (next == find) {
                            sb.append(ans[next]).append('\n');
                            continue first;
                        }
                        q.add(next);
                    }
                }
            }
        }
        System.out.print(sb);

    }
}
