package boj;

import java.util.Scanner;

public class Boj1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] alpha = new int['Z' - 'A' + 1];
        int len = input.length();
        for (int i = 0; i < input.length(); i++) {
            alpha[input.charAt(i) - 'A']++;
        }
        int cnt = 0;
        int idx=0;
        for (int i = 0; i < 'Z' - 'A' + 1; i++) {
            if (len % 2 == 0 && alpha[i] % 2 == 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
            if (alpha[i] % 2 == 1) {
                idx = i;
                cnt++;
            }
        }
        if (cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        if (len%2==0){
            String res="";
            for(int i='Z'-'A';i>=0;i--) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    String temp = String.valueOf((char)('A'+i));
                    res = temp + res + temp ;
                }
            }
            System.out.println(res);
        }else{
            String res=String.valueOf((char)('A'+idx));
            alpha[idx]--;
            for(int i='Z'-'A';i>=0;i--) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    String temp = String.valueOf((char)('A'+i));
                    res = temp + res + temp ;
                }
            }
            System.out.println(res);
        }

    }
//
//    public void dfs(StringBuilder sb,int n){
//
//    }
}
