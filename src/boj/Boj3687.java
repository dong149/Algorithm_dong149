package boj;

import java.util.*;

public class Boj3687 {
    static ArrayList<ArrayList<Integer>> digitList = new ArrayList<>();
    static String[] dpMin = new String[101];
    static String[] dpMax = new String[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int i=0;i<8;i++){
            digitList.add(new ArrayList<>());
        }
        digitList.get(2).add(1);
        digitList.get(3).add(7);
        digitList.get(4).add(4);
        digitList.get(5).add(5);
        digitList.get(5).add(2);
        digitList.get(5).add(3);
        digitList.get(6).add(6);
        digitList.get(6).add(9);
        digitList.get(6).add(0);
        digitList.get(7).add(8);

        dpMin[0] = "";
        dpMin[2] = "1";
        dpMin[3] = "7";
        dpMax[0] = "";
        dpMax[2] = "1";
        dpMax[3] = "7";

        for(int i=4;i<101;i++){
            for(int j=2;j<=7;j++){
                if((i-j)<0||(i-j)==1){
                    continue;
                }
                for(int k=0;k<digitList.get(j).size();k++){
                    String temp = dpMin[i-j]+String.valueOf(digitList.get(j).get(k));
                    if(temp.charAt(0)=='0'){
                        continue;
                    }
                    if(dpMin[i]==null){
                        dpMin[i]= temp ;
                    }else{
                        if(compare(dpMin[i],temp)>0){
                            dpMin[i] = temp;
                        }
                    }
                }
            }
        }



        for(int i=4;i<101;i++){
            for(int j=2;j<=7;j++){
                if((i-j)<0||(i-j)==1){
                    continue;
                }
                for(int k=0;k<digitList.get(j).size();k++){
                    String temp = dpMax[i-j]+String.valueOf(digitList.get(j).get(k));
                    if(temp.charAt(0)=='0'){
                        continue;
                    }
                    if(dpMax[i]==null){
                        dpMax[i]= temp ;
                    }else{
                        if(compare(temp,dpMax[i])>0){
                            dpMax[i] = temp;
                        }
                    }
                }
            }
        }


        while(t-->0){
            int n = sc.nextInt();
            sb.append(dpMin[n]).append(' ').append(dpMax[n]).append('\n');
        }
        System.out.println(sb);
    }

    public static int compare(String o1, String o2) {
        if(o1.length()>o2.length()){
            return 1;
        }else if(o1.length()==o2.length()){
            return o1.compareTo(o2);
        }else{
            return -1;
        }
    }

}
