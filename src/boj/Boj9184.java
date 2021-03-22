package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj9184 {

    static int[][][] dp = new int[51][51][51];
    public static void main(String[] args) throws IOException {
        List<String> answer = new ArrayList<>();
        int a,b,c;
        dp[0][0][0] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringBuilder sb = new StringBuilder();
            String input = br.readLine();
            String[] abc = input.split(" ");
            a = Integer.parseInt(abc[0]);
            b = Integer.parseInt(abc[1]);
            c = Integer.parseInt(abc[2]);
            if(a==-1&&b==-1&&c==-1)
                break;
//            sb.append()
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            sb.append(w(a,b,c));
            answer.add(sb.toString());
        }

        for(String temp:answer){
            System.out.println(temp);
        }

    }

    public static int w(int a,int b,int c){
        if(a<=0||b<=0||c<=0)
            return 1;
        if(a>20||b>20||c>20)
            return w(20,20,20);
        if(dp[a][b][c]>0){
            return dp[a][b][c];
        }
        if(a<b&&b<c){
            dp[a][b][c] =  w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
            return dp[a][b][c];
        }
        dp[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return dp[a][b][c];
    }
}
