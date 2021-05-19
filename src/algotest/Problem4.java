package algotest;


import java.util.HashSet;
import java.util.Set;

public class Problem4 {
    public static void main(String[] args) {
        int[] ball = {1,2,3,4,5,6};
        int[] order = { 6,2,5,1,4,3};

        int[] ans = solution(ball,order);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }

    public static int[] solution(int[] ball,int[] order){
        int[] answer = new int[ball.length];
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int left=0;
        int right = ball.length-1;
        int ansIdx=0;
        for(int i=0;i<order[i];i++){
//            for(int j=0;j<answer.length;j++){
//                System.out.println(answer[j]);
//            }
            System.out.println("ddd");
            set.add(order[i]);
            while(left<=right){
                System.out.println("i: "+i+" left: "+left+" right :"+right);
                if(set.contains(ball[left])){
                    set.remove(ball[left]);
                    answer[ansIdx] = ball[left];
                    left++;
                    System.out.println("i: "+i+" left: "+left);
                    ansIdx++;
                    continue;
                }else if(set.contains(ball[right])){
                    set.remove(ball[right]);
                    answer[ansIdx] = ball[right];
                    System.out.println("i: "+i+" right: "+right);
                    right--;
                    ansIdx++;
                    continue;
                }
                break;
            }
        }
        return answer;
    }

}
