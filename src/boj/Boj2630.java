package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630 {
    static int n;
    static int[][] arr;
    static int w = 0;
    static int b = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            String temp = br.readLine();
            StringTokenizer st = new StringTokenizer(temp," ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(n,0,0);
        System.out.println(w);
        System.out.println(b);
    }

    public static void solve(int size,int y,int x){
        int temp = arr[y][x];
        boolean isFinised = true;
        start : for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(arr[i][j] != temp){
                    isFinised = false;
                    break start;
                }
            }
        }

        if(isFinised){
            if(temp==0) {
//                System.out.println("white");
//                System.out.println("y,x:"+y+" "+x);
                w++;
            }
            else {
//                System.out.println("black");
//                System.out.println("y,x:"+y+" "+x);
                b++;
            }
        }
        else{
            solve(size/2,y,x);
            solve(size/2,y+(size/2),x);
            solve(size/2,y,x+(size/2));
            solve(size/2,y+(size/2),x+(size/2));
        }
    }



}
