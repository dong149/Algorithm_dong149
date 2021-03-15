package Programmers.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HIndex {
    public static void main(String[] args) {
        int[] test = {12, 11, 10, 9, 8, 1};
        int res = solution(test);
        System.out.println("res: "+res);
    }

    private static List<Integer> list = new ArrayList<>();
    public static int solution(int[] citations) {
        int answer = 0;

        for(int temp: citations){
            list.add(temp);
        }

        Collections.sort(list);


        int cnt=0;
        for(int i=list.size()-1;i>=0;i--){
            cnt++;

            int low=0;
            int high=0;
            for(int j=0;j<list.size();j++) {
                if(list.get(j)<cnt)
                    low++;
                if(list.get(j)>=cnt)
                    high++;
            }
            if(low<=cnt&&high>=cnt){
                answer = Math.max(answer,cnt);
            }
        }
        return answer;


    }
}
