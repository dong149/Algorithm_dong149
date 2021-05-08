package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.fill(dp,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int cur = arr[i];
            if(st.isEmpty()){
                st.push(cur);
            }else{
                while(true){
                    if(st.isEmpty()){
                        st.push(cur);
                        break;
                    }
                    int top = st.peek();
                    if(top>cur){
                        dp[i] = top;
                        st.push(cur);
                        break;
                    }else{
                        st.pop();
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);



    }
}
