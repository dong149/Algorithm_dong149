package Kakao;


/**
 * 2018 카카오 블라인드 [1차] 다트게임
 * 느낀점 : 이런 문제는 일단 구현을 빨리 하는 것을 목표로 하자.
 * toCharArray 꽤나 유용하다.
 **/

public class DartGame2018 {
    public int solution(String dartResult) {
        int answer = 0;

        int cnt = dartResult.length();
        double sum = 0;
        double exTemp = 0;
        for (int i = 0; i < dartResult.length(); ) {
            char tempChar = dartResult.charAt(i);
            if ('0' <= tempChar && tempChar <= '9') {
                double temp;
                temp = (double) (tempChar - '0');
                if(tempChar == '1'&&dartResult.charAt(i+1)=='0'){
                    i++;
                    temp = 10.0;
                }
                char tempArea = dartResult.charAt(i + 1);
                if (tempArea == 'S') {
                    temp = Math.pow(temp, 1);
                } else if (tempArea == 'D') {
                    temp = Math.pow(temp, 2);
                } else {
                    temp = Math.pow(temp, 3);
                }
                sum += temp;
                if (i + 2 < dartResult.length()) {
                    char tempAward = dartResult.charAt(i + 2);
                    if (tempAward == '*') {
                        sum = sum + exTemp + temp;
                        i += 3;
                        exTemp = temp * 2;
                        continue;
                    } else if (tempAward == '#') {
                        sum = sum - temp * 2;
                        i += 3;
                        exTemp = -temp;
                        continue;
                    } else {
                        i += 2;
                    }
                } else {
                    i += 2;
                }
                exTemp = temp;
            }
        }
        answer = (int)sum;

        return answer;
    }
}