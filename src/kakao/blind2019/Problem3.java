package kakao.blind2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        String[][] relation ={{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int res = solution(relation);
        System.out.println(res);
    }
    static ArrayList<Integer> keyLi = new ArrayList<>();
    public static int solution(String[][] relation) {
        int visitMax = (1<<relation[0].length);

        for(int i=1;i<visitMax;i++){
            boolean isCorrect = true;
            for(int key:keyLi){
                if((i&key)==key){
                    isCorrect=false;
                    break;
                }
            }
            if(!isCorrect) continue;
            check(relation,i);

        }

        return keyLi.size();
    }

    public static void check(String[][] relation,int visit){
        String temp;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<relation.length;i++){
            temp="";
            for(int j=0;j<relation[0].length;j++){
                if((visit&(1<<j))>0){
                    temp+=relation[i][j];
                }
            }
            if(map.containsKey(temp)){
                return;
            }else{
                map.put(temp,1);
            }
        }
        keyLi.add(visit);
    }

}
