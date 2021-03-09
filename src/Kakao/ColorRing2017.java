package Kakao;

import java.util.LinkedList;
import java.util.Queue;


/*
출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다.
여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다.
(영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

bfs를 이용하여 푸는 문제
 */

public class ColorRing2017 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static Queue<Node> queue = new LinkedList<Node>();
    static boolean[][] visited;
    static int size = 0;


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    size = 1;
                    bfs(picture, i, j, m, n);
                    numberOfArea++;
                    if (maxSizeOfOneArea < size)
                        maxSizeOfOneArea = size;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static void bfs(int[][] pic, int x, int y, int m, int n) {
        queue.add(new Node(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            // queue 첫 번째로 들어간 값을 제거함.
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (pic[nx][ny] == pic[x][y] && !visited[nx][ny]) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        size++;
                    }
                }
            }

        }
    }
}




