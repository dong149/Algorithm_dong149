package boj;

import java.util.Scanner;


// 못풀었음. 다시 풀자. ( 아래 코드 틀린 코드임 )
public class Boj2580 {

    static int zeroCnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 0)
                    zeroCnt++;
            }
        }


        while(zeroCnt>0){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++) {
                    if(arr[i][j]==0) {
                        int temp=0;
                        temp = checkRow(arr, i, j);
                        if(temp==0){
                            temp = checkCol(arr,i,j);
                            if(temp==0){
                                temp = checkRec(arr, i, j);
                            }
                        }
                        if (temp> 0) {
                            arr[i][j] = temp;
                            zeroCnt--;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

    private static int checkRec(int[][] arr,int y,int x) {
        boolean[] nineCheck = new boolean[9];
        int cnt=0;
        int temp=0;
        for(int i=(y/3)*3;i<(y/3)*3+3;i++){
            for(int j=(x/3)*3;j<(x/3)*3+3;j++){
                if(arr[i][j]==0){
                    cnt++;
                    continue;
                }
                nineCheck[arr[i][j]-1] = true;
            }
        }

        if(cnt==1){
            for(int i=0;i<9;i++){
                if(!nineCheck[i]){
                    return i+1;
                }
            }
        }

        return 0;

    }
    private static int checkRow(int[][] arr,int y,int x) {
        boolean[] nineCheck = new boolean[9];
        int cnt=0;
        int temp=0;
        for(int i=0;i<9;i++){
            if(arr[y][i]==0){
                cnt++;
                continue;
            }
            nineCheck[arr[y][i]-1] = true;
        }

        if(cnt==1){
            for(int i=0;i<9;i++){
                if(!nineCheck[i]){
                    return i+1;
                }
            }
        }
        return 0;

    }
    private static int checkCol(int[][] arr,int y,int x) {
        boolean[] nineCheck = new boolean[9];
        int cnt=0;
        int temp=0;
        for(int i=0;i<9;i++){
            if(arr[i][x]==0){
                cnt++;
                continue;
            }
            nineCheck[arr[i][x]-1] = true;
        }

        if(cnt==1){
            for(int i=0;i<9;i++){
                if(!nineCheck[i]){
                    return i+1;
                }
            }
        }
        return 0;
    }

}
