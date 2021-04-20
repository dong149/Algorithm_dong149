package kakao.blind2019;

import java.util.Arrays;

public class Problem7 {
    public static void main(String[] args) {

    }
    static int n,m;
    static boolean[] possibleCol;
    static int res=0;
    public static int solution(int[][] board) {
        int answer = 0;

        n = board.length;
        m = board[0].length;
        possibleCol = new boolean[m];
        Arrays.fill(possibleCol,true);
        while(true) {
            boolean isNotEnd=false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int val = board[i][j];
                    if (board[i][j] != 0) {
                        if(check(i, j, board, val)){
                            isNotEnd=true;
                        }
                    }
                }
            }
            if(!isNotEnd){
                break;
            }
        }


        return res;
    }

    public static boolean check(int x,int y,int[][] board,int val){
        // 1
        if(isValid(x,y+1,val,board)&&isValid(x,y+2,val,board)&&isValid(x+1,y+2,val,board)){
            possibleCol[y]=false;
            possibleCol[y+1]=false;
            possibleCol[y+2]=false;
            return false;
        }
        // 2
        if(isValid(x,y+1,val,board)&&isValid(x+1,y,val,board)&&isValid(x+2,y,val,board)){
            possibleCol[y]=false;
            possibleCol[y+1]=false;
            return false;
        }
        // 3
        if(isValid(x+1,y,val,board)&&isValid(x+1,y+1,val,board)&&isValid(x+1,y+2,val,board)){
            if(possibleCol[y+1]&&possibleCol[y+2]&&isUpValid(x+1,y+1,board)&&isUpValid(x+1,y+2,board)){
                board[x][y] = 0;
                board[x+1][y]=0;
                board[x+1][y+1]=0;
                board[x+1][y+2]=0;
                res++;
                possibleCol[y]=true;
                possibleCol[y+1]=true;
                possibleCol[y+2]=true;
                return true;
            }else{
                possibleCol[y]=false;
                possibleCol[y+1]=false;
                possibleCol[y+2]=false;
            }
            return false;
        }
        //4
        if(isValid(x+1,y,val,board)&&isValid(x+2,y,val,board)&&isValid(x+2,y-1,val,board)){
            if(possibleCol[y-1]&&isUpValid(x+2,y-1,board)){
                board[x][y] = 0;
                board[x+1][y]=0;
                board[x+2][y]=0;
                board[x+2][y-1]=0;
                res++;
                possibleCol[y]=true;
                possibleCol[y-1]=true;
                return true;
            }else{
                possibleCol[y]=false;
                possibleCol[y-1]=false;
            }
            return false;
        }

        // 5
        if(isValid(x,y+1,val,board)&&isValid(x,y+2,val,board)&&isValid(x+1,y,val,board)){
            possibleCol[y]=false;
            possibleCol[y+1]=false;
            possibleCol[y+2]=false;
            return false;
        }

        //6
        if(isValid(x+1,y,val,board)&&isValid(x+2,y,val,board)&&isValid(x+2,y+1,val,board)){
            if(possibleCol[y+1]&&isUpValid(x+2,y+1,board)){
                board[x][y] = 0;
                board[x+1][y]=0;
                board[x+2][y]=0;
                board[x+2][y+1]=0;
                res++;
                possibleCol[y]=true;
                possibleCol[y+1]=true;
                return true;
            }else{
                possibleCol[y]=false;
                possibleCol[y+1]=false;
            }
            return false;
        }

        // 7
        if(isValid(x+1,y,val,board)&&isValid(x+1,y-1,val,board)&&isValid(x+1,y-2,val,board)){
            if(possibleCol[y-1]&&possibleCol[y-2]&&isUpValid(x+1,y-1,board)&&isUpValid(x+1,y-2,board)){
                board[x][y] = 0;
                board[x+1][y]=0;
                board[x+1][y-1]=0;
                board[x+1][y-2]=0;
                res++;
                possibleCol[y]=true;
                possibleCol[y-1]=true;
                possibleCol[y-2]=true;
                return true;
            }else{
                possibleCol[y]=false;
                possibleCol[y-1]=false;
                possibleCol[y-2]=false;
            }
            return false;
        }
        // 8
        if(isValid(x,y+1,val,board)&&isValid(x+1,y+1,val,board)&&isValid(x+2,y+1,val,board)){
            possibleCol[y]=false;
            possibleCol[y+1]=false;
            return false;
        }

        // 9
        if(isValid(x+1,y,val,board)&&isValid(x+1,y-1,val,board)&&isValid(x+1,y+1,val,board)){
            if(possibleCol[y-1]&&possibleCol[y+1]&&isUpValid(x+1,y-1,board)&&isUpValid(x+1,y-1,board)){
                board[x][y] = 0;
                board[x+1][y]=0;
                board[x+1][y+1]=0;
                board[x+1][y-1]=0;
                res++;
                possibleCol[y]=true;
                possibleCol[y-1]=true;
                possibleCol[y+1]=true;
                return true;
            }else{
                possibleCol[y]=false;
                possibleCol[y-1]=false;
                possibleCol[y+1]=false;
            }
            return false;
        }

        // 10
        if(isValid(x+1,y,val,board)&&isValid(x+1,y+1,val,board)&&isValid(x+2,y,val,board)){
            possibleCol[y]=false;
            possibleCol[y+1]=false;
            return false;
        }


        // 11
        if(isValid(x,y+1,val,board)&&isValid(x,y+2,val,board)&&isValid(x+1,y+1,val,board)){
            possibleCol[y]=false;
            possibleCol[y+1]=false;
            possibleCol[y+2]=false;
            return false;
        }


        // 12
        if(isValid(x+1,y,val,board)&&isValid(x+1,y-1,val,board)&&isValid(x+2,y,val,board)){
            possibleCol[y-1]=false;
            possibleCol[y]=false;
            return false;
        }


        return false;

    }

    public static boolean isUpValid(int x,int y,int[][] board){
        for(int i=0;i<x;i++){
            if(board[i][y]!=0){
                return false;
            }
        }
        return true;
    }



    public static boolean isValid(int x,int y,int val,int[][] board){
        if(x>=0&&x<n&&y>=0&&y<m&&board[x][y]==val){
            return true;
        }
        return false;
    }




}
