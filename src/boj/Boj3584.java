package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj3584 {
    static int T;
    static int n;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            ArrayList<ArrayList<Integer>> map = new ArrayList<>();
            boolean[] isParent = new boolean[n + 1];
            for (int i = 1; i <= n + 1; i++) {
                map.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int child, parent;
                parent = sc.nextInt();
                child = sc.nextInt();
                map.get(child).add(parent);
            }
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            dfs(map, isParent, a);
            dfs(map, isParent, b);
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> map, boolean[] isParent, int cur) {
        if (isParent[cur]) {
            res = cur;
            return;
        }
        isParent[cur] = true;
        for (int next : map.get(cur)) {
            dfs(map, isParent, next);
        }

    }
}
