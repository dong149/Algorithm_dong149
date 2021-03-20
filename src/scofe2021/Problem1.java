package scofe2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1 {
    public static void main(String[] args) throws Exception {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        n = Integer.parseInt(temp);
        int start = 0;
        int end = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.println(i);
            temp = br.readLine();
            String[] timeStr = temp.split(" ");
            start = Math.max(getMinutes(timeStr[0]),start);
            end = Math.min(getMinutes(timeStr[2]),end);
        }
        if (start > end) {
            System.out.println(-1);
        } else {
            System.out.println(getSocarTime(start) + " ~ " + getSocarTime(end));
        }


    }

    private static int getMinutes(String t) {
        int h = Integer.parseInt(t.substring(0, 2));
        int m = Integer.parseInt(t.substring(3, 5));
        return h * 60 + m;
    }

    private static String getSocarTime(int t) {
        String h = String.format("%02d", t / 60);
        String m = String.format("%02d", t % 60);

        return h + ":" + m;

    }

}
