package boj;

import java.util.Scanner;

public class Boj2661 {
    static int n;
    static String res = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(new StringBuilder());
        System.out.println(res);
    }

    public static void dfs(StringBuilder sb) {
        if (!res.equals("")) {
            return;
        }
        for (int i = 1; ; i++) {
            int len = sb.length();
            if (len - 2 * i < 0) {
                break;
            }
            if (sb.substring(len - i * 2, len - i).equals(sb.substring(len - i, len))) {
                return;
            }
        }
        if (sb.length() == n) {
            res = sb.toString();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sb.append(i);
            dfs(sb);
            sb.deleteCharAt(sb.length() - 1);
        }


    }
}
