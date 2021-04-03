package dev_matching2021;

import java.util.Arrays;

public class Problem1 {


    public int[] board = {6,6,5,4,3,2,1};
    public int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int zeros=0;
        int min,max;
        int correct=0;
        for(int i=0;i<6;i++){
            if(lottos[i]==0)
                zeros++;
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j]){
                    correct++;
                }
            }
        }
        if(correct+zeros>6){
            answer[0]  = 1;
        }else{
            answer[0] = board[correct+zeros];
        }
        answer[1] = board[correct];


        return answer;
    }




}
