package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj11559 {
//
//    static char[][] map = new char[12][6];
//    static int[] dx = {0, 0, 1, -1};
//    static int[] dy = {1, -1, 0, 0};
//    static int res = 0;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 12; i++) {
//            map[i] = sc.nextLine().toCharArray();
//        }
//
//        int nX, nY;
//        while(true) {
//            boolean[][] visited = new boolean[12][6];
//            for (int i = 0; i < 12; i++) {
//                for (int j = 0; j < 6; j++) {
//                    if (map[i][j] != '.' && !visited[i][j]&&check(i, j, map[i][j],visited)) {
//                        res++;
//                    }
//                }
//            }
//            for (int i = 11; i >= 0; i--) {
//                for (int j = 5; j >= 0; j--) {
//                    if (visited[i][j]) {
//                        map[i][j] = '.';
//                    }
//                }
//            }
//            res++;
//            down();
//        }
//
//
//        System.out.println(res);
//
//
//    }
//
//    public static boolean check(int x, int y, char temp,boolean[][] visited) {
//        Queue<int[]> q = new LinkedList<>();
//        Queue<int[]> visitQ = new LinkedList<>();
//        q.add(new int[]{x, y});
//        visitQ.add(new int[]{x, y});
//        visited[x][y] = true;
//        int cnt = 0;
//        while (!q.isEmpty()) {
//            int[] cur = q.poll();
//            cnt++;
//            for (int i = 0; i < 4; i++) {
//                int nX = cur[0] + dx[i];
//                int nY = cur[1] + dy[i];
//                if (nX >= 0 && nX < 12 && nY >= 0 && nY < 6 && map[nX][nY] == temp && !visited[nX][nY]) {
//                    q.add(new int[]{nX, nY});
//                    visited[nX][nY] = true;
//                    visitQ.add(new int[]{nX, nY});
//                }
//            }
//        }
//        if (cnt >= 4) {
//            return true;
//        }else{
//            while(!visitQ.isEmpty()){
//                int[] cur = visitQ.poll();
//                visited[cur[0]][cur[1]] = false;
//            }
//            return false;
//        }
//    }
//
//    public static void dfs(int x, int y, char temp) {
//        map[x][y] = '.';
//        int nX, nY;
//        for (int i = 0; i < 4; i++) {
//            nX = x + dx[i];
//            nY = y + dy[i];
//            if (nX >= 0 && nX < 12 && nY >= 0 && nY < 6 && map[nX][nY] == temp) {
//                dfs(nX, nY, temp);
//            }
//        }
//    }
//
//    public static void down() {
//        int nX, nY;
//        for (int i = 11; i >= 0; i--) {
//            for (int j = 5; j >= 0; j--) {
//                nX = i - 1;
//                nY = j;
//                if (i - 1 >= 0 && map[i][j] == '.' && map[nX][nY] != '.') {
//                    map[i][j] = map[nX][nY];
//                }
//            }
//        }
//    }
}
