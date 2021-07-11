package coding_test_practice.java_practice;

import java.util.StringTokenizer;

public class StringTokenizerPractice {

    public static void main(String[] args) {

        String test = "123124.12412312,124245235;3421";

        StringTokenizer st = new StringTokenizer(test,".,;",false);

        while(st.hasMoreTokens()){

            String tk = st.nextToken();
            System.out.println(tk);

        }
    }





}
