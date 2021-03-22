package kick_start_google.round_a_2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n,k;
            String[] temp = br.readLine().split(" ");
            n = Integer.parseInt(temp[0]);
            k = Integer.parseInt(temp[1]);
            String input = br.readLine();
            String left = input.substring(0,n/2);
            String right = input.substring((int)Math.ceil(1.0*n/2),n);



            // reverse right
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer = stringBuffer.append(right).reverse();
            right = stringBuffer.toString();


//            System.out.println(left);
//            System.out.println(right);

            int cnt=0;
            for(int j=0;j<n/2;j++){
                if(left.charAt(j) != right.charAt(j))
                    cnt++;
            }
//            System.out.println(cnt);
            sb.append("Case #").append(i + 1).append(": ").append(Math.abs(k-cnt)).append("\n");
        }

        System.out.println(sb);
    }

}
