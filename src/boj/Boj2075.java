package boj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj2075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.add(sc.nextInt());
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(!pq.isEmpty())
                res = pq.poll();
        }
        System.out.println(res);



    }
}
