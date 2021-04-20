package kakao.blind2020;

public class Problem7 {
    public static void main(String[] args) {

    }


    static int n;
    static int[] da = {0,0,1,-1};
    static int[] db = {1,-1,0,0};
    public int solution(int[][] board) {
        n = board.length;
        int answer = 0;
        return answer;
    }


    public static void dfs(int[][] board,int time,int a1,int b1,int a2,int b2){


        int na1,nb1,na2,nb2;
        for(int i=0;i<4;i++){
            na1 = a1+da[i];
            nb1 = b1+db[i];
            na2 = a2+da[i];
            nb2 = b2+db[i];
            if(isValid(na1,nb1,board)&&isValid(na2,nb2,board)){
                dfs(board,time+1,na1,nb1,na2,nb2);
            }
        }

    }

    public static boolean isValid(int a,int b,int[][] board){
        if(a>=0&&a<n&&b>=0&&b<n&&board[a][b]!=1){
            return true;
        }
        return false;
    }
}
