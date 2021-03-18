package programmers.binary_search;


import java.util.Arrays;


// 다시 풀자
// 입국 심사 문제
public class Immigration {
    public long solution(int n, int[] times) {

        //오름차순으로 정렬
        Arrays.sort(times);
        long answer = binarySearch(times,n,times[times.length-1]);
        return answer;
    }


    public long binarySearch(int[] times,int n,long max){
        long left = 1;
        long right = max*n;
        long mid = 0;
        long ans = Long.MAX_VALUE;
        while(left<=right){
            mid = (left+right)/2;
            if(isPassed(times,n,mid)){
                System.out.println(mid);
                ans = Math.min(ans, mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    // 가능한 값인지
    boolean isPassed(int[] times,int n,long mid){
        long sum=0;

        for(int i=0;i<times.length;i++){
            sum += mid/times[i];
        }
        if(sum>=n) return true;
        else return false;
    }

}
