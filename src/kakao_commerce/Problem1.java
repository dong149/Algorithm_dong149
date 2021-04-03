package kakao_commerce;

import java.util.*;


public class Problem1 {
    public static void main(String[] args) {
        //test =
        //solution(test);
    }

    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        int[] gc = new int[100001];
        for(int i=0;i<gift_cards.length;i++){
            gc[gift_cards[i]]++;
        }
        for(int i=0;i<wants.length;i++){
            if(gc[wants[i]]>0){
                gc[wants[i]]--;
            }
        }
        for(int i=0;i<gc.length;i++){
            answer+=gc[i];
        }
        return answer;
    }





}
