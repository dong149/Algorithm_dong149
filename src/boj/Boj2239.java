package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj2239 {
    static int[][] map;
    static ArrayList<Node> zero = new ArrayList<>();
    public static boolean isFinished;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[10][10];
        for (int i = 1; i <= 9; i++) {
            String temp = sc.nextLine();
            for (int j = 1; j <= 9; j++) {
                map[i][j] = temp.charAt(j - 1) - '0';
                if (map[i][j] == 0) {
                    zero.add(new Node(i, j));
                }

            }
        }
        dfs(0);

    }


    public static void dfs(int idx) {
        if (idx == zero.size()) {
            isFinished = true;
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if (isFinished) return;
        Node cur = zero.get(idx);
        for (int j = 1; j <= 9; j++) {
            if (map[cur.n][cur.m] == 0 && check(cur.n, cur.m, j)) {
                map[cur.n][cur.m] = j;
                dfs(idx + 1);
                map[cur.n][cur.m] = 0;
            }

        }
    }


    public static boolean check(int x, int y, int val) {
        for (int i = 1; i <= 9; i++) {
            if (y != i && map[x][i] == val)
                return false;
            if (x != i && map[i][y] == val)
                return false;
        }
        int xRange, yRange;
        if (x % 3 == 0)
            xRange = x - 2;
        else
            xRange = x - x % 3 + 1;
        if (y % 3 == 0)
            yRange = y - 2;
        else
            yRange = y - y % 3 + 1;

        for (int i = xRange; i < xRange + 3; i++) {
            for (int j = yRange; j < yRange + 3; j++) {
                if (x != i && y != j && map[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Node {
        int n, m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

}
