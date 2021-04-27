package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj1159 {

    static Map<Character,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String temp = sc.nextLine();
            if(map.containsKey(temp.charAt(0))){
                map.put(temp.charAt(0),map.get(temp.charAt(0))+1);
            }else{
                map.put(temp.charAt(0),1);
            }
        }


        boolean check=false;
        for(char c:map.keySet()){
            if(map.get(c)>=5){
                System.out.print(c);
                check=true;
            }
        }
        if(!check){
            System.out.println("PREDAJA");
        }else{
            System.out.println();
        }
    }
}
