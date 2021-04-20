package boj;

import java.util.Scanner;

public class Boj3085 {
    static int n;
    static char[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int res =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        map = new char[n][n];
        for(int i=0;i<n;i++){
            map[i] = sc.nextLine().toCharArray();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                solve(i,j);
            }
        }

        System.out.println(res);


    }
    public static void solve(int x,int y){
        int nX,nY;
        for(int i=0;i<4;i++){
            nX = x+dx[i];
            nY = y+dy[i];
            if(nX>=0&&nX<n&&nY>=0&&nY<n&&map[x][y]!=map[nX][nY]){
                char cur = map[x][y];
                char next = map[nX][nY];
                map[x][y] = next;
                map[nX][nY] = cur;
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        sameCheck(j,k);
                    }
                }
                map[x][y] = cur;
                map[nX][nY] = next;

            }
        }



    }

    public static void sameCheck(int x,int y){
        int cnt=0;
        int next = map[x][y];
        for(int j=x;j<n;j++){
            if(map[j][y]==next){
                cnt++;
            }else{
                break;
            }
        }
        for(int j=x;j>=0;j--){
            if(map[j][y]==next){
                cnt++;
            }else{
                break;
            }
        }
        cnt--;
        res = Math.max(cnt,res);
        cnt=0;
        for(int j=y;j<n;j++){
            if(map[x][j]==next){
                cnt++;
            }else{
                break;
            }
        }
        for(int j=y;j>=0;j--){
            if(map[x][j]==next){
                cnt++;
            }else{
                break;
            }
        }
        cnt--;
        res = Math.max(cnt,res);
    }

}
