package Kakao;

public class NBase2018 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String nBase = "";
        for(int i=0;;i++){
            nBase = nBase + toNBase(n,i);
            if(nBase.length() > 110000) break;
        }
        System.out.println(nBase.substring(0,10));

        for(int i=0;i<t;i++){
            answer = answer + nBase.substring(p-1+m*i,p+m*i);
        }

        return answer;
    }
    // val 값을 n진법으로 변경합니다.
    public String toNBase(int n,int val){
        String res = "";
        int temp = val;
        if(temp==0){
            return res = "0";
        }
        while(temp>0){
            int nVal = temp%n;
            if(nVal > 9){
                res = Character.toString((char)((int)'A' + nVal-10)) + res;
            }else{
                res = nVal + res;
            }
            temp /= n;
        }
        return res;
    }


}
