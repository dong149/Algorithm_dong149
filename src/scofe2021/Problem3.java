package scofe2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    static int n;
    static int[][] arr;
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        n = Integer.parseInt(temp);
        arr = new int[n][n];
        res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            temp = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            arr[n - 1][i] = br.read() - '0';
        }

        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    res[0]++;
                    answer += getPossible(i,j);
                }
            }

        }

        System.out.println("total: "+answer);
        for(int i=0;i<n;i++){
            if(res[i]!=0){
                System.out.println("size["+(i+1)+"]: "+res[i]);
            }
        }

    }

    private static int getPossible(int x, int y) {
        // 1x1은 가능하기에
        int cnt = 1;
        int maxWidth = Math.min(n - 1 - x, n - 1 - y);
        for (int width = 1; width <= maxWidth; width++) {
            boolean isPossible = true;
            SizeCheck:
            for (int i = x; i <= x+width; i++) {
                for (int j = y; j <= y+width; j++) {
                    if (arr[i][j] == 0) {
                        isPossible = false;
                        break SizeCheck;
                    }
                }
            }
            if (isPossible) {
                res[width]++;
                cnt++;
            }
        }
        return cnt;
    }
}
