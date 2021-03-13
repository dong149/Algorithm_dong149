package Kakao;

import java.util.LinkedList;
import java.util.Queue;



/**
 * 2020 카카오 인턴십 경주로 건설
 * 느낀점 : 결국에는 혼자 풀지 못하였다. 계속 테스트 케이스 몇개가 틀리게 나왔는데, 그 이유는 [n-1][n-1] 값이 계속 변할 수 있게끔 처리해주지 않았기 때문이다. 다시 풀어볼 것!
 * BFS를 이용함. 중요한 포인트는 check를 따로 쓰지 않고 , 새로 구한 값이 작으면 계속해서 업데이트 시켜줄 수 있도록 하나의 map배열을 통해서 연산을 진행한다는 것이다.
 **/

public class BuildRideRoad2020 {
    public static void main(String[] args) {
//        int[][] test = {{0,1,0},{0,0,0,},{1,0,0,}};
//        int answer = solution(test);
//        System.out.println(answer);
    }
    static class Pos {
        int x;
        int y;
        int sum;
        int dir;

        public Pos(int x, int y, int sum, int dir) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.dir = dir;
        }
    }

    static int minValue;
    static int[][] map;
    static int n;
    //좌,우,상,하 = 0,1,2,3
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static int solution(int[][] board) {
        minValue = Integer.MAX_VALUE;
        n = board.length;
        map = board;

        bfs(0, 0, 0, -1);

        return minValue;


    }

    private static void bfs(int x, int y, int sum, int vector) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y, 0, -1));
        map[0][0] = 1;
        while (!q.isEmpty()) {
            Pos curPos = q.poll();
            // 마지막에 도달.
            if (curPos.x == n - 1 && curPos.y == n - 1) {
                minValue = curPos.sum;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = curPos.x + dx[i];
                int nextY = curPos.y + dy[i];


                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && map[nextX][nextY] != 1) {
                    int nextSum = 0;
                    // 같은 방향
                    if (curPos.dir == -1 || curPos.dir == i) {
                        nextSum = curPos.sum + 100;
                    } else {
                        nextSum = curPos.sum + 600;
                    }

                    if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = nextSum;
                        q.add(new Pos(nextX, nextY, nextSum, i));
                    } else if (map[nextX][nextY] >= nextSum) {
                        map[nextX][nextY] = nextSum;
                        q.add(new Pos(nextX, nextY, nextSum, i));
                    }
                }
            }
        }


    }


}
