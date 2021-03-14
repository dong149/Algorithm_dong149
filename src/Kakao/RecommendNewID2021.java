package Kakao;

import java.util.ArrayList;
import java.util.List;

public class RecommendNewID2021 {
    //    private List<Character> step2Res;
    public static void main(String[] args) {
        solution("abcdefghijklmn.p");
    }

    public static String solution(String new_id) {
        String answer = "";


        //1
        String step1Res ="";
        step1Res = new_id.toLowerCase();
        System.out.println("1단계"+step1Res);
        //2
        char[] step2 = step1Res.toCharArray();
        String step2Res = "";
        for (char c : step2) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                step2Res += c;
            }
        }
        System.out.println("2단계"+step2Res);

        //3
        char[] step3 = step2Res.toCharArray();
        String step3Res="";
        for(int i=0;i<step3.length;i++){
            if(i==step3.length-1){
                step3Res += step3[i];
                continue;
            }
            if(step3[i]=='.'&&step3[i+1]=='.')
                continue;
            step3Res += step3[i];
        }
        System.out.println("3단계"+step3Res);

        //4
        char[] step4 = step3Res.toCharArray();
        String step4Res = "";
        for(int i=0;i<step4.length;i++){
            if((i==0||i==step4.length-1)&&step4[i]=='.'){
                continue;
            }
            step4Res += step4[i];
        }

        System.out.println("4단계"+step4Res);

        //5
        String step5Res = "";
        if (step4Res.length() == 0) {
            step5Res = "a";
        } else {
            step5Res = step4Res;
        }
        System.out.println("5단계"+step5Res);



        //6
        String step6Res = "";
        if (step5Res.length() >= 16) {
            step5Res = step5Res.substring(0, 15);
            if(step5Res.charAt(step5Res.length()-1)=='.'){
                step6Res = step5Res.substring(0, 14);
            }else{
                step6Res = step5Res;
            }

        } else {
            step6Res = step5Res;
        }
        System.out.println("6단계"+step6Res);


        //7
        String step7Res = "";
        if (step6Res.length() <= 2) {
            char temp = step6Res.charAt(step6Res.length() - 1);
            step7Res = step6Res;
            while (step7Res.length() < 3) {
                step7Res += temp;
            }
        } else {
            step7Res = step6Res;
        }
        System.out.println("7단계"+step7Res);


        answer = step7Res;
        return answer;
    }
}
