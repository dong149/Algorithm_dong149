package coding_test_practice;

public class Problem7 {

    /*
    문자열을 뒤집어 프린트하는 함수를 작성하세요.
     */
    public static void main(String[] args) {

        String test1 = "abcd";
        System.out.println(solution(test1));
    }

    public static String solution(String s) {
        char[] charArr = s.toCharArray();
        for(int i=0;i<s.length()/2;i++){
            char temp = charArr[i];
            charArr[i] = charArr[s.length()-i-1];
            charArr[s.length()-i-1] = temp;
        }

        return String.valueOf(charArr);
    }
}
