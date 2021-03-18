package programmers.dfs_bfs;

public class TargetNumber {
    int cnt = 0;

    public int solution(int[] numbers, int target) {

        int answer = 0;
        boolean[] visited = new boolean[numbers.length];

        dfs(numbers,0,numbers[0],target);
        dfs(numbers,0,-numbers[0],target);
        answer = cnt;
        return answer;
    }


    private void dfs(int[] numbers, int idx, int n, int target) {


        if (idx == numbers.length-1 && n == target) {
            cnt++;
            return;
        }
        if(idx == numbers.length-1)
            return;
        dfs(numbers,idx+1,n+numbers[idx+1],target);
        dfs(numbers,idx+1,n-numbers[idx+1],target);
    }


}
