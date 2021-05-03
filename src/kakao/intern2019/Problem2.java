package kakao.intern2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {

    public static void main(String[] args) {
        String s ="{{1,2,3},{2,1},{1,2,4,3},{2}}";
        solution(s);
    }
    public static int[] solution(String s) {
        int[] answer;
        boolean[] visited = new boolean[100001];
        ArrayList<String> arr = new ArrayList<>();
        s = s.replaceAll("^\\{","").replaceAll("\\}{2}","}");

//        System.out.println(s);
        Pattern p = Pattern.compile("\\{[0-9|,]+\\}");
        Matcher ma = p.matcher(s);
        while(ma.find()){
            arr.add(ma.group().replaceAll("\\{|\\}",""));
//            System.out.println(ma.group());
        }
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        answer = new int[arr.size()];
        int cnt=0;
        for(String temp:arr){
//            System.out.println(temp);
            for(String sp:temp.split(",")){
                int n = Integer.parseInt(sp);
                if(!visited[n]){
                    visited[n] = true;
                    answer[cnt]=n;
                    cnt++;
                    break;
                }
            }
        }

        return answer;
    }
}
