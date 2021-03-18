package kakao;


/**
 * 2018 카카오 블라인드 [1차] 비밀지도
 * 느낀점 : Bitwise 연산을 활용할 생각을 하자. / String 을 활용하는 함수들을 많이 알 필요가 있겠다.
 * Integer.toBinaryString(arr[1] | arr[2]) 를 하면 2진수 String으로 바로 만들어버릴 수 있는 쉬운 문제였다.
 * Bitwise 연산 활용
 **/
public class SecretMap2018 {
    char[] twoBase = {'0', '1'};

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            String res = "";
            String temp1 = toNBase(n,arr1[i]);
            String temp2 = toNBase(n,arr2[i]);


            for(int j=0;j<n;j++){
                if(temp1.charAt(j) == twoBase[1]||temp2.charAt(j) == twoBase[1]) res = res + "#";
                else res = res + " ";
            }
            answer[i] = res;
        }
        return answer;
    }



    //2진법으로 변환합니다.
    public String toNBase(int n,int val) {
        int temp = val;
        String res = "";
        while (temp > 0) {
            res = (temp % 2) + res;
            temp /= 2;
        }

        //0을 추가해준다.
        if(res.length()<n){
            int zeroPlus = n-res.length();
            for(int i=0;i<zeroPlus;i++){
                res = "0" + res;
            }
        }
        return res;
    }
}
