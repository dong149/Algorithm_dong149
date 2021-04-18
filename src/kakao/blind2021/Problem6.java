package kakao.blind2021;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static void main(String[] args) {

    }

    static List<List<Node>> map = new ArrayList<>();
    static int moveMin = Integer.MAX_VALUE;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static int solution(int[][] board, int r, int c) {
        int answer = 0;
        boolean[] isAvail = new boolean[7];
        int cnt =0;
        for(int i=0;i<7;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j]!=0){
                    isAvail[board[i][j]] = true;
                    map.get(board[i][j]).add(new Node(i,j));
                }
            }
        }
        for(int i=1;i<=6;i++){
            if(isAvail[i]){
                cnt++;
            }
        }
        // 각각의 위치






        return answer;
    }
    public static int move(int[][] board ,boolean[][] visited,int a1,int b1,int a2,int b2,int cnt){
        if(a1==a2&&b1==b2){
                moveMin = Math.min(moveMin,cnt);
        }

        for(int i=0;i<4;i++){
            int nA = a1+dx[i];
            int nB = b1+dy[i];
            if(nA>=0&&nA<4&&nB>=0&&nB<4&&!visited[nA][nB]){
                visited[nA][nB] = true;
                move(board,visited,nA,nB,a2,b2,cnt+1);
                visited[nA][nB] = false;
            }
        }
        for(int i=1;i<4;i++){
            int nA = a1+i;
            int nB = b1;
            if(nA>=0&&nA<4&&nB>=0&&nB<4&&!visited[nA][nB]){
        }





    }
//    public static
    public static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
