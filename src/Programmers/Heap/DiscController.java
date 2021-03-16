package Programmers.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DiscController {


    public static void main(String[] args) {
        int[][] test={{0,10},{2,10},{9,10},{15,2}};
        System.out.println(solution(test));
    }


    private static class Disk{
        int start;
        int len;

        public Disk(int start,int len){
            this.start = start;
            this.len = len;
        }
    }

    private static PriorityQueue<Disk> work = new PriorityQueue<>(new Comparator<Disk>() {
        @Override
        public int compare(Disk o1, Disk o2) {
            return o1.start>=o2.start ? 1:-1;
        }
    });
    private static PriorityQueue<Disk> wait = new PriorityQueue<>(new Comparator<Disk>() {
        @Override
        public int compare(Disk o1, Disk o2) {
            if(o1.len>o2.len){
                return 1;
            }else if(o1.len==o2.len){
                return o1.start>=o2.start ? 1:-1;
            }else{
                return -1;
            }
        }
    });
    public static int solution(int[][] jobs) {

        int[] start = new int[jobs.length];
        for(int[] temp:jobs){
            work.add(new Disk(temp[0],temp[1]));
        }

        int time=0;
        int sum=0;
        int avg;
        while(!work.isEmpty()||!wait.isEmpty()){

            while(!work.isEmpty()){
                if(work.peek().start<=time){
                    wait.add(work.remove());
                }else{
                    break;
                }
            }

            if(!wait.isEmpty()){
                Disk rm = wait.remove();
                time += rm.len;
                sum += time-rm.start;
            }else {
                time++;
            }
        }
        avg = sum/jobs.length;

        return avg;
    }
}
