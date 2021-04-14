package kakao;

public class LockAndKey2020 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        int[][] lock = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        if (solution(key, lock))
            System.out.println(true);
        else
            System.out.println(false);
    }

    static int lockCnt = 0;

    public static boolean solution(int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0)
                    lockCnt++;
            }
        }

        int aLen = key.length;
        for (int i = -aLen + 1; i < aLen; i++) {
            for (int j = -aLen + 1; j < aLen; j++) {
                int[][] temp = move(key, i, j);
                for (int k = 0; k < 4; k++) {
                    int[][] res = turn(temp, k);
                    if (check(res, lock)) {
                        return true;
                    }
                }
            }
        }
        return false;


    }

    public static int[][] move(int[][] key, int x, int y) {
        int[][] res = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                int nX = i + x;
                int nY = j + y;
                if (nX >= 0 && nX < key.length && nY >= 0 && nY < key.length) {
                    res[nX][nY] = key[i][j];
                }
            }
        }
        return res;
    }

    // 회전
    public static int[][] turn(int[][] key, int turn) {
        int[][] res = new int[key.length][key.length];
        if (turn == 0) {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    res[i][j] = key[i][j];
                }
            }
        } else if (turn == 1) {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    res[i][j] = key[j][key.length - i - 1];
                }
            }

        } else if (turn == 2) {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    res[i][j] = key[key.length - i - 1][key.length - j - 1];
                }
            }
        } else if (turn == 3) {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    res[i][j] = key[key.length - j - 1][i];
                }
            }
        }
        return res;
    }

    // 두 배열을 비교해서 같은지 리턴합니다.
    public static boolean check(int[][] key, int[][] lock) {
        for (int i = 0; i <= lock.length - key.length; i++) {
            for (int j = 0; j <= lock.length - key.length; j++) {
                boolean isCorrect = true;
                int cnt = 0;
                for (int k = 0; k < key.length; k++) {
                    for (int l = 0; l < key.length; l++) {
                        if (key[k][l] == 1) {
                            cnt++;
                        }
                        if (key[k][l] == lock[k + i][l + j]) {
                            isCorrect = false;
                        }
                    }
                }
                if (isCorrect && cnt == lockCnt)
                    return true;
            }
        }
        return false;
    }

    public static void printAll(int[][] key) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                System.out.print(key[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
