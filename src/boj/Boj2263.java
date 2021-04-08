package boj;

import java.util.Scanner;

public class Boj2263 {
    static int n;
    static int[] in;
    static int[] post;
    static int[] center;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        in = new int[n + 1];
        post = new int[n + 1];
        center = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            in[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            post[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            center[in[i]] = i;
        }
        solve(1,n,1, n);
        System.out.println(sb);
    }

    public static void solve(int is,int ie,int ps,int pe) {
        if(is>ie||ps>pe)
            return;
        int root = post[pe];
        sb.append(root).append(" ");
        int inRoot = center[root];
        int left = inRoot-is;
        solve(is,inRoot-1,ps,ps+left-1);
        solve(inRoot+1,ie,ps+left,pe-1);
    }
}


