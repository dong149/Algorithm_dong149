package boj;




/*
h
hi
run
hello
rerun
running

hi
run
hello
rerun
running

hi
hello
rerun
running
 */
import java.util.*;
public class Boj1141 {
    static String[] sArr;
    static int n;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        sArr = new String[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            sArr[i] = sc.nextLine();
        }

        Arrays.sort(sArr,new Comparator<String>(){
           public int compare(String a,String b){
                if(b.length()<a.length()){
                    return 1;
                }else if(b.length()==a.length()){
                    return a.compareTo(b);
                }else{
                    return -1;
                }
           }
        });
//        for(int i=0;i<n;i++){
//            System.out.println(sArr[i]);
//        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!check(sArr[i],sArr[j])){
                    visited[i]=true;
                }
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static boolean check(String a,String b){
        int lenA = a.length();

        for(int i=0;i<lenA;i++){
            if(a.charAt(i)!=b.charAt(i)){
                return true;
            }
        }
        return false;


    }
}
