package boj;
import java.util.*;
public class Boj3568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = sc.nextLine();
        input = input.replaceAll(",","").replaceAll(";","");
        String[] sArr = input.split(" ");
        String df = sArr[0];
        for(int i=1;i<sArr.length;i++){

            Stack<Character> st = new Stack<>();
            boolean check=false;



            String name;
            int k;
            for(k=0;k<sArr[i].length();k++){
                char cur = sArr[i].charAt(k);
                if(!((cur>='a'&&cur<='z')||(cur>='A'&&cur<='Z'))){
                    break;
                }
            }
            name=sArr[i].substring(0,k);
            for(int j=k;j<sArr[i].length();j++) {
                char cur = sArr[i].charAt(j);
                st.push(cur);
            }
            sb.append(df);
            while(!st.isEmpty()){
                char cur = st.pop();
                if(cur==']')
                    cur = '[';
                else if(cur=='[')
                    cur = ']';
                sb.append(cur);
            }
            sb.append(' ').append(name);
            sb.append(';');
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
