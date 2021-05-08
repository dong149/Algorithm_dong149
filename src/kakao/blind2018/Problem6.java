package kakao.blind2018;

public class Problem6 {
    public static void main(String[] args) {
        String[] test = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        int result = solution(test);
        System.out.println(result);
    }


    /*
    서버 증설여부를 결정해야 한다.
    초당 최대 처리량을 계산한다.
    초당 최대 처리량은 쵸엉의 응답 완료 여부에 관걔없이
    임의 시간부터 1초간 처리하는 요청 최대 개수를 의미한다.

     */
    static int[][] times;
    public static int solution(String[] lines) {
        int answer = 0;

        times = new int[lines.length][2];
        for(int i=0;i<lines.length;i++){
            inputTime(lines[i],i);
        }

        for(int i=0;i<times.length;i++){
            answer = Math.max(checkNum(times[i][0]),answer);
            answer = Math.max(checkNum(times[i][0]-1000+1),answer);
            answer = Math.max(checkNum(times[i][1]-1000+1),answer);
            answer = Math.max(checkNum(times[i][1]),answer);
//            for(int j=0;j<2;j++){
//                answer = Math.max(checkNum(times[i][j]),answer);
//            }
        }


        return answer;
    }
    public static void inputTime(String s,int idx){
        int end=0;
        int start=0;
        String[] sArr = s.split(" ");
        String[] tArr = sArr[1].split(":");
        end += Integer.parseInt(tArr[0])*1000*60*60;
        end += Integer.parseInt(tArr[1])*1000*60;
        end += (int)(Double.parseDouble(tArr[2])*1000);

        int interval = (int)(Double.parseDouble(sArr[2].replaceAll("s",""))*1000);
        start = end-interval+1;
        times[idx][0] = start;
        times[idx][1] = end;
//        System.out.println(s);
//        System.out.println(start);
//        System.out.println(end);
//        System.out.println();
    }
    public static int checkNum(int time){
        int start = time;
        int end = time+1000-1;
        int cnt=0;
        for(int i=0;i<times.length;i++){
            if((start<=times[i][0]&&times[i][0]<=end)||(start<=times[i][1]&&times[i][1]<=end)||(times[i][0]<=start&&times[i][1]>=end)){
                cnt++;
            }
        }

        return cnt;
    }
}
