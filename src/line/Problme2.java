package line;

import java.util.Arrays;

public class Problme2 {
    public static void main(String[] args) {

    }
    public static int[] solution(int[] array) {

        int[] answer = new int[array.length];
        Arrays.fill(answer,-1);

        int[] idxArr = new int[100001];
        for(int i=0;i<array.length;i++){
            idxArr[array[i]] = i;
        }

        Arrays.sort(array);



        for(int i=0;i<array.length;i++){
            if(i-1>=0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j] > array[i]) {
                        answer[i] = j;
                        break;
                    }
                }
            }
            if(i+1<array.length){
                for(int j=i+1;j<array.length;j++){
                    if(array[j]>array[i]){
                        if(answer[i]==-1){
                            answer[i] = j;
                            break;
                        }else{
                            if(i-answer[i]>j-i){
                                answer[i] = j;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
