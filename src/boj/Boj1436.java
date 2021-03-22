package boj;

import java.util.Scanner;


// substring 이 메모리 초과를 불러일으킨다고 한다.
//In the String object, when you call substring, the value property is shared between the two strings.
//So, if you get a substring from a big string and keep it for a long time, the big string won't be garbage collected. It could result in a memory leak, actually.


public class Boj1436 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long cur = 666;
        int idx = 1;
        long res=0;
        while(true){
            if(n==idx){
                res = cur;
                break;
            }
            cur++;
            if(String.valueOf(cur).contains("666"))
                idx++;
        }

        System.out.println(res);

    }

}



