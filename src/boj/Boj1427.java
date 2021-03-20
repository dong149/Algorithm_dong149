package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Character> arr = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            arr.add(str.charAt(i));
        }

        Collections.sort(arr);
        Collections.reverse(arr);


        StringBuilder sb = new StringBuilder(arr.size());
        for(char temp:arr){
            sb.append(temp);
        }

        String res = sb.toString();
        System.out.println(res);

    }


}
