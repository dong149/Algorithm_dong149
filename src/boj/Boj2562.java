package boj;

import java.util.Scanner;

public class Boj2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[9];
        int max=0;
        int ans=0;
        for(int i=0;i<9;i++){
            n[i] = sc.nextInt();
            if(max<n[i]){
                ans=i;
                max = n[i];
            }
        }
        System.out.println(max);
        System.out.println(ans+1);

    }
}
