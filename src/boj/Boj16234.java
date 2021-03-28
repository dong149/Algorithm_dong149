package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16234 {
    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int cnt = 1;
    public static int res = 0;
    public static boolean isFinished = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, l, r;
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        while (true) {
            int[][] next = new int[n][n];
            int[][] visited = new int[n][n];
            isFinished = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    next[i][j] = a[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cnt++;
                    int val = 0;
                    if (visited[i][j] == 0)
                        val = bfs(a, visited, n, i, j, l, r);

                    if (val > 0) {
//                        System.out.println("val:::"+val);
                        for (int k = 0; k < n; k++) {
                            for (int t = 0; t < n; t++) {
                                if (visited[k][t] == cnt) {
//                                    if(cnt==1)
//                                        System.out.println(k + "   " + t);
                                    next[k][t] = val;
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = next[i][j];
                }
            }
            if (isFinished) {
                res++;
            } else {
                System.out.println(res);
                return;
            }
            cnt = 0;
        }
    }


    public static int bfs(int[][] a, int[][] visited, int n, int x, int y, int l, int r) {

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        visited[x][y] = cnt;

        int sum = 0;
        int cCnt = 1;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int cX = cur.x;
            int cY = cur.y;
            sum += a[cX][cY];
//            System.out.println("sum:::"+sum);
            for (int i = 0; i < 4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                if (nX >= 0 && nX < n && nY >= 0 && nY < n && visited[nX][nY] == 0) {
                    int gap = Math.abs(a[nX][nY] - a[cX][cY]);
                    if (gap >= l && gap <= r) {
                        visited[nX][nY] = cnt;
                        isFinished = true;
//                        System.out.println();
//                        System.out.println(cX + "   " + cY);
//                        System.out.println(nX + "   " + nY);
                        q.add(new Pos(nX, nY));
                        cCnt++;
//                        System.out.println("cCnt: " + cCnt);
//                        System.out.println();
                    }
                }
            }
        }
        if (cCnt == 1)
            return 0;
        return sum / cCnt;
    }
}

// 1. BFS를 하면서, visited에 다녀간 곳은 저장한다.
// 2. 저장이 된 곳은 다음 단계에 해당하는 배열을 선언해서 매번 저장된 곳은 바꿔주면서 진행한다.
