package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Boj6581 {
    public static void main(String[] args) throws IOException {
        StringBuilder hr = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> word = new ArrayList<>();
        for(int i=0;i<80;i++){
            hr.append('-');
        }
        hr.append('\n');
        String hrStr = hr.toString();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine().replaceAll("\\s+"," ");
            if(input.equals(" ")) {
                continue;
            }
            String[] temp= input.split(" ");

            for(int i=0;i<temp.length;i++){
                word.add(temp[i]);
            }
        }
        int curLen=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.size();i++){
            String cur = word.get(i);
            if(cur.equals(""))
                continue;
            if(cur.equals("<br>")){
                sb.append('\n');
                curLen=0;
            }else if(cur.equals("<hr>")){
                if(curLen!=0){
                    sb.append('\n');
                }
                sb.append(hr);
                curLen=0;
            }else{
                if(curLen+cur.length()+1>80){
                    sb.append('\n').append(cur);
                    curLen=cur.length();
                }else{
                    if(curLen!=0) {
                        sb.append(' ').append(cur);
                        curLen+=cur.length()+1;
                    }
                    else {
                        sb.append(cur);
                        curLen+=cur.length();
                    }
                }
            }
        }

        System.out.println(sb);



    }
}
