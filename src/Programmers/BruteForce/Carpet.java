package Programmers.BruteForce;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        // a*b = brown , (a-2) * (b-2) = y
        int a,b;
        for(a=1;;a++) {
            if((brown+yellow)%a==0){
                b = (brown+yellow)/a;
                if((a-2)*(b-2) == yellow)
                    break;
            }
        }

        int[] answer = new int[2];
        if(b>a){
            a = getItSelf(b,b=a);
        }
        answer[0] = a;
        answer[1] = b;
        return answer;
    }

    private static int getItSelf(int itself, int dummy){
        return itself;
    }
}
