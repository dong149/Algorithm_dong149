package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {
    public static class Node {
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] res = new int[n + 1];
        Stack<Node> st = new Stack<>();
        StringTokenizer stt = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(stt.nextToken());
            int ans = 0;
            while (!st.isEmpty()) {
                if (st.peek().val < arr[i])
                    st.pop();
                else {
                    ans = st.peek().idx;
                    break;
                }
            }
            res[i] = ans;
            st.push(new Node(arr[i], i));
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();


    }
}
