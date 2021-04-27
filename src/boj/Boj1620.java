package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj1620 {

    static Map<String,Integer> strMap = new HashMap<>();
    static Map<Integer,String> numMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n,m;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for(int i=0;i<n;i++){
            String temp = sc.nextLine();
            strMap.put(temp,i+1);
            numMap.put(i+1,temp);
        }
        for(int i=0;i<m;i++){
            String temp = sc.nextLine();
            if(temp.charAt(0)>='0'&&temp.charAt(0)<='9'){
                System.out.println(numMap.get(Integer.parseInt(temp)));
            }else{
                System.out.println(strMap.get(temp));
            }
        }
    }
}
