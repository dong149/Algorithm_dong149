package Kakao;



/**
 * 2021 카카오 블라인드 합승 택시 요금
 *
 * 플로이드 와샬 알고리즘이다.
 * 다시 풀어야 됨.
 **/



public class SharedTaxiFare2021 {

    public static void main(String[] args) {
        int[][] fares = {{2,3,3},{1,3,5}};
        int ans = solution(3,1,2,3,fares);
        System.out.println(ans);
    }



    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] fw = new int[n+1][n+1];
        for(int i=0;i<fares.length;i++){
            int[] fare = fares[i];
            fw[fare[0]][fare[1]] = fare[2];
            fw[fare[1]][fare[0]] = fare[2];
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) fw[i][j] = 0;
                else {
                    if(fw[i][j]==0) fw[i][j] = 987654321;
                }
            }
        }
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(fw[i][j]>fw[i][k]+fw[k][j]) fw[i][j]=fw[i][k]+fw[k][j];
                }
            }
        }

        answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            System.out.println(i+"일 때 : "+(fw[s][i]+fw[i][a]+fw[i][b]));
            System.out.println("----------");
            if(fw[s][i]+fw[i][a]+fw[i][b]<0){
                continue;
            }
            answer= Math.min(answer,fw[s][i]+fw[i][a]+fw[i][b]);
        }
        return answer;

    }

}
