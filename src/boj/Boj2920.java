package boj;

import java.util.Scanner;

public class Boj2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[8];
        for(int i=0;i<8;i++){
            a[i] = sc.nextInt();
        }
        boolean asc=false;
        boolean dsc=false;
        boolean mix=false;
        for(int i=0;i<7;i++){
            if(a[i]<a[i+1]){
                asc= true;
            }else if(a[i]>a[i+1]){
                dsc = true;
            }
        }
        if(asc&&dsc)
            System.out.println("mixed");
        else if(asc)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}
