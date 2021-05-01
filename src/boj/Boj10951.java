package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Boj10951 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> ans = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] input = sc.nextLine().split(" ");
            int temp = Integer.parseInt(input[0])+Integer.parseInt(input[1]);
            ans.add(temp);
//            System.out.println(temp);
//            bw.write(String.valueOf(temp));
//            bw.newLine();
        }
        for(int i:ans){
            System.out.println(i);
        }
        bw.flush();
        bw.close();
        sc.close();

    }
}
