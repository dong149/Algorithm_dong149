package coding_test_practice;

public class Problem8 {

    /*
    0부터 9까지의 수로 이루어진 문자열이 있을 때, 홀수끼리 맞닿아있으면 '-'를, 짝수끼리 맞닿아있으면 '+'를 삽입하여 반환하는 코드를 작성하라.
     */
    public static void main(String[] args) {

        String test1 = "11223455";
        System.out.println(solution(test1));
    }

    public static String solution(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1;i<len;i++){
            if((s.charAt(i-1)-'0')%2==0&&(s.charAt(i)-'0')%2==0){
                sb.append('+');
            }else if((s.charAt(i-1)-'0')%2==1&&(s.charAt(i)-'0')%2==1){
                sb.append('-');
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
