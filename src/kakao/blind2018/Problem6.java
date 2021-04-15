package kakao.blind2018;

public class Problem6 {
    public static void main(String[] args) {
        String[] test = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        int result = solution(test);
        System.out.println(result);
    }

    public static int solution(String[] lines) {
        for(int i=0;i<lines.length;i++){
            String temp = lines[i].replaceAll("2016-09-15 ","").replaceAll("s","");
            System.out.println(temp);
        }


        int answer = 0;
        return answer;
    }
}
