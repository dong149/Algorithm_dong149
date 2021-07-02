package algorithm;


import java.util.*;

public class Test2 {


    public static void main(String[] args){

        int[] arr = {1,2,3,4,5};
        int res = getValSameIndex(arr,0);
        System.out.println(res);

    }
    public static int getValSameIndex(int[] arr, int n){
        if(n>=arr.length)
            return -1;
        if(arr[n]==n)
            return n;
        return getValSameIndex(arr, n+1);
    }







}
