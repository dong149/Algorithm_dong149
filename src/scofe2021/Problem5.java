package scofe2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5 {
    // 가로 n, 세로 m;
    static int n;
    static int m;
    static char[][] arr;
    static int leftMin = Integer.MAX_VALUE;
//    static int moveMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        String[] splitStr;
        splitStr = temp.split(" ");
        n = Integer.parseInt(splitStr[0]);
        m = Integer.parseInt(splitStr[1]);

        arr = new char[m][n];
        boolean[][] visited;
        visited = new boolean[m][n];
        for (int i = 0; i < m - 1; i++) {
            temp = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            arr[m - 1][i] = (char) br.read();
        }

        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 'c') {
//                System.out.println("실행합니다!");
                visited[0][i] = true;
                dfs(0, i, 0, 0, visited);
//                for(int j=0;j<m;j++){
//                    for(int k=0;k<n;k++){
//                        visited[j][k] = false;
//                    }
//                }
            }
        }

        if (leftMin == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(leftMin);
        }
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
    }


    private static void dfs(int y, int x, int left, int down, boolean[][] visited) {

        if (y == m - 1) {
            leftMin = Math.min(leftMin, left);
            System.out.println();
            return;
        }

        //down
        if (arr[y + 1][x] == '.') {
            System.out.println((y + 1) + "," + x + "로 내려갑니다");
            visited[y + 1][x] = true;
            dfs(y + 1, x, left, down + 1, visited);
            visited[y + 1][x] = false;
        }
        if (x - 1 >= 0 && !visited[y][x - 1] && arr[y][x - 1] == '.') {
            System.out.println((y) + "," + (x - 1) + "로 왼쪽이동");
            visited[y][x - 1] = true;
            dfs(y, x - 1, left + 1, down, visited);
            visited[y][x - 1] = false;
        }
        if (x + 1 < n && !visited[y][x + 1] && arr[y][x + 1] == '.') {
            System.out.println((y) + "," + (x + 1) + "로 오른 쪽이동");
            visited[y][x + 1] = true;
            dfs(y, x + 1, left + 1, down, visited);
            visited[y][x + 1] = false;
        }


    }
}