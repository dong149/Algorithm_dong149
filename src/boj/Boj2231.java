package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int res = solve(n);

        System.out.println(res);
    }
    private static int solve(String n){
        int min=Integer.MAX_VALUE;
        int cur= Integer.parseInt(n);
        int scope = 9*n.length();
        for(int i=cur-1;i>=cur-scope;i--){
            if(i<1)
                break;
            int res=0;
            for(int j=0;j<String.valueOf(i).length();j++){
                res += String.valueOf(i).charAt(j)-'0';
            }
            res += i;
            if(res==cur){
                min = Math.min(i,min);
            }
        }

        if(min==Integer.MAX_VALUE)
            return 0;
        else
            return min;

    }


}
