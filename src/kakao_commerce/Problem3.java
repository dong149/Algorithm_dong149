package kakao_commerce;
import java.util.*;
public class Problem3 {
    public static void main(String[] args) {
        //test =
        //solution(test);
    }

    static boolean[][] map;

    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n-1;i++){
            map[train[i][0]-1][train[i][1]-1] = true;
            map[train[i][1]-1][train[i][0]-1] = true;
        }
        dist[0] = passenger[0];
        bfs(n,dist,passenger,visited);
        int res=0;
        int idx=0;
        for(int i=0;i<dist.length;i++){
            if(res<dist[i]){
                idx=i+1;
                res=dist[i];
            }
        }
        answer[0] = idx;
        answer[1] = res;
        return answer;
    }


    public static void bfs(int n,int[] dist,int[] passenger,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);


        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int i=0;i<n;i++){
                if(map[cur][i]){
                    dist[i] = Math.max(dist[cur]+passenger[i],dist[i]);
                    if(!visited[i])
                        q.add(i);
                }
            }
        }
    }



}
