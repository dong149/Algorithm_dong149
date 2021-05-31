package algorithm;

import java.util.Random;

public class RandomTest {


    /*
    Random 클래스 테스트

    seed가 같으면, 결과값은 항상 동일하다.
    nextInt의 결과값은
    0<= random.nextInt(bound) < bound
    이다.


     */


    static Random random = new Random(3);
    public static void main(String[] args) {
        for(int i=1;i<=8;i++){
            System.out.println(random.nextInt(6)+1);
        }
    }
}
