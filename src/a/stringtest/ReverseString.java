package a.stringtest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class ReverseString {

//    private static String s = "abcde";

    public static void main(String[] args) {

//        reverseString1(s);
//        reverseString2(s);
        int[] a = {0,2,2,2,5};
        findSameVal(a,a.length-1);
        List<Integer> li =  new ArrayList<>();

    }
    public static void findSameVal(int[] a,int idx){
        if(idx<0)
            return;
        if(a[idx]==idx)
            System.out.println(idx);

        findSameVal(a,idx-1);
    }
    // 영어 단어, 그 갯수
    public static void findEnglishWords(String str){
        HashSet<String> set = new HashSet<>();
        String[] strArr = str.split(" ");
        int cnt=0;
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.matches("[a-zA-Z]+")){
                set.add(token);
            }
        }
//        for(String s:strArr){
//            if(s.matches("[a-zA-Z]+")){
//                set.add(s);
//            }
//        }
        for(String s:set){
            System.out.println(s);
        }
        System.out.println(set.size());
    }





    public static int countEight(int n){
        int cnt=0;
        while(true){
            if(n==0)
                break;
            if(n%10==8)
                cnt++;
            n/=10;
        }
        return cnt;
    }


    public static void reverseString1(String s){
        char[] cArr = s.toCharArray();
        char[] resArr = new char[cArr.length];
        for(int i=cArr.length-1;i>=0;i--){
            resArr[cArr.length-i-1] = cArr[i];
        }
        printCharArr(resArr);
    }

    public static void reverseString2(String s){
        char[] cArr = s.toCharArray();


        char[] resArr = new char[cArr.length];
        for(int i=0;i<cArr.length/2;i++){
            char temp;
            temp = cArr[i];
            cArr[i] = cArr[cArr.length-i-1];
            cArr[cArr.length-i-1] = temp;
        }
        printCharArr(cArr);
    }

    public static void printCharArr(char[] cArr){
        for(char c: cArr){
            System.out.print(c+" ");
        }
        System.out.println();
    }


}
