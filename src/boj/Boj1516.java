package boj;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 게임 개발
public class Boj1516 {
    static int n;
    static int[] parentNum;
    static int[] cost;
    static int[] ans;
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parentNum = new int[n + 1];
        cost = new int[n + 1];
        ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            while (true) {
                int temp = sc.nextInt();
                if (temp == -1)
                    break;
                if (cnt == 0) {
                    cost[i] = temp;
                    cnt++;
                    continue;
                }
                map.get(temp).add(i);
                parentNum[i]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (parentNum[i] == 0) {
                ans[i] += cost[i];
                q.add(i);
            }
        }
        int time = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : map.get(cur)) {
                parentNum[next]--;
                ans[next] = Math.max(ans[cur] + cost[next], ans[next]);
                if (parentNum[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
        System.out.println();
    }
}
