package boj;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Boj1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String search = sc.nextLine();

        Pattern p = Pattern.compile(search);
        Matcher ma = p.matcher(input);
        int len = search.length();
        int bef=-1;
        int cnt=0;
        while(ma.find()){
            int cur = ma.start();
            if(bef==-1){
                bef = cur;
                cnt++;
            }else{
                if(cur-bef<len){
                    continue;
                }else{
                    bef=cur;
                    cnt++;
                }
            }


        }
        System.out.println(cnt);

    }

}
