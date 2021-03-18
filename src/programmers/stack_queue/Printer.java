package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {


    private class Doc{
        int loc;
        int prior;

        public Doc(int loc,int prior){
            this.loc = loc;
            this.prior = prior;
        }
    }

    private Queue<Doc> q = new LinkedList<>();

    public int solution(int[] priorities, int location) {
        int answer = 0;

        for(int i=0;i<priorities.length;i++){
            q.add(new Doc(i,priorities[i]));
        }

        int cnt=0;
        while(!q.isEmpty()){
            Doc cur = q.poll();
            boolean isPoll = true;
            for(Doc temp:q){
                if(cur.prior<temp.prior){
                    isPoll = false;
                    q.add(cur);
                    break;
                }
            }
            for(Doc temp:q){
                System.out.println(temp.loc);
            }
            if(isPoll){
                cnt++;
            }

            if(isPoll&&cur.loc ==location){
                 return cnt;
            }

        }

        return answer;
    }
}
