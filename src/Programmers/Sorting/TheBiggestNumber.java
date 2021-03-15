package Programmers.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 가장 큰 수
 * sorting 문제
 * Comparator 를 정의하는 법에 대해서 공부하였다.
 * 문제를 풀 때, 쉽게 쉽게 생각하려 노력하자. 그렇게 논리가 복잡할리가 없다. 아름답게 풀 수 있는 방법을 고민해보도록 하자.
 * 풀다가, 너무 복잡해서 막막하면 문제를 다르게 접근해볼 필요가 있다.
 **/


public class TheBiggestNumber {
    public static void main(String[] args) {
        int[] test = {0,0,0,0};
        String res = solution(test);
        System.out.println(res);
    }

    // String 배열로 바꾼 후에 정렬을 하자.
    private static List<String> str;

    public static String solution(int[] numbers) {
        str = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            str.add(Integer.toString(numbers[i]));
        }


        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int temp1=0; int temp2=0;
                temp1 = Integer.parseInt(s1+s2);
                temp2 = Integer.parseInt(s2+s1);


                if(temp1>temp2){
                    return -1;
                }else if(temp1==temp2){
                    return 0;
                }
                else return 1;
            }

        });


        String answer = "";
        for(int i=0;i<str.size();i++){
            String temp = str.get(i);
            if(i==0&&'0'==temp.charAt(0)){
                return "0";
            }
            answer += temp;

        }


        return answer;
    }
}

