package coding_test_practice;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {
    /*
    Queue 두 개로 Stack 만들기
     */


    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();


    public static void main(String[] args) {
        addStack(1);
        addStack(2);
        addStack(3);
        addStack(4);
        addStack(5);
        System.out.println(popStack());
        addStack(4);
        System.out.println(popStack());

    }


    public static void addStack(int n) {
        q1.add(n);
    }

    public static Integer popStack(){
        if(q1.isEmpty())
            return null;

        while(!(q1.size()==1)){
            q2.add(q1.poll());
        }
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }

        return q1.poll();
    }



}
