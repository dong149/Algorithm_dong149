package kakao.intern2020;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }

    static String[] Pr = {"+-*","+*-","-+*","-*+","*-+","*+-"};

    public static long solution(String expression) {
        long answer = 0;
        Pattern p = Pattern.compile("(\\b[0-9]+\\b)|(\\b[-+*]\\b)");
        ArrayList<String> arr = new ArrayList<>();
        Matcher ma = p.matcher(expression);
        while(ma.find()){
            arr.add(ma.group());
        }
        ArrayList<String> temp = new ArrayList<>(arr);
        for(int i=0;i<Pr.length;i++){
            arr=new ArrayList<>(temp);
            for(int j=0;j<3;j++){
                char cur = Pr[i].charAt(j);
                ArrayList<String> tempArr = new ArrayList<>();
                for(int k=0;k<arr.size();k++){
                    if(arr.get(k).matches("-?[0-9]+")){
                        tempArr.add(arr.get(k));
                    }else{
                        if(arr.get(k).charAt(0)==cur){
                            if(cur=='*'){
                                tempArr.set(tempArr.size()-1,String.valueOf(Long.parseLong(tempArr.get(tempArr.size()-1))*Long.parseLong(arr.get(k+1))));
                            }else if(cur=='+'){
                                tempArr.set(tempArr.size()-1,String.valueOf(Long.parseLong(tempArr.get(tempArr.size()-1))+Long.parseLong(arr.get(k+1))));
                            }else{
                                tempArr.set(tempArr.size()-1,String.valueOf(Long.parseLong(tempArr.get(tempArr.size()-1))-Long.parseLong(arr.get(k+1))));
                            }
                            k++;
                        }else{
                            tempArr.add(arr.get(k));
                        }
                    }
                }
                arr = new ArrayList<>(tempArr);
            }
            answer = Math.max(Math.abs(Long.parseLong(arr.get(0))),answer);


        }
        return answer;
    }

}
