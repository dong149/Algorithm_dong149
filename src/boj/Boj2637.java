package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2637 {
    static int n, m;
    static ArrayList<ArrayList<Edge>> map = new ArrayList<>();
    static int[] parentNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        parentNum = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map.get(b).add(new Edge(a, c));
            parentNum[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[][] res = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            if (parentNum[i] == 0) {
                res[i][i] = 1;
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge edge : map.get(cur)) {
                int next = edge.end;
                int nVal = edge.val;
                parentNum[next]--;
                for(int i=1;i<=n;i++){
                    res[next][i] = res[next][i]+res[cur][i]*nVal;
                }
                if(parentNum[next]==0)
                    q.add(next);
            }
        }

        for(int i=1;i<=n;i++){
            if(res[n][i]>0){
                System.out.println(i+" "+res[n][i]);
            }
        }

    }
//
//    public static class Node {
//        int[] arr;
//        int cur;
//
//        public Node(int[] arr, int cur) {
//            this.arr = arr;
//            this.cur = cur;
//        }
//    }

    public static class Edge {
        int end;
        int val;

        public Edge(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }
}
