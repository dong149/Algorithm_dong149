package a;

import java.util.*;

public class Test {
    public static void main(String[] args) {


        return;
    }
}
//
//    // 상 우 하 좌 0,1,2,3
//    static int[] dx = {0, 1, 0, -1};
//    static int[] dy = {1, 0, -1, 0};
//    static int answer = Integer.MAX_VALUE;
//    static int[][] cache;
//
//    static int len;
//
//    public static int solution(int[][] board) {
//        len = board.length;
//        cache = new int[len][len];
//        for(int i=0;i<len;i++){
//            Arrays.fill(cache,Integer.MAX_VALUE);
//        }
//
//        for (int i = 1; i <= 2; i++) {
//            boolean[][] visited = new boolean[len][len];
//            visited[0][0] = true;
//            dfs(0, 0, board, visited, 0, i);
//        }
//        return answer;
//
//
//    }
//
//    public static void dfs(int x, int y, int[][] board, boolean[][] visited, int cost, int dir) {
//        if(cache[x][y]<cost){
//            return;
//        }else{
//            cache[x][y] = cost;
//        }
//        if (x == len - 1 && y == len - 1) {
//            answer = Math.min(answer, cost);
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int nX = x + dx[i];
//            int nY = y + dy[i];
//            if (nX >= 0 && nX < len && nY >= 0 && nY < len && board[nX][nY] != 1 && !visited[nX][nY]) {
//                visited[nX][nY] = true;
//
//                // same dir
//                if (dir % 2 == i % 2) {
//                    dfs(nX, nY, board, visited, cost + 100, i);
//                } else {
//                    dfs(nX, nY, board, visited, cost + 600, i);
//                }
//                // diff dir
//                visited[nX][nY] = false;
//            }
//
//        }
//
//
//    }

//    public void bfs(int dir,int[][] board){
//        int len = board.length;
//        Queue<Point> q = new LinkedList<>();
//        q.add(new Point(0,0,dir,0));
//
//        boolean[][] visited = new boolean[len][len];
//        visited[0][0] = true;
//        while(!q.isEmpty()){
//            Point cur = q.poll();
//            if(cur.x==len-1&&cur.y==len-1){
//                answer = Math.min(answer,cur.val);
//            }
//
//            for(int i=0;i<4;i++){
//                int nX = cur.x+dx[i];
//                int nY = cur.y+dy[i];
//
//                if(nX>=0&&nX<len&&nY>=0&&nY<len&&board[nX][nY]!=1&&!vis)
//
//            }
//
//
//        }
//
//
//
//    }
//
//import java.util.*;
//    class Solution {
//
//
//        static Map<String,Integer>[] combination = new Map[11];
//        public static String[] solution(String[] orders, int[] course) {
//
//
//            boolean[] isCourseCnt = new boolean[11];
//            for(int i=0;i<combination.length;i++){
//                combination[i] = new HashMap<>();
//            }
//            for(int i=0;i<course.length;i++){
//                isCourseCnt[course[i]]= true;
//            }
//            for(int i=0;i<orders.length;i++){
//                char[] order = orders[i].toCharArray();
//                Arrays.sort(order);
//                dfs(isCourseCnt,order,"",0);
//            }
//            List<String> ansList = new ArrayList<>();
//            for(int i=0;i<course.length;i++){
//                int idx = course[i];
//                if(combination[idx].isEmpty()){
//                    continue;
//                }
//                List<String> keySetList = new ArrayList<>(combination[idx].keySet());
//                Collections.sort(keySetList,(o1, o2) -> combination[idx].get(o2).compareTo(combination[idx].get(o1)));
//                int max = combination[idx].get(keySetList.get(0));
////            System.out.println(max);
//                if(max<2)
//                    continue;
//                for(int j=0;j<keySetList.size();j++){
//                    if(combination[idx].get(keySetList.get(j))<max){
//                        break;
//                    }else{
////                    System.out.println(keySetList.get(j));
//                        ansList.add(keySetList.get(j));
//                    }
//                }
//            }
//
//            Collections.sort(ansList);
//            String[] answer = new String[ansList.size()];
//            ansList.toArray(answer);
//            return answer;
//        }
//
//
//        public static void dfs(boolean[] isCourseCnt,char[] order,String temp,int idx){
////        System.out.println(temp);
//            if(isCourseCnt[temp.length()]){
//                if(combination[temp.length()].containsKey(temp)){
//                    combination[temp.length()].put(temp,combination[temp.length()].get(temp)+1);
//                }else{
//                    combination[temp.length()].put(temp,1);
//                }
//            }
//            for(int i=idx;i<order.length;i++){
//                dfs(isCourseCnt,order,temp+order[i],i+1);
//            }
//
//            StringBuilder sb = new StringBuilder();
//
//
//
//        }
//    }