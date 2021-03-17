package Programmers.DFSBFS;


public class TravelWays {

    private boolean[] visited;
    private String pathStr;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        String[] answer = new String[pathStr.length() / 3];
        for (int i = 0; i < pathStr.length() / 3; i++) {
            answer[i] = pathStr.substring(i * 3, (i + 1) * 3);
        }
        return answer;
    }

    private void dfs(String[][] tickets, String path, String cur, int cnt) {

        if (cnt == visited.length) {
            if (pathStr == null) {
                pathStr = path;
            } else {
                if (pathStr.compareTo(path) > 0) {
                    pathStr = path;
                }
            }
        }

        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String target = tickets[i][1];
            if (!visited[i] && start.equals(cur)) {
                visited[i] = true;
                dfs(tickets, path + target, target, cnt + 1);
                visited[i] = false;
            }
        }


    }


}
