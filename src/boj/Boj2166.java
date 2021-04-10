package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj2166 {
    static int n;
    static ArrayList<Node> a = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t1, t2;
            t1 = sc.nextInt();
            t2 = sc.nextInt();
            a.add(new Node(t1, t2));
        }
        long res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += triangle(a.get(0), a.get(i), a.get(i + 1));
        }
        res = Math.abs(res);
        if(res%2==1){
            System.out.println(res/2+".5");
        }else{
            System.out.println(res/2+".0");
        }

    }

    public static long triangle(Node n1, Node n2, Node n3) {
        return (n1.x * n2.y + n2.x * n3.y + n3.x * n1.y) - (n1.x * n3.y + n2.x * n1.y + n3.x * n2.y);
    }

    public static class Node {
        long x, y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
