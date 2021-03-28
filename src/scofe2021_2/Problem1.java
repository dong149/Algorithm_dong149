package scofe2021_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1 {
    static Queue<Music> q = new LinkedList<>();

    public static class Music {
        int time;
        int idx;


        public Music(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }


    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        String timeStr = sc.next();
        String[] timeStrSp = timeStr.split(":");
        int time = Integer.parseInt(timeStrSp[0]) * 3600 + Integer.parseInt(timeStrSp[1]) * 60 + Integer.parseInt(timeStrSp[2]);
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            String[] tempSp = temp.split(":");
            arr[i] = Integer.parseInt(tempSp[0]) * 60 + Integer.parseInt(tempSp[1]);
        }

        int maxSize = 0;
        int maxIdx = -1;
        int curSum = 0;
        // 큐에 넣으면서 매번 size를 체크해준다. max 값을 찾아내고, 그럴 경우 index값을 넣어줘야함.
        int i = 0;
        while (i < n) {
            q.add(new Music(arr[i], i));
            curSum += arr[i];

            if (curSum <= time) {
                if (maxSize < q.size()) {
                    maxSize = q.size();
                    maxIdx = q.peek().idx;
                }
                i++;
                continue;
            }
            if(curSum >= time && time>curSum-arr[i]){
                if(maxSize<q.size()){
                    maxSize = q.size();
                    maxIdx = q.peek().idx;

                }
            }
//            System.out.println("curSum:"+curSum+"time:"+time);
            while(!q.isEmpty()&&curSum>time){
                    curSum -= q.poll().time;
            }
            i++;

        }
//        System.out.println(time);
//        for(int j=0;j<n;j++) {
//            System.out.println(arr[j]);
//        }
        System.out.println(maxSize+" "+(maxIdx+1));
    }
}
