package coding_test_practice;

import java.util.Stack;

public class Problem4 {
    /*
    Stack 두 개로 Queue 만들기
     */

    static Stack<Integer> st1 = new Stack<>();
    static Stack<Integer> st2 = new Stack<>();
    public static void main(String[] args) {

        addQueue(1);
        addQueue(2);
        addQueue(3);
        addQueue(4);
        addQueue(5);
        System.out.println(popQueue());
        addQueue(4);
        System.out.println(popQueue());
    }

    public static void addQueue(int n) {
        st1.add(n);
    }

    public static Integer popQueue(){
        if(!st2.isEmpty())
            return st2.pop();
        if(st1.isEmpty())
            return null;

        while(!st1.isEmpty()){
            st2.add(st1.pop());
        }

        return st2.pop();
    }


}
