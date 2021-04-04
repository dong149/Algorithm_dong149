package boj;

import java.util.*;

public class Boj11000 {
    public static class Time implements Comparable<Time> {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Time> pq = new PriorityQueue<>();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
            pq.add(new Time(a, b));
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            Time t = null;
            if (!pq.isEmpty()) {
                t = pq.peek();
            }
            if (t.end <= arr[i][0])
                pq.poll();
        }
        System.out.println(pq.size());

    }


}
