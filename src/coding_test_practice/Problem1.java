package coding_test_practice;

public class Problem1 {

    /*
    정수가 주어졌을 때, 3자리마다 콤마를 넣는 함수를 작성하라
     */

    public static void main(String[] args) {
        int test1 = 0;
        int test2 = -1;

        System.out.println(solution(test1));
        System.out.println(solution(test2));
    }


    public static String solution(int n) {


        StringBuilder sb = new StringBuilder();
        boolean isPositive = true;
        if(n<0) {
            isPositive = false;
            n *= -1;
        }else if(n==0){
            sb.append(0);
        }

        int cnt = 0;
        while (n != 0) {

            sb.append(n % 10);
            cnt++;
            n /= 10;
            if (n != 0 && cnt % 3 == 0)
                sb.append(',');
        }

        if(!isPositive)
            sb.append('-');


        return sb.reverse().toString();
    }


}
