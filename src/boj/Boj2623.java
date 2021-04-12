package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2623 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int[] parentNum;
    static ArrayList<Integer> ans = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        parentNum = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] temp = sc.nextLine().split(" ");
            for (int j = 1; j < temp.length - 1; j++) {
                int a, b;
                a = Integer.parseInt(temp[j]);
                b = Integer.parseInt(temp[j + 1]);
                map.get(a).add(b);
                parentNum[b]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (parentNum[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (int next : map.get(cur)) {
                parentNum[next]--;
                if (parentNum[next] == 0) {
                    q.add(next);
                }
            }
        }
        if (ans.size() < n) {
            System.out.println(0);
        } else {
            for (int temp : ans) {
                System.out.println(temp);
            }
        }


    }
}
