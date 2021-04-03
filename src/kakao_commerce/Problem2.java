package kakao_commerce;
import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        //test =
        //solution(test);
    }

    static int res=0;
    public static int solution(int[][] needs, int r) {
        int answer = 0;
        int n = needs.length;
        int m = needs[0].length;
        for(int i=0;i<=m-r;i++){
            boolean[] arr = new boolean[m];
            arr[i] = true;
            dfs(arr,1,n,m,needs,r,i+1);
        }

        System.out.println(res);
        answer = res;
        return answer;
    }

    public static void dfs(boolean[] arr,int cnt,int n,int m,int[][] needs ,int r,int idx){
        if(cnt==r){
            int sum=0;
            for(int i=0;i<n;i++){
                boolean check=true;
                for(int j=0;j<m;j++){
                    if(needs[i][j]==1&&!arr[j]){
                        check=false;
                    }
                }
                if(check)
                    sum++;
            }
            res = Math.max(sum,res);
            return;
        }

        for(int i=idx;i<m;i++){
            arr[i] = true;
            dfs(arr,cnt+1,n,m,needs,r,idx+1);
            arr[i] = false;
        }


    }







}
