package dev_matching2021;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class Problem3 {
    public static class Info{
        String ref;
        int val;

        public Info(String ref,int val){
            this.ref = ref;
            this.val = val;
        }

    }
    static HashMap<String,Info> map = new LinkedHashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        map.put("center",new Info("end",0));
        for(int i=0;i<referral.length;i++){
            String temp = referral[i];
            if(temp.equals("-")){
                map.put(enroll[i],new Info("center",0));
            }else{
                map.put(enroll[i],new Info(temp,0));
            }
        }

        for(int i=0;i<seller.length;i++){
            String cur = seller[i];
            int a = amount[i]*100;
            while(true){
                if(cur.equals("end"))
                    break;
                if(map.containsKey(cur)){

                    map.get(cur).val = map.get(cur).val+a-(int)(a*0.1);
                }
                a = (int)(a*0.1);
                cur = map.get(cur).ref;
            }
        }
        for(int i=0;i<enroll.length;i++){
            answer[i] = map.get(enroll[i]).val;
        }
        return answer;
    }
}
