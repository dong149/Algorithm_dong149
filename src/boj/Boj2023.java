package boj;

import java.util.Scanner;

public class Boj2023 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs("2");
        dfs("3");
        dfs("5");
        dfs("7");
        System.out.print(sb);

    }


    public static void dfs(String s){
        if(s.length()==n){
            sb.append(s).append('\n');
            return;
        }
        for(int i=0;i<=9;i++){
            int temp = Integer.parseInt(s);
            temp = temp*10+i;
            if(isPrime(temp)){
                dfs(String.valueOf(temp));
            }
        }
    }
    public static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;



    }

}
