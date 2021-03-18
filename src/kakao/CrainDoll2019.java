package kakao;

//public class CrainDoll2019 {
//}



import java.util.ArrayList;
import java.util.List;

/**
 * board에 있는 것 중에 가장 위의 것을 0으로 하고, 하나의 배열에 저장한다.
 **/


class CrainDoll2019 {
    List<Integer> arr = new ArrayList<>();

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        for (int num : moves) {
            for (int i = 0; i < board.length; i++) {
                // 0이 되면, 그 이전값이 최대 값이다.
                if (board[i][num - 1] != 0) {
                    arr.add(board[i][num - 1]);
                    board[i][num - 1] = 0;
                    if (arr.size() >= 2) {
                        if (arr.get(arr.size() - 2).equals(arr.get(arr.size() - 1))) {
                            answer += 2;
                            arr.remove(arr.size() - 2);
                            arr.remove(arr.size() - 1);
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}