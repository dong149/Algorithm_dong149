package algorithm;

import java.util.Scanner;


// 프로그래머스 input을 테스트해보기 편하게 하기 위해서 input을 변경하는 코드를 작성했습니다.
public class ChangeProgrammersInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.replaceAll("\\[","{");
        input =input.replaceAll("]","}");
        System.out.println(input);

    }
}
