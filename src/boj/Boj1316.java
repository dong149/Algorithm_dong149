package boj;
import java.util.*;
public class Boj1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int ans=0;
        for(int i=0;i<n;i++){
            String temp = sc.nextLine();
            if(check(temp)){
                ans++;
            }
        }

        System.out.println(ans);

    }

    public static boolean check(String s){
        boolean[] visited = new boolean['z'-'a'+1];
        for(int i=0;i<s.length();i++){
            if(visited[s.charAt(i)-'a']){
               if(s.charAt(i-1)!=s.charAt(i)){
                   return false;
               }
            }else {
                visited[s.charAt(i) - 'a'] = true;
            }
        }

        return true;


    }
}
