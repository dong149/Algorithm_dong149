package kakao.intern2019;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Problem3 {
    public static void main(String[] args) {

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id ={"*rodo", "*rodo", "******"};
        int res = solution(user_id,banned_id);
        System.out.println(res);
    }

    // *을 .으로 바꿔서 matches()함수를 이용하여 맞는 것들을 찾아낸다.
    // 찾아내면 각각


    static Set<Integer> set = new HashSet<>();
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        int visited = 0;
        dfs(visited,0,user_id,banned_id);
        answer=set.size();

        return answer;

    }

    public static void dfs(int visited,int idx,String[] user_id,String[] banned_id){

        //end
        if(idx==banned_id.length){
//            System.out.println(Integer.toBinaryString(visited));
            set.add(visited);
            return;
        }


        String cur = banned_id[idx];
        cur = cur.replaceAll("\\*",".");
        cur = "^"+cur+"$";
//        System.out.println(cur);
        for(int i=0;i<user_id.length;i++){
            if(user_id[i].matches(cur)&&((visited&(1<<i))==0)){
                visited = visited|(1<<i);
                dfs(visited,idx+1,user_id,banned_id);
                visited = visited&(~(1<<i));
            }
        }



    }
}
