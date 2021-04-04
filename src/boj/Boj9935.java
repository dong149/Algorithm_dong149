package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char[] str = sc.nextLine().toCharArray();
        char[] pattern = sc.nextLine().toCharArray();
        ArrayList<Character> ans = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            char temp = str[i];
            boolean check = true;
            ans.add(temp);
            if (ans.size() >= pattern.length) {
                if (temp == pattern[pattern.length - 1]) {
                    for(int j=0;j<pattern.length;j++){
                        if(ans.get(ans.size()-1-j)!=pattern[pattern.length-1-j]){
                            check=false;
                            break;
                        }
                    }
                    if (check) {
                        for (int j = 0; j < pattern.length; j++) {
                            ans.remove(ans.size()-1);
                        }
                    }
                }
            }
        }
        if(ans.size()==0){
            System.out.println("FRULA");
            return;
        }
        for(int i=0;i<ans.size();i++){
            sb.append(ans.get(i));
        }
        System.out.println(sb);
    }
}
