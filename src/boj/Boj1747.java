package boj;

import java.util.Scanner;
import java.util.Stack;

public class Boj1747 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[2000001];
        prime[1] = true;
        // false->prime;
        int n = sc.nextInt();
        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        int res = 0;
        for (int i = n ; ; i++) {
            if (!prime[i] && isPal(i)) {
                res = i;
                break;
            }
        }
        System.out.println(res);

    }

    public static boolean isPal(int n) {
        char[] num = Integer.toString(n).toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length; i++) {
            if (num.length % 2 == 1 && i == num.length / 2) {
                continue;
            }
            if (i < num.length / 2) {
                st.push(num[i]);
            } else {
                if (st.peek() == num[i]) {
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return true;


    }
}
