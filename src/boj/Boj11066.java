package boj;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Boj11066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.add(sc.nextInt());
            }
            int sum = 0;
            while (!pq.isEmpty()) {
                int temp = pq.poll();
                int temp2 = 0;
                if (!pq.isEmpty()) {
                    temp2 = pq.poll();
                    sum += temp + temp2;
                    pq.add(temp + temp2);
//                    System.out.println(temp+temp2);
                } else {
                    break;
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
