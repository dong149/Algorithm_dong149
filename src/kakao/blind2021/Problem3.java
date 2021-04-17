package kakao.blind2021;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        String[] info ={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] ans = solution(info, query);
        for(int i:ans){
            System.out.println(i);
        }
    }


    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];


        for(int i=0;i<info.length;i++) {
            String[] sArr = info[i].split(" ");
            dfsInsert(sArr,0,"");
        }
        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();
            ArrayList<Integer> li = map.get(key);
            Collections.sort(li);
        }

        for(int i=0;i<query.length;i++){
            String[] qArr =query[i].replaceAll("and ","").split(" ");
            String q="";
            int temp= Integer.parseInt(qArr[4]);
            for(int j=0;j<4;j++){
                q+=qArr[j];
            }
            if(map.containsKey(q)){
                answer[i] = bSearch(map.get(q),temp);
            }else{
                answer[i] = 0;
            }
        }

        return answer;
    }
    public static int bSearch(ArrayList<Integer> li,int temp){
        int left = 0;
        int right = li.size()-1;
        int res = -1;
        int mid;
        while(left<=right){
            mid = (left+right)/2;
            if(li.get(mid)>=temp){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(res==-1){
            return 0;
        }
        return li.size()-res;
    }



    public static void dfsInsert(String[] sArr,int idx,String s){
        if(idx==4){
            if(map.containsKey(s)){
                map.get(s).add(Integer.parseInt(sArr[4]));
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(sArr[4]));
                map.put(s,list);
            }
            return;
        }
        dfsInsert(sArr,idx+1,s+"-");
        dfsInsert(sArr,idx+1,s+sArr[idx]);
    }
}
