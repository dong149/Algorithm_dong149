package coding_test_practice;

public class Problem2 {
      /*
    1~n까지의 수의 합을 재귀적으로 표현
     */

    public static void main(String[] args) {
        int test1 = 10;

        System.out.println(solution(test1));
    }


    public static int solution(int n) {
        if(n==0)
            return 0;
        return solution(n-1) + n;
    }


}
