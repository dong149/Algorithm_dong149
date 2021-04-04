package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            pq.add(sc.nextLong());
        }
        long res=0;
        if(n==1){
            System.out.println(0);
            return;
        }
        while(!pq.isEmpty()){
            long temp = pq.poll();
            if(pq.isEmpty())
                break;
            long temp2 = pq.poll();
            res+=temp+temp2;
            pq.add(temp+temp2);
        }
        System.out.println(res);
    }

}
