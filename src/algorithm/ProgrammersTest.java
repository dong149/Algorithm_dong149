package algorithm;

import java.util.*;

public class ProgrammersTest {


    /*
    프렌즈 4블록
    4개 -> 사라지면서 점수를 얻음
    */

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        solution(m,n,board);

    }
    static char[][] map;

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        while (true) {
            int cnt = removeBlock(m, n);
            if (cnt == 0) {
                break;
            }
            answer += cnt;

        }

        return answer;

    }

    public static int removeBlock(int m, int n) {
        boolean[][] removeCheck = new boolean[m][n];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char cur = map[i][j];
                if (cur != ' ' && map[i][j + 1] == cur && map[i + 1][j] == cur && map[i + 1][j + 1] == cur) {
                    removeCheck[i][j] = true;
                    removeCheck[i + 1][j] = true;
                    removeCheck[i][j + 1] = true;
                    removeCheck[i + 1][j + 1] = true;
                }

            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (removeCheck[i][j]) {
                    cnt++;
                    map[i][j] = ' ';
                }
            }
        }
        moveDown(m, n);
        return cnt;

    }

    public static void moveDown(int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] == ' ') {
                    int k;
                    for (k = i; k >= 0; k--) {
                        if (map[k][j] != ' ') {
                            break;
                        }
                    }
                    System.out.println(k);
                    printAll(m,n);
                    map[i][j] = map[k][j];
                    map[k][j] = ' ';
                }

            }
        }


    }
    public static void printAll(int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


}
