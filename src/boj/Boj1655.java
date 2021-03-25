package boj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1655 {



    static PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1<o2){
                return 1;
            }else if(o1.equals(o2)){
                return 0;
            }else{
                return -1;
            }
        }
    });
    static PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1>o2){
                return 1;
            }else if(o1.equals(o2)){
                return 0;
            }else{
                return -1;
            }
        }
    });
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        if(n==1){
            System.out.println(sc.nextInt());
            return;
        }
        if(n==2){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a);
            System.out.println(Math.min(a,b));
            return;
        }
        int a,b;
        a = sc.nextInt();
        b = sc.nextInt();
        if(a>b){
            pqMin.add(a);
            pqMax.add(b);
            sb.append(a).append('\n').append(b).append('\n');
        }else{
            pqMin.add(b);
            pqMax.add(a);
            sb.append(a).append('\n').append(a).append('\n');
        }
        for(int i=2;i<n;i++){
            int temp = sc.nextInt();
            a = pqMax.peek();
            b = pqMin.peek();
            if(i%2==0){
                if(temp>b){
                    pqMax.add(pqMin.poll());
                    pqMin.add(temp);
                }else{
                    pqMax.add(temp);
                }
            }else{
                if(temp<a){
                    pqMin.add(pqMax.poll());
                    pqMax.add(temp);
                }else{
                    pqMin.add(temp);
                }
            }
            sb.append(pqMax.peek()).append('\n');
        }
        System.out.print(sb);

    }



}



