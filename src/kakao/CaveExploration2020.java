package kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CaveExploration2020 {
    public static void main(String[] args) {
        int n = 9;
        int[][] path = {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}};
        int[][] order = {{8, 5}, {6, 7}, {4, 1}};
        boolean result = true;

        System.out.println(solution(n, path, order));

    }

    private static ArrayList<ArrayList<Integer>> pathArr;
    private static int[] orderArr;
    private static int[] queueAddArr;
    private static boolean[] visited;

    public static boolean solution(int n, int[][] path, int[][] order) {

        boolean answer;
        pathArr = new ArrayList<ArrayList<Integer>>();
        orderArr = new int[n];
        queueAddArr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            pathArr.add(new ArrayList<Integer>());
        }
        // 통로를 저장해줍니다.
        for (int[] temp : path) {
            pathArr.get(temp[0]).add(temp[1]);
            pathArr.get(temp[1]).add(temp[0]);
        }

        //우선순위를 저장해줍니다.
        for (int[] temp : order) {
            orderArr[temp[1]] = temp[0];
            /*queueAddArr[temp[0]] = temp[1];*/
        }

        if (orderArr[0] != 0) {
            return false;
        }
        answer = bfs();
        return answer;
    }

    private static boolean bfs() {

        Queue<Integer> q = new LinkedList<>();

        // 시작점은 0입니다.
        visited[0] = true;
        for (int i : pathArr.get(0)) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (visited[cur]) {
                continue;
            }
            if (!visited[orderArr[cur]]) {
                queueAddArr[orderArr[cur]] = cur;
                continue;
            }
            visited[cur] = true;
            for (int i = 0; i < pathArr.get(cur).size(); i++) {
                int next = pathArr.get(cur).get(i);
                q.add(next);
            }
//            q.add(queueAddArr[cur]);

            q.add(queueAddArr[cur]);


        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }
}
