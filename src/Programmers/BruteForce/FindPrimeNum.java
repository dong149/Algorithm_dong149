package Programmers.BruteForce;

import java.util.HashMap;
import java.util.Map;

public class FindPrimeNum {

    private char[] numbersChar;
    int cnt;
    private Map<String, Integer> map = new HashMap<>();

    public int solution(String numbers) {
        cnt = 0;
        numbersChar = numbers.toCharArray();
        for (int i = 0; i < numbersChar.length; i++) {
            if (numbersChar[i] == '0')
                continue;
            boolean[] visited = new boolean[numbers.length()];
            dfs(numbers.substring(i, i + 1), i, visited);
        }
        return cnt;
    }


    private void dfs(String str, int num, boolean[] visited) {
        visited[num] = true;
        if (!map.containsKey(str)) {
            map.put(str, 0);
        }
        int temp = Integer.parseInt(str);
//            System.out.println(temp);
        if (isPrime(temp)&&map.get(str)==0) {
            map.put(str,1);
            cnt++;
        }

        if (str.length() == numbersChar.length)
            return;

        for (int i = 0; i < numbersChar.length; i++) {
            if (!visited[i]) {
//                System.out.println("방문안한"+i+"번째 수 :"+numbersChar[i]);
                if (!map.containsKey(str + numbersChar[i])) {
                    dfs(str + numbersChar[i], i, visited);
                    visited[i] = false;
                }
            }
        }
    }

    private boolean isPrime(int n) {
        if (n == 1 || n == 0)
            return false;
        if (n == 2)
            return true;
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                cnt++;
        }
        return cnt == 0;


    }
}
