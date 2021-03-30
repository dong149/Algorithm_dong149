package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(br.readLine());
        int n = 0;
        for(int i=0;i<m;i++){
            String[] temp = br.readLine().split(" ");
            String oper = temp[0];
            int val=0;
            if(temp.length>1){
                val = Integer.parseInt(temp[1]);
            }
            switch (oper){
                case "add":{
                    n |= 1<<(val-1);
                    break;
                }
                case "remove":{
                    n &= ~(1<<(val-1));
                    break;
                }
                case "check":{
                    if((n&(1<<(val-1)))>0){
                        sb.append("1\n");
                    }else
                        sb.append("0\n");
                    break;
                }
                case "toggle":{
                    n ^=(1 <<(val-1));
                    break;
                }
                case "all":{
                    n |= (~0);
                    break;
                }
                case "empty":{
                    n &= 0;
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
