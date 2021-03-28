package scofe2021_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }
        int q = sc.nextInt();
        for(int i=0;i<q;i++){
            String find = sc.next();
            int cnt=0;
            for(int j=0;j<n;j++){
                int[] pi = getPi(find);
                if(kmp(arr[j],find,pi))
                    cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
    public static int[] getPi(String pattern){
        int n = pattern.length();
        int j=0;
        char[] p = new char[n];
        int[] pi = new int[n];
        p = pattern.toCharArray();
        for(int i=1;i<n;i++){
            while(j>0&&p[i]!=p[j]){
                j=pi[j-1];
            }
            if(p[i]==p[j]){
                j++;
                pi[i] = j;
            }
        }
        return pi;
    }


    public static boolean kmp(String str, String pattern,int[] pi){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = str.length();
        int m = pattern.length();
        int j=0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for(int i=0;i<n;i++){
            while(j>0 && s[i] != p[j]){
                j=pi[j-1];
            }

            if(s[i] == p[j]){
                if(j == m -1){
                    return true;
                }else{
                    j++;
                }
            }
        }
        return false;
    }
}
