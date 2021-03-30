package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Boj4358 {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String st="";
        int cnt = 0;
        while ((st = br.readLine()) != null&&st.length()!=0) {
            if (!map.containsKey(st)) {
                map.put(st, 1);
            } else {
                map.put(st, map.get(st) + 1);
            }
            cnt++;
        }

        String[] mapKey = map.keySet().toArray(new String[0]);
        Arrays.sort(mapKey);

        for (String temp : mapKey) {
            double per = (double)(map.get(temp)*100.0)/cnt;
            sb.append(temp).append(' ').append(String.format("%.4f", per)).append('\n');
        }

        System.out.print(sb);


    }
}
