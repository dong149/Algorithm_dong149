package kakao.blind2019;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Problem5 {
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] res = solution(nodeinfo);

    }

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Integer> pre = new ArrayList<>();
    static ArrayList<Integer> post = new ArrayList<>();
    public static int[][] solution(int[][] nodeinfo) {
        for(int i=0;i<nodeinfo.length;i++){
            pq.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }
        int[][] answer = new int[2][pq.size()];
        Node root = pq.poll();
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            addNode(root,cur);
        }
        preOrder(root);
        postOrder(root);


        for(int i=0;i<answer[0].length;i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }



        return answer;
    }

    public static void addNode(Node root,Node cur){
        if(root.x>cur.x){
            if(root.left==null){
                root.left = cur;
            }else{
                addNode(root.left,cur);
            }
        }else{
            if(root.right==null){
                root.right = cur;
            }else{
                addNode(root.right,cur);
            }
        }
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        pre.add(root.data);
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        post.add(root.data);

    }

    public static class Node implements Comparable<Node>{
        Node left=null;
        Node right=null;
        int data;
        int x,y;

        public Node(int data,int x,int y){
            this.data = data;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(o.y>this.y){
                return 1;
            }else if(o.y==this.y){
                return this.x-o.x;
            }else{
                return -1;
            }
        }
    }
}
