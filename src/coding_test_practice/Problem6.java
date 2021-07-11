package coding_test_practice;

public class Problem6 {
/*
    정수를 인자로 받아 문자열을 반환하는 함수를 작성하라
 */


    public static void main(String[] args) {

        int test1 = 1000;
        int test2 = -1000;
        System.out.println(solution(test1));
        System.out.println(solution(test2));

    }


    public static String solution(int n) {

        boolean isPositive = true;
        StringBuilder sb = new StringBuilder();
        if(n<0){
            isPositive = false;
            n *= -1;
        }else if(n==0){
            return "0";
        }

        while(n!=0){
            sb.append(n%10);
            n /= 10;
        }

        if(!isPositive)
            sb.append("-");

        return sb.reverse().toString();

    }



}
