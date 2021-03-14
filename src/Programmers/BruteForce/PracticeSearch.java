package Programmers.BruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PracticeSearch {


    public static void main(String[] args) {
        int[] test = {1,3,2,4,2,2};
        int[] ans = solution(test);

        for(int temp:ans){
            System.out.println(temp);
        }

    }


    static int[] math1 = {1,2,3,4,5};
    static int[] math2 = {2,1,2,3,2,4,2,5};
    static int[] math3 = {3,3,1,1,2,2,4,4,5,5};

    private static class People implements Comparable<People>{
        int num;
        int res;

        public People(int num,int res){
            this.num=num;
            this.res=res;
        }

        @Override
        public int compareTo(People o) {
            if(o.res<this.res){
                return 1;
            }
            return -1;
        }
    }



    static List<People> list = new ArrayList<>();
    static List<Integer> ans = new ArrayList<>();
    public static int[] solution(int[] answers) {

        list.add(new People(1,solve(math1,answers)));
        list.add(new People(2,solve(math2,answers)));
        list.add(new People(3,solve(math3,answers)));
        Collections.sort(list);
        int max = list.get(2).res;
//        System.out.println("최대값: "+max);
        ans.add(list.get(2).num);
        for(int i=0;i<2;i++){
            if(max == list.get(i).res){
                ans.add(list.get(i).num);
            }
        }
        Collections.sort(ans);

        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }

        return answer;
    }


    private static int solve(int[] math,int[] answer){
        int cnt=0;
        for(int i=0;i<answer.length;i++){
            if(math[i%math.length] == answer[i]){
                cnt++;
            }
        }
//        System.out.print("res: ");
//        System.out.println(cnt);
        return cnt;
    }
}
