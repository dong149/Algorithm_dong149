package practice;


import java.util.PriorityQueue;

public class Problem1 {

    PriorityQueue<Integer> pqPrice = new PriorityQueue<>((x, y) -> Integer.compare(y, x));;
    PriorityQueue<Integer> pqDisc = new PriorityQueue<>((x, y) -> Integer.compare(y, x));;
    public int solution(int[] prices, int[] discounts) {

        int answer = 0;

        for(int i:prices){
            pqPrice.add(i);
        }
        for(int i:discounts){
            pqDisc.add(i);
        }

        while(!pqPrice.isEmpty()){
            int disc = 100;
            if(!pqDisc.isEmpty()){
                disc = pqDisc.poll();
            }
            answer += pqPrice.poll()/100*disc;
        }
        return answer;
    }


}
