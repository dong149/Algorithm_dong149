package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj3190 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static public class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Pos> q = new LinkedList<>();
        int n, k;
        n = Integer.parseInt(sc.nextLine());
        k = Integer.parseInt(sc.nextLine());
        boolean[][] apple = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < k; i++) {
            String[] temp = sc.nextLine().split(" ");
            int a, b;
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
            apple[a - 1][b - 1] = true;
        }
        int l = Integer.parseInt(sc.nextLine());
        int[] time = new int[l];
        char[] dir = new char[l];
        for (int i = 0; i < l; i++) {
            String[] temp = sc.nextLine().split(" ");
            time[i] = Integer.parseInt(temp[0]);
            dir[i] = temp[1].charAt(0);
        }
        int curDir = 1;
        int curX = 0;
        int curY = 0;
        int res = 0;
        int i = 0;
        while (true) {
            if (i<l&&time[i] == res) {
                if (dir[i] == 'L') {
                    curDir--;
                    if (curDir < 0)
                        curDir = 3;
                } else {
                    curDir++;
                    if (curDir > 3)
                        curDir = 0;
                }
                i++;
            }
            int nX = curX + dx[curDir];
            int nY = curY + dy[curDir];
            q.add(new Pos(curX, curY));
            visited[curX][curY] = true;
            if (nX < 0 || nX >= n || nY < 0 || nY >= n || visited[nX][nY]) {
                res++;
                System.out.println(res);
                return;
            } else {
                if (apple[nX][nY]) {
                    apple[nX][nY] = false;
                } else {
                    Pos p = q.poll(); // cur에서 빠져나감.
                    visited[p.x][p.y] = false;
                }
                res++;
            }
            curX = nX;
            curY = nY;
        }
    }
}
