package kakao;

import java.util.PriorityQueue;

public class CrossingStone2019 {
    public static void main(String[] args) {
        int[] test = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
//        int[] test = {0,1,1,1};
        int res = solution(test, 3);
        System.out.println(res);
    }


    public static int solution(int[] stones, int k) {
        int answer = 0;

        int left=200000001;
        int right=0;
        int mid=0;
        for(int i=0;i<stones.length;i++){
            right = Math.max(stones[i],right);
            left = Math.min(stones[i],left);

        }
        int res=0;

        while(left<=right){
            mid = (left+right)/2;
            int cnt=0;
            boolean check=false;
            for(int i=0;i<stones.length;i++){
                if(stones[i]-mid<=0)
                    cnt++;
                else
                    cnt=0;

                if(cnt>=k) {
                    System.out.println(mid);
                    System.out.println(cnt);
                    check=true;
                    break;
                }
            }
            if(check){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        answer = res;
        return answer;
    }


}
