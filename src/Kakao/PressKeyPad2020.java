package Kakao;


/**
 * 2020 카카오 인턴십 키보드 누르기
 * 느낀점 : 문제 그대로 따라가면 풀린다.
 * 구현
 **/
public class PressKeyPad2020 {

    int[][] numPad = {
            {3,1},
            {0,0},
            {0,1},
            {0,2},
            {1,0},
            {1,1},
            {1,2},
            {2,0},
            {2,1},
            {2,2},
    } ;

    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    boolean isLeft = false;
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        String answer = "";

        isLeft = hand.equals("left");
        for(int num:numbers){
            String whichHand = pushNumber(num);
            sb.append(whichHand);
            if(whichHand.equals("L")) leftPos = numPad[num];
            else rightPos = numPad[num];
        }
        answer = sb.toString();
        return answer;


    }
    public String pushNumber(int num){
        // left
        if(num==1||num==4||num==7) return "L";
        if(num==3||num==6||num==9) return "R";

        int dLeft = getDist(leftPos,num);
        int dRight = getDist(rightPos,num);
        if(dLeft>dRight) return "R";
        if(dLeft<dRight) return "L";

        if(isLeft) return "L";
        else return "R";

    }

    public int getDist(int[] pos,int num){
        return Math.abs(pos[0]-numPad[num][0]) + Math.abs(pos[1]-numPad[num][1]);
    }
}
