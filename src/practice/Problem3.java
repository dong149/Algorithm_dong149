package practice;
import java.util.*;

public class Problem3 {

    public static void main(String[] args) {
        String test = "abcabcabcabcabc";
        String[] ans = solution(test);
        for(String st: ans){
            System.out.println(st);
        }
    }

    static List<String> stList = new ArrayList<>();
    public static String[] solution(String s) {

        int n = s.length();

        if(n==1){
            return new String[]{s};
        }


        StringBuilder lsb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();


        int lastLdx = 0;
        int lastRdx = 0;
        for(int i=0;i<(n+1)/2;i++){

            int ldx = i;
            int rdx = n-i-1;

            if(ldx==rdx)
                break;

            lsb.append(s.charAt(ldx));
            rsb.append(s.charAt(rdx));
            if(lsb.toString().equals(rsb.reverse().toString())){
                lastLdx = ldx+1;
                lastRdx = rdx-1;
                stList.add(lsb.toString());
                lsb.setLength(0);
                rsb.setLength(0);
            }
            rsb.reverse();

        }
        int listSize = stList.size();
        if(stList.isEmpty())
            stList.add(s);
        else{
            if(lastLdx<=lastRdx){
                stList.add(s.substring(lastLdx,lastRdx+1));
            }
            for(int i=listSize-1;i>=0;i--){
                stList.add(stList.get(i));
            }
        }
        return stList.toArray(String[]::new);
    }
}
