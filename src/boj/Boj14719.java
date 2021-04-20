package boj;

import java.util.Scanner;

public class Boj14719 {

    static int n,m;
    static boolean[][] map;
    static int[] bar;
    static int ans=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new boolean[n][m];
        bar = new int[m];
        for(int i=0;i<m;i++){
            bar[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>=n-bar[j]){
                    map[i][j] = true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!map[i][j]){
                    if(check(i,j)){
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);




    }
    public static boolean check(int x,int y){
        boolean[] isWall = new boolean[2];
        for(int i=y;i>=0;i--){
            if(map[x][i]){
                isWall[0] = true;
                break;
            }
        }
        for(int i=y;i<m;i++){
            if(map[x][i]){
                isWall[1] = true;
                break;
            }
        }
        if(isWall[0]&&isWall[1])
            return true;
        return false;
    }
}
