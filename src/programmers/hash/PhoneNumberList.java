package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {

    private static Map<String,Integer> map= new HashMap<>();
    public static boolean solution(String[] phone_book) {
        if(phone_book.length==1)
            return true;

        //다 집어넣는다.
        for(String temp:phone_book) {
            map.put(temp,1);
        }

        for(String temp:phone_book){
            for(int i=1;i<=temp.length();i++){
                String comp = "";
                comp = temp.substring(0,i);
                if(map.containsKey(comp)&&!comp.equals(temp)){
                    return false;
                }
            }
        }

        return true;
    }
}
