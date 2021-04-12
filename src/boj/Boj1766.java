package boj;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1766 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int[] parentNum;
    static ArrayList<Integer> ans = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        parentNum = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            map.get(a).add(b);
            parentNum[b]++;
        }


        for (int i = 1; i <= n; i++) {
            if (parentNum[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            ans.add(cur);
            for (int next : map.get(cur)) {
                parentNum[next]--;
                if (parentNum[next] == 0)
                    pq.add(next);
            }
        }

        for (int temp : ans) {
            System.out.print(temp + " ");
        }
        System.out.println();


    }
}
