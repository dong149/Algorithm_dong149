package algorithm;

import java.util.*;

public class PriorityQueueTest {


    public static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
        // o1이 클 때 return 참
        @Override
       public int compare(Integer o1, Integer o2){
           //o2 가 더 클 때가 맞다.
//           return o2-o1;
           // 혹은
           return o2.compareTo(o1);
       }
    });
    public static void main(String[] args) {
        int[] addList = {1,2,3,4,5};
        for(int i=0;i<addList.length;i++){
            pq.add(addList[i]);
        }
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            System.out.println(cur);
        }
    }

}
