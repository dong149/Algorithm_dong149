package programmers.dp;

public class BackRoad {
    static final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        boolean[][] puddleMap = new boolean[n][m];
        int[][] map = new int[n][m];
        for (int[] temp : puddles) {
            puddleMap[temp[1]-1][temp[0]-1] = true;
        }

        map[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (puddleMap[i][j])
                    continue;
                if (i > 0 && !puddleMap[i - 1][j]) {
                    map[i][j] += map[i - 1][j] % MOD;
                }
                if (j > 0 && !puddleMap[i][j - 1]) {

                    map[i][j] += map[i][j - 1] % MOD;
                }
            }
        }

        return map[n - 1][m - 1]%MOD;
    }


}
