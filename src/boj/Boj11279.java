package boj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11279 {
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2)
                return 1;
            else if (o1.equals(o2))
                return 0;
            else
                return -1;
        }
    });

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                pq.add(temp);
            }
        }
        System.out.println(sb);
    }

}
