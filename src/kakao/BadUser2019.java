package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BadUser2019 {
    public static void main(String[] args) {
        String[] test = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban = {"fr*d*", "*rodo", "******", "******"};
        int temp = solution(test,ban);
        System.out.println(temp);

    }

    static ArrayList<Map<String,Integer>> mapList = new ArrayList<>();
    static Map<Integer,Integer> visitedMap = new HashMap<>();
    static int ans=0;
    public static int solution(String[] user_id, String[] banned_id) {
//        mapList = new Map[user_id.length];
        for(int i=0;i<user_id.length;i++){
            String temp = user_id[i];
            Map<String,Integer> map = new HashMap<>();
            insertDfs(temp,"",0,map);
            mapList.add(map);
        }


        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0;i<banned_id.length;i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<banned_id.length;i++){
            for(int j=0;j<mapList.size();j++){
                if(mapList.get(j).containsKey(banned_id[i])){
                    arr.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[user_id.length];
        dfs(visited,(1<<user_id.length),arr,0);

        return ans;
    }
    public static void dfs(boolean[] visited,int visitedBinary,ArrayList<ArrayList<Integer>> arr,int idx){
        if(idx==arr.size()){
            if(!visitedMap.containsKey(visitedBinary)){
                visitedMap.put(visitedBinary,1);
                ans++;
            }
            return;
        }

        for(int i=0;i<arr.get(idx).size();i++){
            int cur = arr.get(idx).get(i);
            if(!visited[cur]){
                visited[cur] = true;
                visitedBinary |= (1<<cur);
                dfs(visited,visitedBinary,arr,idx+1);
                visitedBinary &= ~(1<<cur);
                visited[cur] = false;
            }
        }
    }
    public static void insertDfs(String s,String temp,int idx,Map<String,Integer> map){
        if(idx==s.length()){
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }
            return;
        }
        insertDfs(s,temp+"*",idx+1,map);
        insertDfs(s,temp+s.charAt(idx),idx+1,map);
    }
}
