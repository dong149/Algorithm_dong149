package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

    // BufferReader 와 StringBuilder 를 사용해보는 Test를 진행합니다.

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n,k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        String str = br.readLine();


        System.out.println(n);
        System.out.println(k);

        System.out.println("Hello Goorm! Your input is " + str);
        sb.append(n).append(k).append(NEW_LINE);
        System.out.println(sb);
    }
}
