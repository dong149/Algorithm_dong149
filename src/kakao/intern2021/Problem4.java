package kakao.intern2021;

import java.util.ArrayList;

public class Problem4 {
    public static void main(String[] args) {

        int n = 3;
        int start = 1;
        int end = 3;

        int[][] roads = {{1, 2, 2}, {3, 2, 3}};
        int[] traps = {2};
        int ans = solution(n, start, end, roads, traps);
        System.out.println(ans);
    }


    static ArrayList<ArrayList<Edge>> modeTwo = new ArrayList<>();
    static boolean[] isTrap;
    static int min = 987654321;
    static int endNode;
    static int len;

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        endNode = end;
        len = n;
        ArrayList<ArrayList<Edge>> modeOne = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            modeOne.add(new ArrayList<>());
        }
        isTrap = new boolean[n + 1];

        // 값을 저장한다. 두개에
        for (int i = 0; i < roads.length; i++) {
            modeOne.get(roads[i][0]).add(new Edge(roads[i][1], roads[i][2]));
        }
        for (int i = 0; i < traps.length; i++) {
            isTrap[traps[i]] = true;
        }
        boolean[][] visited = new boolean[n + 1][n + 1];
        dfs(start, 0,isTrap,visited,modeOne);
        answer = min;


        return answer;
    }

    // mode : false -> one true -> two
    public static void dfs(int cur, int sum, boolean[] isTrap, boolean[][] visited, ArrayList<ArrayList<Edge>> modeOne) {
        System.out.println(cur);
        if (cur == endNode) {
            min = Math.min(min, sum);
            return;
        }

        if (isTrap[cur]) {
            ArrayList<ArrayList<Edge>> temp = new ArrayList<>();
            for (int i = 0; i < len + 1; i++) {
                temp.add(new ArrayList<>());
            }
            for (int i = 0; i < modeOne.size(); i++) {
                for (int j = 0; j < modeOne.get(i).size(); j++) {
                    if (j == cur) {
                        temp.get(modeOne.get(i).get(j).end).add(new Edge(cur, modeOne.get(i).get(j).val));
                    } else if (modeOne.get(i).get(j).end == cur) {
                        temp.get(cur).add(new Edge(j, modeOne.get(i).get(j).val));
                    }
                }
            }
            for (int i = 0; i < len + 1; i++) {
                modeOne.get(i).addAll(temp.get(i));
            }

        }

        for (Edge edge : modeOne.get(cur)) {
            int end = edge.end;
            int val = edge.val;
            if (!visited[cur][end]) {
                visited[cur][end] = true;
                dfs(end, sum + val, isTrap, visited, modeOne);
                visited[cur][end] = false;
            }
        }

    }


    public static class Edge {
        int end;
        int val;

        public Edge(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }
}
