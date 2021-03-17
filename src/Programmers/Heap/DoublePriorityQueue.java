package Programmers.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {


    public static void main(String[] args) {
        String[] test = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        int[] ans = solution(test);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
    //오름차순
    private static PriorityQueue<Integer> pqMin = new PriorityQueue<>();
    //내림차순
    private static PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];


        int addCnt=0;
        int pollCnt=0;
        for(String temp:operations){
            String[] operation = temp.split(" ");
//            System.out.println(operation[0]);
//            System.out.println(operation[1]);
            //삽입
            if(pollCnt==addCnt&&pollCnt>0) {
                pqMax.clear();
                pqMin.clear();
            }

            if(operation[0].equals("I")){
                System.out.println("I "+operation[1]);
                pqMax.add(Integer.parseInt(operation[1]));
                pqMin.add(Integer.parseInt(operation[1]));
                addCnt++;
            }else{
                if(pollCnt==addCnt){
                    continue;
                }
                if(operation[1].equals("-1")){
                    pollCnt++;
                    pqMin.poll();
                }else{
                    pollCnt++;
                    pqMax.poll();
                }

            }
        }
        if(pollCnt==addCnt){
            return answer;
        }else{
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }

        return answer;
    }

}
