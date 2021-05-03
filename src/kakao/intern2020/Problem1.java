package kakao.intern2020;

public class Problem1 {

    public static void main(String[] args) {

    }

    static int[][] pos = {{4, 2}, {1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 2}, {2, 3}, {3, 1}, {3, 2}, {3, 3}, {4, 1}, {4, 3}};

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int lPos = 10;
        int rPos = 11;
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            if (cur == 1 || cur == 4 || cur == 7) {
                lPos = cur;
                sb.append("L");
            } else if (cur == 3 || cur == 6 || cur == 9) {
                rPos = cur;
                sb.append("R");
            } else {
                int left = getDistance(lPos, cur);
                int right = getDistance(rPos, cur);
                if (left < right) {
                    lPos = cur;
                    sb.append("L");
                } else if (left == right) {
                    if (hand.equals("right")) {
                        rPos = cur;
                        sb.append("R");
                    } else {
                        lPos = cur;
                        sb.append("L");
                    }
                } else {
                    rPos = cur;
                    sb.append("R");
                }
            }


        }
        return sb.toString();
    }

    public static int getDistance(int cur, int next) {
        int nX = pos[next][0];
        int nY = pos[next][1];
        return Math.abs(pos[cur][0] - nX) + Math.abs(pos[cur][1] - nY);
    }
}
