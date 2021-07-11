package coding_test_practice;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


/*
입력된 문자열이 사칙연산이 가능한 문자 “4+2*3-1” 나눗셈은 안들어온다.
결과를 출력
1. 문자열 입력 -> 나누기 X 계산이 가능한 문자열 ( 괄호는 없는지 ? )
2. 계산한 결과를 출력한다.
 */
public class Problem11 {


    public static void main(String[] args) {

        String test = "4+2*3-1";


    }


    //자기 생각 정리
    //Complexity 가 낮은 코드 , 계속 리팩토링
    //읽기 좋은 코드를 만들어내는 것. Full name 을 쓰기

//    public static int calcString(String s){

//        char[] charArr = s.toCharArray();
//        List<Character> charLi = new ArrayList<>();
//        List<Character> charGobLi = new ArrayList<>();
//
//
//        for(char c: charArr){
//            charLi.add(c);
//        }
//
//
//        // 삭제를 할경우 어떻게 해야할지
//        for(int i=0;i<charArr.length;i++){
//            char cur = charArr[i];
//
//            if(cur=='*'){
//                int temp = (charArr[i-1]-'0')*(charArr[i+1]-'0');
//                charArr[i-1] = 'n';
//                charArr[i] = 'n';
//                charArr[i+1] = (char)temp;
//            }
//
//        }








//
//        StringTokenizer st = new StringTokenizer(s,"+*-",true);
//        Stack<Integer> stackInt = new Stack<>();
//        Stack<Character> stackOper = new Stack<>();
//
//
//        List<Integer> liInt = new ArrayList<>();
//        List<Character> liOper = new ArrayList<>();
//
//
//
//        // 4 2 3 1
//        // + * -
//        while(st.hasMoreTokens()){
//
//            String tk = st.nextToken();
//
//            // 연산자일 경우
//            if(tk.matches("[+*-]")){
//                liOper.add(tk.charAt(0));
//            }else{   //숫자일 경우
//                liInt.add(Integer.parseInt(tk));
//            }
//        }
//
//
//        //2*3+4
//        List<Integer> liRes = new ArrayList<>();
//
//
//        for(int i=0;i<liOper.size();i++){
//            if(liOper.get(i)=='*'){
//                liRes.get(i) *
//
//
//                liInt.set(i,liInt.get(i) * liInt.get(i+1));
//                liInt.remove(i+1);
//                liOper.remove(i);
//            }
//        }
//
//        for(int i=0;i<liOper.size();i++){
//            if(liOper.get(i)=='+'||liOper.get(i)=='-'){
//                liInt.set(i,liInt.get(i) * liInt.get(i+1));
//                liInt.remove(i+1);
//                liOper.remove(i);
//            }
//        }



}
