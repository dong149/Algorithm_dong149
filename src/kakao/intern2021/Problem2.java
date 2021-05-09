package kakao.intern2021;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public static void main(String[] args) {

    }


    // 각 상황을 char 배열로 정리하자.


    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i=0;i<5;i++){
            char[][] map = new char[5][5];
            for(int j=0;j<5;j++){
                map[j] = places[i][j].toCharArray();
//                for(int k=0;k<5;k++){
//                    map[k] = places[i][j].toCharArray();
//                }
            }

//            printMap(map);
            if(check(map)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }



        return answer;
    }
    public static boolean check(char[][] map){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(map[i][j]=='P'){
                    if(!bfs(map,i,j)){
                        return false;
                    }
                }

            }
        }
        return true;
    }
    public static boolean bfs(char[][] map,int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
//            System.out.println("x : "+x+" y : "+y+" cur[0] : "+cur[0]+" cur[1] : " + cur[1]+ " map[i][j] :"+map[cur[0]][cur[1]]);
            if(getMan(x,y,cur[0],cur[1])>2){
                continue;
            }
            if(map[cur[0]][cur[1]]=='P'){
                int man = getMan(x,y,cur[0],cur[1]);
                if(man<=2&&man>0){
//                    System.out.println("FALSE x : "+x+" y : "+y+" cur[0] : "+cur[0]+" cur[1] : " + cur[1]);
                    return false;
                }else{
//                    System.out.println("TRUE x : "+x+" y : "+y+" cur[0] : "+cur[0]+" cur[1] : " + cur[1]);
                }
            }
            for(int i=0;i<4;i++){
                int nX = cur[0]+dx[i];
                int nY = cur[1]+dy[i];
                if((nX>=0&&nX<5&&nY>=0&&nY<5)&&!visited[nX][nY]&&(map[nX][nY]=='O'||map[nX][nY]=='P')){
                    visited[nX][nY] = true;
                    q.add(new int[]{nX,nY});
                }
            }




        }
        return true;
    }

    public static int getMan(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    public static void printMap(char[][] map){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
