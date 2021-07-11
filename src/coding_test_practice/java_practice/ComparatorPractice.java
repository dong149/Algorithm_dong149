package coding_test_practice.java_practice;

import java.util.*;

public class ComparatorPractice {



    static PriorityQueue<Integer> MaxPQ = new PriorityQueue<>((x1,x2)->Integer.compare(x2,x1));
    static PriorityQueue<Integer> MaxPQ2 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });


    public static void main(String[] args) {

        List<Test> li = new ArrayList<>();
        li.add(new Test(1,2));
        li.add(new Test(2,2));
        li.add(new Test(3,2));
        li.add(new Test(4,3));
        li.add(new Test(4,2));
        li.add(new Test(5,2));
        li.add(new Test(6,2));

        Collections.sort(li);

        for(Test t: li)
            System.out.println(t.x+" "+t.y);



        MaxPQ.add(1);
        MaxPQ.add(2);
        MaxPQ.add(3);
        MaxPQ.add(4);


        MaxPQ2.add(1);
        MaxPQ2.add(2);
        MaxPQ2.add(3);
        MaxPQ2.add(4);

        System.out.println();
        while(!MaxPQ.isEmpty()){
            System.out.println(MaxPQ.poll());
        }

        while(!MaxPQ2.isEmpty()){
            System.out.println(MaxPQ2.poll());
        }
    }





    /*
    x기준 내림차순, x가 같을 때는 y기준 내림차순
     */
    public static class Test implements Comparable<Test>{
        int x;
        int y;


        public Test(int x,int y){
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Test o) {
            if(o.x-this.x>0)
                return 1;
            else if(this.x==o.x) {
                return o.y-this.y;
            } else
                return -1;
        }
    }


}
