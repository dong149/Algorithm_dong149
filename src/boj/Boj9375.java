package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Boj9375 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while(T-->0){
            Map<String,Integer> map = new HashMap<>();
            int n = Integer.parseInt(sc.nextLine());
            if(n==0){
                System.out.println(0);
                continue;
            }
            for(int i=0;i<n;i++){
                String[] input = sc.nextLine().split(" ");
                if(map.containsKey(input[1])){
                    map.put(input[1],map.get(input[1])+1);
                }else{
                    map.put(input[1],1);
                }
            }
            int ans=1;
            for(String cur:map.keySet()){
                ans *= (map.get(cur)+1);
            }
            System.out.println(ans-1);



        }
    }
}
