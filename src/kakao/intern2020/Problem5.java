package kakao.intern2020;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Pattern;

public class Problem5 {
    public static void main(String[] args) {

        int[][] path={{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order={{4,1},{8,7},{6,5}};

        int[][] path2={{0,1},{1,2},{0,3},{3,4}};
        int[][] order2 ={{2,3},{3,4}};
        if(solution(5,path2,order2)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
//        solution(9,path,order);
    }

    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> pathOrder = new ArrayList<>();

    public static boolean solution(int n, int[][] path, int[][] order) {

        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
            pathOrder.add(new ArrayList<>());
        }

        for (int i = 0; i < path.length; i++) {
            map.get(path[i][0]).add(path[i][1]);
            map.get(path[i][1]).add(path[i][0]);
        }

        boolean[] visited = new boolean[n];
        int[] possible = new int[n];
        for (int i = 0; i < order.length; i++) {
            pathOrder.get(order[i][0]).add(order[i][1]);
//            cantOrder.get(order[i][1]).add(order[i][0]);
            possible[order[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        if(possible[0]>0){
            return false;
        }
        q.add(0);
        visited[0] = true;

        boolean answer = true;
        ArrayList<Integer> wait = new ArrayList<>();
        while (!q.isEmpty()) {

            int cur = q.poll();
            for (int i = 0; i < map.get(cur).size(); i++) {
                int next = map.get(cur).get(i);
                if (!visited[next] && possible[next] == 0) {
                    visited[next] = true;
                    q.add(next);
                }
            }
            if(pathOrder.get(cur).size()>0)
                wait.add(pathOrder.get(cur).get(0));
//                wait.add(pathOrder.get(next).get(0));
//            for (int i = 0; i < wait.size(); i++) {
//                visited[wait.get(i)] = true;
//                q.add(wait.get(i));
//            }
            if(q.isEmpty()){
                if(wait.size()==0){
                    break;
                }else{
                    for(int i=0;i<wait.size();i++){
                        if(!visited[wait.get(i)]) {
                            visited[wait.get(i)] = true;
                            q.add(wait.get(i));
                        }
                    }
                    wait = new ArrayList<>();
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }


}
