package boj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11286 {

    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) > Math.abs(o2))
                return 1;
            else if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else
                return -1;
        }
    });
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp == 0) {
                if (pq.isEmpty())
                    sb.append(0).append('\n');
                else {
                    sb.append(pq.poll()).append('\n');
                }
            } else {
                pq.add(temp);
            }
        }

        System.out.println(sb);
    }


}
