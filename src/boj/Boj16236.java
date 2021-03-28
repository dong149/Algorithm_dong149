package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



// bfs로 한 칸씩 커지면서, 먹을 수 있는 물고기가 나오는 경우에, 해당 물고기를 계속해서 찾아주고, 최종적으로 선택된 물고기쪽으로 향한다. 이 때, 이동한 크기를 res에 저장해준다.
// 이 때, 물고기를 잡아 먹은 경우 아기 상어의 크기를 체크해준다.
// 같은 bfs알고리즘을 반복한다.
// 만약에 더이상 선택할 수 없는 경우 Return 하고 res 를 출력해준다.
public class Boj16236 {

    public static class Pos {
        int x;
        int y;
        int move;

        public Pos(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int startX = 0, startY = 0;
        int size = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                }
            }
        }
        int eat = 0;
        while (true) {

            Pos cur = bfs(map, n, startX, startY, size);

            // 못찾은 경우
            if (cur.x > n && cur.y > n) {
                System.out.println(ans);
                return;
            } else {
                // 먹은 경우
                eat++;
                // 물고기가 사이즈 업을 해야하는 상황인지 체크한다.
                if (size == eat) {
                    size++;
                    eat = 0;
                }
                // 원래 있던 값을 0으로 바꿔준다.
                map[startX][startY] = 0;
                startX = cur.x;
                startY = cur.y;
            }
        }
    }


    public static Pos bfs(int[][] map, int n, int x, int y, int size) {

        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int eX = n + 1;
        int eY = n + 1;
        int eMove = Integer.MAX_VALUE;
        boolean find = false;
        q.add(new Pos(x, y, 0));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int cX = cur.x;
            int cY = cur.y;
            int cMove = cur.move;
            for (int i = 0; i < 4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                if (nX >= 0 && nX < n && nY >= 0 && nY < n) {
                    // 지나갈 수 있을 때, 그냥 지나간다.
                    if (!visited[nX][nY] && (map[nX][nY] == size || map[nX][nY] == 0)) {
                        q.add(new Pos(nX, nY, cMove + 1));
                        visited[nX][nY] = true;
                    } else if (!visited[nX][nY] && (map[nX][nY] < size && map[nX][nY] > 0)) {
                        // 물고기를 먹을 수 있을 때,
                        // eMove는 현재까지 먹을 수 있는 물고기 중 가장 가까운 거리를 의미한다.
                        // 먹게 되므로, ans에 값을 추가해준다.
                        visited[nX][nY] = true;
                        if (eMove > cMove + 1) {
                            eX = nX;
                            eY = nY;
                            eMove = cMove + 1;
                            ans += cMove + 1;
                        } else if (eMove == cMove + 1) {
                            if (eX > nX) {
                                eX = nX;
                                eY = nY;
                            } else if (eX == nX) {
                                if (eY > nY) {
                                    eY = nY;
                                }
                            }
                        }


                    }
                }

            }
        }
        // 찾은 가장 가까운 물고기의 좌표를 리턴한다.
        return new Pos(eX, eY, eMove);
    }
}
