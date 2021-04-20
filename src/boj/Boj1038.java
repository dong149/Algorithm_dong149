package boj;

import java.util.*;

public class Boj1038 {
    static int n;

    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<10;i++){
            map.put(String.valueOf(i),1);
        }

        if(n<10){
            System.out.println(n);
            return;
        }
        int cnt=9;
        long i=10;
        while(true){
            String cur = String.valueOf(i);
//            System.out.println(cur.substring(1,cur.length()));
            if(!map.containsKey(cur.substring(1,cur.length()))){
                i++;
                continue;
            }
            if(cur.charAt(0)>cur.charAt(1)){
//                System.out.println(cur);
                  map.put(cur,1);
                    cnt++;

            }
            if(cnt==n){
                System.out.println(i);
                return;
            }
            i++;
        }




    }
}

