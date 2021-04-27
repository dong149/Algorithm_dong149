package boj;

import java.util.Scanner;

public class Boj1032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] input =new String[n];
        for(int i=0;i<n;i++){
            input[i] = sc.nextLine();
        }
        if(input.length==1){
            System.out.println(input[0]);
            return;
        }

        String res = input[0];
        for(int i=1;i<input.length;i++){
            String temp="";
            for(int j=0;j<input[0].length();j++){
                if(res.charAt(j)!=input[i].charAt(j)){
                    temp+="?";
                }else{
                    temp+=res.charAt(j);
                }
            }
            res = temp;
        }

        System.out.println(res);

    }
}
